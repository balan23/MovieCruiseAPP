import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  template: `
  <mat-toolbar color="primary">
    <span> Movie Cruise App</span>
    <button mat-button [routerLink] = "['/movies/popular']">Popular Movie</button>
    <button mat-button [routerLink] = "['/movies/top_rated']">Top Rated Movie</button>
    <button mat-button [routerLink] = "['/movies/watchlist']">Watchlisted Movie</button>
    <button mat-button [routerLink] = "['/movies/search']">Search Movie</button>
  </mat-toolbar>
  <router-outlet></router-outlet>
     
  `,
  styles: []
})
export class AppComponent {
  title = 'app';
}
