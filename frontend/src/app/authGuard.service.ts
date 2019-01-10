import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { CanActivate } from '@angular/router/src/interfaces';
import { AuthenticationService } from './modules/authentication/authentication.service';
export const TOKEN_NAME : string = "jwt_token";
@Injectable()
export class AuthGuardService implements CanActivate {
    constructor(private router : Router, private authService : AuthenticationService ) {
        
       }
    canActivate() {
        if(!this.authService.isTokenExpired()) {
            return true;
        }
        this.router.navigate(['./login']);
        return false;
    }
}