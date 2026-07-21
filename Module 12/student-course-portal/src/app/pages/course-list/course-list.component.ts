import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { Course } from '../../models/course.model';
import { CourseService } from '../../services/course.service';
import { EnrollmentService } from '../../services/enrollment.service';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import * as CourseActions from '../../store/course/course.actions';
import * as CourseSelectors from '../../store/course/course.selectors';
import * as EnrollmentActions from '../../store/enrollment/enrollment.actions';
import * as EnrollmentSelectors from '../../store/enrollment/enrollment.selectors';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, FormsModule, CourseCardComponent],
  templateUrl: './course-list.component.html',
  styleUrls: ['./course-list.component.css']
})
export class CourseListComponent implements OnInit {

  courses: Course[] = [];
  courses$: Observable<Course[]>;
  enrolledIds$: Observable<number[]>;
  isLoading: boolean = true;
  selectedCourseId: number | null = null;
  searchTerm: string = '';
  errorMessage: string = '';

  constructor(
    private courseService: CourseService,
    private enrollmentService: EnrollmentService,
    private router: Router,
    private route: ActivatedRoute,
    private store: Store
  ) {
    this.courses$ = this.store.select(CourseSelectors.selectAllCourses);
    this.enrolledIds$ = this.store.select(EnrollmentSelectors.selectEnrolledIds);
  }

  ngOnInit(): void {
    // Hands-On 9 Task 1: Dispatch NgRx load action
    this.store.dispatch(CourseActions.loadCourses());

    // Hands-On 7 Task 1: Read query parameter
    this.route.queryParamMap.subscribe(params => {
      this.searchTerm = params.get('search') || '';
    });

    // Hands-On 3 Task 1 Step 25: Loading simulation
    setTimeout(() => {
      this.courseService.getCourses().subscribe({
        next: data => {
          this.courses = data;
          this.isLoading = false;
        },
        error: err => {
          this.errorMessage = err.message || 'Failed to load courses';
          this.isLoading = false;
        }
      });
    }, 1000);
  }

  /*
   * Performance Explanation for trackBy (Hands-On 3 Task 1 Step 26):
   * Without trackBy, Angular destroys and re-creates all DOM elements in an *ngFor list whenever the array reference or items change.
   * With trackByCourseId, Angular tracks each item by its unique ID, modifying only changed items and preserving existing DOM nodes.
   */
  trackByCourseId(index: number, course: Course): number {
    return course.id;
  }

  onEnroll(courseId: number): void {
    console.log('Enrolling in course:', courseId);
    this.selectedCourseId = courseId;
    if (this.enrollmentService.isEnrolled(courseId)) {
      this.enrollmentService.unenroll(courseId);
      this.store.dispatch(EnrollmentActions.unenrollFromCourse({ courseId }));
    } else {
      this.enrollmentService.enroll(courseId);
      this.store.dispatch(EnrollmentActions.enrollInCourse({ courseId }));
    }
  }

  onSearchChange(): void {
    this.router.navigate(['/courses'], { queryParams: { search: this.searchTerm || null } });
  }

  onCardClick(courseId: number): void {
    this.router.navigate(['/courses', courseId]);
  }

  isEnrolled(courseId: number): boolean {
    return this.enrollmentService.isEnrolled(courseId);
  }
}
