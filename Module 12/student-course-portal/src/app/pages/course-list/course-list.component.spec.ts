import { ComponentFixture, TestBed } from '@angular/core';
import { CourseListComponent } from './course-list.component';
import { provideMockStore, MockStore } from '@ngrx/store/testing';
import { provideHttpClientTesting } from '@angular/common/http/testing';
import { provideHttpClient } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';
import { selectAllCourses } from '../../store/course/course.selectors';
import { selectEnrolledIds } from '../../store/enrollment/enrollment.selectors';

describe('CourseListComponent', () => {
  let component: CourseListComponent;
  let fixture: ComponentFixture<CourseListComponent>;
  let store: MockStore;

  const mockCourses = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' as const },
    { id: 2, name: 'DBMS', code: 'CS102', credits: 3, gradeStatus: 'passed' as const }
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseListComponent],
      providers: [
        provideHttpClient(),
        provideHttpClientTesting(),
        provideMockStore({
          selectors: [
            { selector: selectAllCourses, value: mockCourses },
            { selector: selectEnrolledIds, value: [1] }
          ]
        }),
        {
          provide: ActivatedRoute,
          useValue: {
            queryParamMap: of(new Map([['search', '']]))
          }
        }
      ]
    }).compileComponents();

    store = TestBed.inject(MockStore);
    fixture = TestBed.createComponent(CourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create CourseListComponent', () => {
    expect(component).toBeTruthy();
  });

  it('should select courses from NgRx MockStore', (done) => {
    component.courses$.subscribe(courses => {
      expect(courses.length).toBe(2);
      expect(courses[0].name).toBe('Data Structures');
      done();
    });
  });
});
