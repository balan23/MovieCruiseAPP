import { Component, OnInit } from '@angular/core';
import { Movie } from '../../movie';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'movie-thumbnail',
  templateUrl: './thumbnail.component.html',
  styles: []
})
export class ThumbnailComponent implements OnInit {
  movies: Array<Movie>;
  tmdbEndPoint: string ;
  imagePrefix: string ;
  constructor(private http: HttpClient) { 
    this.movies= [];
    this.tmdbEndPoint='https://api.themoviedb.org/3/movie/popular?api_key=e6d3b27023d42d6684fbd8e6c8bb8dd5&page=1';
    this.imagePrefix= 'https://image.tmdb.org/t/p/w500';
  }

  ngOnInit() {
    this.http.get(this.tmdbEndPoint).subscribe((res) =>{
      const movies = res['results'].map(movie => {
        console.log(this.imagePrefix);
        movie.poster_path = `${this.imagePrefix}${movie.poster_path}`;
        console.log(movie.poster_path);
        return movie;
      });
      this.movies.push(...movies);
    });    
  }

}
