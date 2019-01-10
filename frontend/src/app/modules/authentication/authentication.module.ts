import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';

import { AuthenticationRouterModule }  from './authentication-router.module';

import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatFormFieldModule, MatIcon } from '@angular/material';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    AuthenticationRouterModule,
    MatFormFieldModule,
    MatIconModule,
    HttpClientModule,
    MatCardModule,
    MatButtonModule,
    MatSnackBarModule,
    MatDialogModule,
    MatInputModule,
  ],

  declarations: [
    RegisterComponent,
    LoginComponent,
  ],

  exports:[
    FormsModule,
    RegisterComponent,
    LoginComponent,
  ],

  providers:[
    AuthenticationService,
  ],
  entryComponents: [
  ],
})
export class AuthenticationModule { }
