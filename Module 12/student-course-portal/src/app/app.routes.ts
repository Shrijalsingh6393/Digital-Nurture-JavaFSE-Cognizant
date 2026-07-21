import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { CourseListComponent } from './pages/course-list/course-list.component';
import { CourseDetailComponent } from './pages/course-detail/course-detail.component';
import { StudentProfileComponent } from './pages/student-profile/student-profile.component';
import { NotFoundComponent } from './pages/not-found/not-found.component';
import { EnrollmentFormComponent } from './pages/enrollment-form/enrollment-form.component';
import { ReactiveEnrollmentFormComponent } from './pages/reactive-enrollment-form/reactive-enrollment-form.component';
import { authGuard } from './guards/auth.guard';
import { unsavedChangesGuard } from './guards/unsaved-changes.guard';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'courses/:id', component: CourseDetailComponent },
  { path: 'enroll', component: EnrollmentFormComponent },
  { path: 'enroll-reactive', component: ReactiveEnrollmentFormComponent, canDeactivate: [unsavedChangesGuard] },
  // Hands-On 7 Task 2: Lazy loading feature route
  {
    path: 'enroll-feature',
    loadChildren: () => import('./features/enrollment/enrollment.routes').then(m => m.ENROLLMENT_ROUTES)
  },
  { path: 'profile', component: StudentProfileComponent, canActivate: [authGuard] },
  // Wildcard 404 route must be last
  { path: '**', component: NotFoundComponent }
];
