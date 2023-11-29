import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/services/auth-service.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from './shared';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Task Manager';

  constructor(
    private router: Router,
    private authService: AuthService) { }

  currentlyUser(): User {
    return this.authService.getCurrentlyUser();
  }
}
