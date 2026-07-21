import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of, throwError } from 'rxjs';
import { map, catchError, tap, retry } from 'rxjs/operators';
import { Course } from '../models/course.model';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private apiUrl = 'http://localhost:3000/courses';

  private initialCourses: Course[] = [
    { id: 1, name: 'Data Structures & Algorithms', code: 'CS101', credits: 4, gradeStatus: 'passed' },
    { id: 2, name: 'Database Management Systems', code: 'CS102', credits: 3, gradeStatus: 'passed' },
    { id: 3, name: 'Web Application Development with Angular', code: 'CS103', credits: 4, gradeStatus: 'pending' },
    { id: 4, name: 'Software Engineering Principles', code: 'CS104', credits: 3, gradeStatus: 'passed' },
    { id: 5, name: 'Cloud Computing Fundamentals', code: 'CS105', credits: 2, gradeStatus: 'failed' }
  ];

  constructor(private http: HttpClient) {}

  // Synchronous fallback method
  getCoursesSync(): Course[] {
    return this.initialCourses;
  }

  // Hands-On 8: HttpClient GET with RxJS operators (map, tap, catchError, retry)
  getCourses(): Observable<Course[]> {
    return this.http.get<Course[]>(this.apiUrl).pipe(
      // retry up to 2 times on failure before propagating error
      retry(2),
      // tap operator for side effect (logging) without modifying data stream
      tap(courses => console.log('Courses loaded via HTTP:', courses.length)),
      // map operator to filter or transform if needed
      map(courses => courses.filter(c => c.credits > 0)),
      catchError(err => {
        console.error('Error fetching courses:', err);
        // Fallback to local initialCourses on API error
        return of(this.initialCourses);
      })
    );
  }

  getCourseById(id: number): Observable<Course> {
    return this.http.get<Course>(`${this.apiUrl}/${id}`).pipe(
      catchError(err => {
        const found = this.initialCourses.find(c => c.id === id);
        if (found) return of(found);
        return throwError(() => new Error(`Course with ID ${id} not found.`));
      })
    );
  }

  createCourse(course: Omit<Course, 'id'>): Observable<Course> {
    return this.http.post<Course>(this.apiUrl, course).pipe(
      catchError(err => {
        const newCourse: Course = { ...course, id: Date.now() };
        this.initialCourses.push(newCourse);
        return of(newCourse);
      })
    );
  }

  updateCourse(id: number, course: Partial<Course>): Observable<Course> {
    return this.http.put<Course>(`${this.apiUrl}/${id}`, course);
  }

  deleteCourse(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
