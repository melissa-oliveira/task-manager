import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/shared';
import { AuthService } from '../../services/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @ViewChild('loginForm') loginForm!: NgForm;
  user!: User;

  constructor(
    private authService: AuthService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.user = new User(0, '', '', '');
  }

  public submitLogin() {
    if (this.loginForm.form.valid) {
      this.authService.login(this.user.email, this.user.password).subscribe(data => {
        if (data) {
          this.router.navigate(['/task-list']);
          this.user = data;
          this.authService.setCurrentlyUser(this.user);
          console.log(this.authService.getCurrentlyUser())
        }
        else {
          this.user = new User(0, '', '', '');
          this.authService.setCurrentlyUser(data);
        }
      });
    }
  }
}
