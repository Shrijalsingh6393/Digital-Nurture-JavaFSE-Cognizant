import { TestBed } from '@angular/core/testing';
import { CourseService } from './course.service';
import { provideHttpClient } from '@angular/common/http';
import { HttpTestingController, provideHttpClientTesting } from '@angular/common/http/testing';
import { Course } from '../models/course.model';

describe('CourseService', () => {
  let service: CourseService;
  let httpMock: HttpTestingController;

  const mockCourses: Course[] = [
    { id: 1, name: 'Data Structures', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'DBMS', code: 'CS102', credits: 3, gradeStatus: 'passed' }
  ];

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        CourseService,
        provideHttpClient(),
        provideHttpClientTesting()
      ]
    });
    service = TestBed.inject(CourseService);
    httpMock = TestBed.inject(HttpTestingController);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('should fetch courses via GET HTTP request', () => {
    service.getCourses().subscribe(courses => {
      expect(courses.length).toBe(2);
      expect(courses).toEqual(mockCourses);
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('GET');
    req.flush(mockCourses);
  });

  it('should create a course via POST HTTP request', () => {
    const newCourse: Omit<Course, 'id'> = {
      name: 'Algorithms',
      code: 'CS105',
      credits: 4,
      gradeStatus: 'pending'
    };

    service.createCourse(newCourse).subscribe(course => {
      expect(course.id).toBe(3);
      expect(course.name).toBe('Algorithms');
    });

    const req = httpMock.expectOne('http://localhost:3000/courses');
    expect(req.request.method).toBe('POST');
    req.flush({ ...newCourse, id: 3 });
  });
});
