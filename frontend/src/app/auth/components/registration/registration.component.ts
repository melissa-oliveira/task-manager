import { Component, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { User } from 'src/app/shared';
import { AuthService } from '../../services/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  @ViewChild('registrationForm') registrationForm!: NgForm;
  user!: User;

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.user = new User(0, '', '', '');
  }

  public submitRregistration() {
    if (this.registrationForm.form.valid) {
      this.authService.insert(this.user).subscribe({
        complete: () => {
          this.router.navigate(['/login']);
        }
      });
    }
  }
}
