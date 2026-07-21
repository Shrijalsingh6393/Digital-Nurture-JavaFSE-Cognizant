import { Component, OnInit, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { CourseService } from '../../services/course.service';
import { NotificationComponent } from '../../components/notification/notification.component';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink, NotificationComponent],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit, OnDestroy {

  portalName: string = 'Student Course Portal';
  isPortalActive: boolean = true;
  message: string = '';
  searchTerm: string = '';
  availableCoursesCount: number = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    // Hands-On 2 Task 2 Step 16: Fetch available courses count and log
    const courses = this.courseService.getCoursesSync();
    this.availableCoursesCount = courses.length;
    console.log('HomeComponent initialised — courses loaded');
  }

  ngOnDestroy(): void {
    // Hands-On 2 Task 2 Step 17: Log when component is destroyed on navigation
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }

  /*
   * Difference between [property] and [(ngModel)]:
   * [property] is a one-way binding (Component -> DOM). It passes values from TypeScript to HTML elements.
   * [(ngModel)] is a two-way binding (DOM <-> Component). It syncs changes from input elements back to TypeScript instantly while updating the view.
   */
}
