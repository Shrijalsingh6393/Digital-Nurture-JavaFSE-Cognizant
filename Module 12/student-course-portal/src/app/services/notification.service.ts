import { Injectable } from '@angular/core';

// Note: Provided at component level in NotificationComponent (providers: [NotificationService])
// Demonstrates scoped DI hierarchy (new separate instance per component instantiation)
@Injectable()
export class NotificationService {

  private notifications: string[] = [];

  addNotification(message: string): void {
    this.notifications.push(message);
  }

  getNotifications(): string[] {
    return [...this.notifications];
  }

  clear(): void {
    this.notifications = [];
  }
}
