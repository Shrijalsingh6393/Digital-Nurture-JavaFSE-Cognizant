import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotificationService } from '../../services/notification.service';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  providers: [NotificationService], // Scoped component-level provider (Hands-On 6 Task 2)
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent {

  constructor(public notificationService: NotificationService) {
    // Add default notification for testing scoped instance
    this.notificationService.addNotification('Welcome to Student Course Portal!');
  }
}
