import { Component } from '@angular/core';
import { AuthenticationService } from './modules/authentication/authentication.service';
import {Router} from '@angular/router'

@Component({
  selector: 'app-root',
  templateUrl:'./app.component.html',
  styles: []
})

export class AppComponent {
  title = 'app';
  constructor(private authService: AuthenticationService, private router: Router) {

  }

  logout(){
    this.authService.deleteToken();
    console.log("loggedOut");
    this.router.navigate(['/login']);
  }
}