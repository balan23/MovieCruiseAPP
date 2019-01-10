import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieModule } from './modules/movie/movie.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { MatInputModule } from '@angular/material/input'
import { FormsModule } from '@angular/forms';
import { AuthGuardService } from './authGuard.service';
import { AuthenticationModule } from './modules/authentication/authentication.module';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  }
]

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    MovieModule,
    BrowserModule,
    BrowserAnimationsModule, MatToolbarModule,
    MatButtonModule,MatInputModule,
    RouterModule.forRoot(appRoutes),
    MatDialogModule,
    FormsModule,
    AuthenticationModule,
  ],
  providers: [AuthGuardService],
  bootstrap: [AppComponent]
})
export class AppModule { }
