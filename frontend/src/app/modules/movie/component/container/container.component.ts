import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../../movie';
import { MovieService } from '../../movie.service';
import { ActivatedRoute } from '@angular/router'
import { MatSnackBar } from '@angular/material/snack-bar'
@Component({
  selector: 'movie-container',
  templateUrl: './container.component.html',
  styleUrls: ['./container.component.css']
})
export class ContainerComponent implements OnInit {
@Input()
movies : Array<Movie>;

@Input()
useWatchListApi : boolean;
  constructor(private movieService: MovieService, private snackBar: MatSnackBar) {
   }

  ngOnInit() {
  }
 addMovieToWatchList(movie){
   let message= `${movie.title} added to watchlist.`;
   console.log(movie);
       this.movieService.addMovieToWatchlist(movie).subscribe((movie)=>{
        console.log('movie2222');
        console.log(movie);

      this.snackBar.open(message,'',{
        duration: 1000
      });
    });
 }


 

 deleteFromWatchList(movie){
  let message= `${movie.title} deleted from watchlist.`;
   for(var i=0;i<this.movies.length;i++){
     if(this.movies[i].id == movie.id){
       this.movies.splice(i,1);
     }

   }
 this.movieService.deleteMovie(movie).subscribe((movie)=>{

  this.snackBar.open(message,'',{
    duration: 1000
  });
  
 })
 }
}
