import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseCardComponent } from './course-card.component';
import { By } from '@angular/platform-browser';
import { SimpleChange } from '@angular/core';

describe('CourseCardComponent', () => {
  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;

  const mockCourse = {
    id: 1,
    name: 'Data Structures',
    code: 'CS101',
    credits: 4,
    gradeStatus: 'passed' as const
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCardComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
  });

  // Task 1 (Step 102): Should create test
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // Task 1 (Step 103): @Input rendering test
  it('should render course title from @Input() course', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    const titleElement = fixture.debugElement.query(By.css('h3')).nativeElement;
    expect(titleElement.textContent).toContain('Data Structures');
  });

  // Task 1 (Step 104): @Output event emission test
  it('should emit enrollRequested event with course ID when Enroll button is clicked', () => {
    component.course = mockCourse;
    fixture.detectChanges();

    spyOn(component.enrollRequested, 'emit');
    const button = fixture.debugElement.query(By.css('.btn-primary')).nativeElement;
    button.click();
    fixture.detectChanges();

    expect(component.enrollRequested.emit).toHaveBeenCalledWith(1);
  });

  // Task 1 (Step 105): ngOnChanges test
  it('should log previous and current values in ngOnChanges', () => {
    spyOn(console, 'log');
    const change = new SimpleChange(null, mockCourse, true);

    component.ngOnChanges({
      course: change
    });

    expect(console.log).toHaveBeenCalledWith(
      'CourseCardComponent ngOnChanges — Previous:',
      undefined,
      'Current:',
      mockCourse
    );
  });
});
