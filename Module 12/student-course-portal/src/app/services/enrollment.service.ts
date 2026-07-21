import { Injectable } from '@angular/core';
import { CourseService } from './course.service';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {

  private enrolledCourseIds: number[] = [1, 2]; // Initial enrolled course IDs

  constructor(private courseService: CourseService) {}

  enroll(courseId: number): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number): void {
    const index = this.enrolledCourseIds.indexOf(courseId);
    if (index > -1) {
      this.enrolledCourseIds.splice(index, 1);
    }
  }

  isEnrolled(courseId: number): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  getEnrolledCourseIds(): number[] {
    return [...this.enrolledCourseIds];
  }

  getEnrolledCourses(): Course[] {
    const allCourses = this.courseService.getCoursesSync();
    return allCourses.filter(c => this.enrolledCourseIds.includes(c.id));
  }
}
