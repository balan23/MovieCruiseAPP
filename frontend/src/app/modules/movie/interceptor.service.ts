import { Injectable } from '@angular/core';
import { HttpRequest, HttpEvent, HttpHandler, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthenticationService } from './../authentication/authentication.service';
export const TOKEN_NAME : string = "jwt_token";

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
    
    constructor(private authService : AuthenticationService ) {
        
    }

    intercept (request : HttpRequest<any>, next : HttpHandler) : Observable<HttpEvent<any>> {
        request = request.clone({
            setHeaders : {
                Authorization : `Bearer ${this.authService.getToken()}`
            }
        });
        return next.handle(request);
    }
}