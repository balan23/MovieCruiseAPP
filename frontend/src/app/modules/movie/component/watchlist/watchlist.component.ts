import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../movie.service';
import { Movie } from '../../movie';
import { MatSnackBar } from '@angular/material/snack-bar'
@Component({
  selector: 'movie-watchlist',
  template: `<movie-container [movies]="movies" [useWatchListApi]= "useWatchListApi"></movie-container>
  `,
  styles: []
})
export class WatchlistComponent implements OnInit {

  movies: Array<Movie>;
  useWatchListApi = true;
  constructor(private movieService: MovieService,  private snackBar: MatSnackBar) { 
    this.movies =[];
  }

  ngOnInit() {
    let message='watchlist is empty. Kindly add new movies';
    this.movieService.getWatchListedMovies().subscribe((movies)=>{
      if(movies.length === 0){
        this.snackBar.open(message,'',{
          duration: 1000
        });
      }
      this.movies.push(...movies);
    }
  )
  }

}
