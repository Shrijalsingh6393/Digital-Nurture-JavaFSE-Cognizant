import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../models/course.model';
import { CreditLabelPipe } from '../../pipes/credit-label.pipe';
import { HighlightDirective } from '../../directives/highlight.directive';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, CreditLabelPipe, HighlightDirective],
  templateUrl: './course-card.component.html',
  styleUrls: ['./course-card.component.css']
})
export class CourseCardComponent implements OnChanges {

  @Input() course!: Course;
  @Input() isEnrolled: boolean = false;
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded: boolean = false;

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['course']) {
      console.log('CourseCardComponent ngOnChanges — Previous:', changes['course'].previousValue, 'Current:', changes['course'].currentValue);
    }
  }

  onEnrollClick(): void {
    if (this.course) {
      this.enrollRequested.emit(this.course.id);
    }
  }

  toggleDetails(): void {
    this.isExpanded = !this.isExpanded;
  }

  get cardClasses() {
    return {
      'card': true,
      'card--enrolled': this.isEnrolled,
      'card--full': this.course && this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  get borderStyle() {
    if (!this.course) return {};
    let color = '#94a3b8';
    if (this.course.gradeStatus === 'passed') color = '#10b981';
    if (this.course.gradeStatus === 'failed') color = '#ef4444';
    if (this.course.gradeStatus === 'pending') color = '#f59e0b';
    return { 'border-left': `6px solid ${color}` };
  }
}
