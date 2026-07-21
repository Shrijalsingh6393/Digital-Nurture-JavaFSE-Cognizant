import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EnrollmentService } from '../../services/enrollment.service';
import { Course } from '../../models/course.model';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe],
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {

  student = {
    id: 1,
    name: 'Alex Mercer',
    email: 'alex.mercer@student.edu',
    gpa: 3.8
  };

  enrolledCourses: Course[] = [];

  constructor(private enrollmentService: EnrollmentService) {}

  ngOnInit(): void {
    // Hands-On 6 Task 2 Step 66: Display enrolled courses from EnrollmentService
    this.enrolledCourses = this.enrollmentService.getEnrolledCourses();
  }
}
