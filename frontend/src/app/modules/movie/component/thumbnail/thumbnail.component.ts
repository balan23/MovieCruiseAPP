import { Component, OnInit, Input } from '@angular/core';
import { Movie } from '../../movie';
import { HttpClient } from '@angular/common/http';
import { MovieService} from '../../movie.service'
import { MatSnackBar } from '@angular/material/snack-bar'
import { Output , EventEmitter } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
//import { EventEmitter } from '@angular/core/src/event_emitter';
@Component({
  selector: 'movie-thumbnail',
  templateUrl: './thumbnail.component.html',
  styleUrls: ['./thumbnail.component.css']
})
export class ThumbnailComponent implements OnInit {
  @Input()
  movie: Movie;

  @Input()
  useWatchListApi: boolean;

  @Output()
  addMovie = new EventEmitter();

  @Output()
  deleteMovie = new EventEmitter();

  @Output()
  updateMovie = new EventEmitter();

  constructor(private movieService: MovieService, private snackBar: MatSnackBar) { 

   }

  ngOnInit() {

  }
  addToWatchList(){
  this.addMovie.emit(this.movie);

    // this.movieService.addMovieToWatchlist(this.movie).subscribe((movie)=>{
    //   console.log(movie);
    //   this.snackBar.open(' Movie added to watch list','',{
    //     duration: 1000
    //   });
    // });
  }

  deleteFromWatchList(){
  this.deleteMovie.emit(this.movie);
  }


  updateFromWatchList(){
    this.updateMovie.emit
  }

}
