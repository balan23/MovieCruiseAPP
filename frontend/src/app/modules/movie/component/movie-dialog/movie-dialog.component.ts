import { Component, OnInit, Inject } from '@angular/core';
import { Movie } from '../../movie';
import { MovieService }from '../../movie.service';
import { MatSnackBar, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
@Component({
  selector: 'movie-movie-dialog',
  templateUrl: './movie-dialog.component.html',
  styleUrls: ['./movie-dialog.component.css']
})
export class MovieDialogComponent implements OnInit {

  movie: Movie;
  comments: string;
  actionType: string;


  constructor(public sbar: MatSnackBar, public dialogRef: MatDialogRef<MovieDialogComponent>,
  @Inject(MAT_DIALOG_DATA) public  data: any, private movieSvc : MovieService) {
    this.comments= data.obj.movieComments;
    this.movie = data.obj;
    this.actionType= data.actionType;
   }

  ngOnInit() {
    console.log(this.data);
  }

  onNoClick(){
    this.dialogRef.close();

  }
  updateComments(){
    console.log(this.comments);
    this.movie.movieComments= this.comments;
    this.dialogRef.close();
    this.movieSvc.updateComments(this.movie).subscribe(movie=>{
      this.sbar.open("Comments updated","", {
        duration: 2000,
      });
    })
  }

}
