import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {User} from '../User';
import {AuthenticationService} from './../authentication.service';
import { MatSnackBar } from '@angular/material';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'user-registration',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser : User;
  displayMessage : string;
  errorMessage : string;

  constructor(private authService : AuthenticationService, private router : Router,
    private snackBar : MatSnackBar) { 
    this.newUser = new User();
  }

  ngOnInit() {
  }

  registerUser() {
    this.authService.registerUser(this.newUser).subscribe((response) => {
      console.log("User Registered!");
      console.log("User Data:", response);
      this.displayMessage = "User registered successfully!";
      this.snackBar.open(this.displayMessage, '', {
        duration : 1000
      });
      this.router.navigate(['/login']);
    }, (error) => {
      if (error instanceof HttpErrorResponse) {
        if (error.status === 409)
          this.errorMessage = "User ID already exists";
        else
          this.errorMessage = "Technical difficulties. Conatct Administrator or Try again Later.";
      }
    })
  }
}