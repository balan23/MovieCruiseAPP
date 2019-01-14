import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './User';
import { map } from 'rxjs/operators';
import { Observable } from 'rxjs';

import * as jwt_decode from 'jwt-decode';
export const TOKEN_NAME:string = 'jwt_token';

@Injectable()
export class AuthenticationService {
  
  springEndpoint: string;
  loginUrl: string;
  token: string;

  constructor(private http: HttpClient) {
    
      this.springEndpoint = 'http://localhost:8089/api/v1/userservice';
  }

  registerUser(newUser){
    const url = this.springEndpoint+"/register";
    console.log(newUser);
    return this.http.post(url, newUser, {responseType: 'text'});
  }

  loginUser(newUser){
    const url = this.springEndpoint+"/login";
    console.log(newUser);
    return this.http.post(url, newUser); 
  }

  setToken(token:string){
    return localStorage.setItem(TOKEN_NAME, token);
  }

  getToken(){
    return localStorage.getItem(TOKEN_NAME);
  }

  deleteToken(){
    return localStorage.removeItem(TOKEN_NAME);
  }

  getTokenExpirationDate(token : string) : Date {
    const decoded = jwt_decode(token);
    if(decoded.exp === undefined) {
        return null;
    }
    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
}
isTokenExpired(token? : string) : boolean {
    if (!token) 
      token = this.getToken();
    if (!token) 
      return true;
    const date = this.getTokenExpirationDate(token);
    if(date === undefined || date === null) return false;
    return !(date.valueOf() > new Date().valueOf());
}
}
