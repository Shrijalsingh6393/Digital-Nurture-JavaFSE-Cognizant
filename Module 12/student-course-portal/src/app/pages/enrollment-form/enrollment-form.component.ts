import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, NgForm } from '@angular/forms';

@Component({
  selector: 'app-enrollment-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './enrollment-form.component.html',
  styleUrls: ['./enrollment-form.component.css']
})
export class EnrollmentFormComponent {

  submitted: boolean = false;

  onSubmit(form: NgForm): void {
    if (form.valid) {
      console.log('Template-Driven Form Value:', form.value);
      console.log('Template-Driven Form Valid:', form.valid);
      this.submitted = true;
    }
  }

  onReset(form: NgForm): void {
    form.resetForm();
    this.submitted = false;
  }
}
