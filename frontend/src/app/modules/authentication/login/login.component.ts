import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../User';
import { AuthenticationService } from '../authentication.service';
import { MatSnackBar } from '@angular/material';
import { HttpErrorResponse } from '@angular/common/http';
import { MatCardModule } from '@angular/material';
@Component({
  selector: 'user-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  user: User;
  displayMessage: string;
  errorMessage: string;
  constructor(private authService: AuthenticationService, private router: Router) {
    this.user = new User();
  }
  ngOnInit() {
  }

  loginUser() {
    this.authService.loginUser(this.user).subscribe((data) => {
      if (data['token']) {
        this.authService.setToken(data['token']);
        this.router.navigate(['/movies/popular']);
      }
    }, (error) => {
      if (error instanceof HttpErrorResponse) {
        if (error.status === 401)
          this.errorMessage = "Invalid credentials.";
        else
          this.errorMessage = "Technical difficulties. Please try again.";
      }
    })
  }
}