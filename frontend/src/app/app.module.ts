import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MovieModule } from './modules/movie/movie.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
const appRoutes: Routes =[
  {
    path: '',
    redirectTo:'movies',
    pathMatch: 'full',
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
    MatButtonModule,
    RouterModule.forRoot(appRoutes),
    MatDialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
