import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { CourseService } from '../../services/course.service';
import { Course } from '../../models/course.model';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';

@Component({
  selector: 'app-course-detail',
  standalone: true,
  imports: [CommonModule, RouterLink, CreditLabelPipe],
  templateUrl: './course-detail.component.html',
  styleUrls: ['./course-detail.component.css']
})
export class CourseDetailComponent implements OnInit {

  course: Course | null = null;
  errorMessage: string = '';

  constructor(
    private route: ActivatedRoute,
    private courseService: CourseService
  ) {}

  ngOnInit(): void {
    // Hands-On 7 Task 1 Step 69: Read route parameter :id
    const idParam = this.route.snapshot.paramMap.get('id');
    if (idParam) {
      const courseId = Number(idParam);
      this.courseService.getCourseById(courseId).subscribe({
        next: data => this.course = data,
        error: err => this.errorMessage = err.message
      });
    }
  }
}
