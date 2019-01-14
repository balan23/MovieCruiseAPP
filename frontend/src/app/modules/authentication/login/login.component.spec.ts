import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';
import {Router} from '@angular/router'
import {User} from '../User';
import {AuthenticationService} from '../authentication.service'
import { Location } from '@angular/common';
import { Observable } from 'rxjs/Observable';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterTestingModule } from '@angular/router/testing';
import { MatFormField, MatInputModule, MatButtonModule, MatFormFieldModule } from '@angular/material';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { By } from '@angular/platform-browser';

const testConfig = {
  userData:{
    firstName:'Manobalan',
    lastName:'Mayon',
    userId:'bala2020',
    password:'password'
  }
}

describe('LoginComponent', () => {
  let loginComponent: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let authService: AuthenticationService;
  let spyUser:any;
  let routes:Router;
  let location : Location;

  class AuthServiceStub{
    curUser:any;
    hide:any;
    constructor(){

    }

  }
  class dummy{

  }

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [FormsModule, HttpClientModule,BrowserAnimationsModule, MatFormFieldModule, MatInputModule, MatButtonModule,
      RouterTestingModule.withRoutes([{path:'',component:dummy}])],
      providers:[{provide:AuthenticationService,useClass:AuthServiceStub}]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    routes = TestBed.get(Router);
    location = TestBed.get(Location);
    fixture = TestBed.createComponent(LoginComponent);
    loginComponent = fixture.componentInstance;
    fixture.detectChanges();
    fixture.debugElement.injector.get(AuthenticationService);
  });

  it('should create', () => {
    expect(loginComponent).toBeTruthy();
  });

  it('should have userid password input and  Login register Button', () => {
    let userId = fixture.debugElement.query(By.css('.inputID'));
    let password = fixture.debugElement.query(By.css('.inputPass'));
    let login = fixture.debugElement.query(By.css('.login-user'));
    let register = fixture.debugElement.query(By.css('.register-button'));

    let userIdInput = userId.nativeElement;
    let passwordInput = password.nativeElement;
    let loginButt = login.nativeElement;
    let registerButt = register.nativeElement;
    expect(userIdInput).toBeTruthy();
    expect(passwordInput).toBeTruthy();
    expect(loginButt).toBeTruthy();
    expect(registerButt).toBeTruthy();
  });
});
