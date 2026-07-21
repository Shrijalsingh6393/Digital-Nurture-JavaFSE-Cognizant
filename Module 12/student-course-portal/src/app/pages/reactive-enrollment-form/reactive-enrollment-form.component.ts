import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, FormGroup, FormArray, FormControl, Validators, AbstractControl, ValidationErrors } from '@angular/forms';
import { ComponentCanDeactivate } from '../../guards/unsaved-changes.guard';

// Custom Synchronous Validator (Hands-On 5 Task 2 Step 53)
export function noCourseCode(control: AbstractControl): ValidationErrors | null {
  if (control.value && typeof control.value === 'string' && control.value.toUpperCase().startsWith('XX')) {
    return { noCourseCode: true };
  }
  return null;
}

// Custom Async Validator (Hands-On 5 Task 2 Step 55)
export function simulateEmailCheck(control: AbstractControl): Promise<ValidationErrors | null> {
  return new Promise((resolve) => {
    setTimeout(() => {
      if (control.value && control.value.includes('test@')) {
        resolve({ emailTaken: true });
      } else {
        resolve(null);
      }
    }, 800);
  });
}

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrls: ['./reactive-enrollment-form.component.css']
})
export class ReactiveEnrollmentFormComponent implements OnInit, ComponentCanDeactivate {

  enrollForm!: FormGroup;
  submitted: boolean = false;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {
    // Hands-On 5 Task 1 Step 49: Build reactive form with FormBuilder
    this.enrollForm = this.fb.group({
      studentName: ['', [Validators.required, Validators.minLength(3)]],
      studentEmail: ['', [Validators.required, Validators.email], [simulateEmailCheck]],
      courseId: ['', [Validators.required, noCourseCode]],
      preferredSemester: ['Odd', Validators.required],
      agreeToTerms: [false, Validators.requiredTrue],
      additionalCourses: this.fb.array([])
    });
  }

  // Hands-On 5 Task 2 Step 57: Typed getter for FormArray
  get additionalCourses(): FormArray {
    return this.enrollForm.get('additionalCourses') as FormArray;
  }

  addCourseControl(): void {
    this.additionalCourses.push(new FormControl('', Validators.required));
  }

  removeCourseControl(index: number): void {
    this.additionalCourses.removeAt(index);
  }

  onSubmit(): void {
    if (this.enrollForm.valid) {

      // Difference between form.value (excludes disabled controls) and form.getRawValue() (includes all controls)
      console.log('Reactive Form value:', this.enrollForm.value);
      console.log('Reactive Form getRawValue():', this.enrollForm.getRawValue());
      this.submitted = true;
      this.enrollForm.markAsPristine();
    }
  }

  canDeactivate(): boolean {
    if (this.enrollForm.dirty && !this.submitted) {
      return window.confirm('You have unsaved changes. Leave?');
    }
    return true;
  }
}
