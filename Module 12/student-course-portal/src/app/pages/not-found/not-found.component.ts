import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [RouterLink],
  template: `
    <div class="container text-center">
      <h1>404 — Page Not Found</h1>
      <p>The page you are looking for does not exist on the Student Course Portal.</p>
      <a routerLink="/" class="btn-primary" style="display: inline-block; margin-top: 1rem; text-decoration: none;">Return to Home</a>
    </div>
  `
})
export class NotFoundComponent {}
