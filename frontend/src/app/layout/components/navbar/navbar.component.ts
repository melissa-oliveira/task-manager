import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/auth/services/auth-service.service';
import { User } from 'src/app/shared';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  currentlyUser!: User;

  constructor(
    private authService: AuthService,
    private router: Router,
    ) { }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
