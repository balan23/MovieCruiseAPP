import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators/map';
import { Observable } from 'rxjs/Observable'
import { Movie } from './movie';
import { retry } from 'rxjs/operators'
@Injectable()
export class MovieService {
  tmdbEndPoint: string ;
  imagePrefix: string ;
  apiKey: string;
  watchListEndPoint: string;
  springEndPoint: string;

  constructor(private http: HttpClient) { 
    this.apiKey ='api_key=e6d3b27023d42d6684fbd8e6c8bb8dd5';
    this.tmdbEndPoint = 'https://api.themoviedb.org/3/movie';
    this.imagePrefix = 'https://image.tmdb.org/t/p/w500';
    this.watchListEndPoint= 'http://localhost:3000/posts';

    this.springEndPoint ='http://localhost:8080/movies';
 

  }

  getMovies(type: string, page: number=1): Observable<Array<Movie>>{
    const endPoint=`${this.tmdbEndPoint}/${type}?${this.apiKey}&page=${page}`;
    return this.http.get(endPoint).pipe(
      retry(3),
       map(this.pickMovieResults),
       map(this.transformPosterPath.bind(this))
     );
     
  }



transformPosterPath(movies): Array<Movie> {
 return movies.map(movie => {
    //movie.poster_path= `S{this.imagePrefix}${movie.poster_path}`;
    //console.log(this.imagePrefix);
    movie.poster_path= this.imagePrefix+''+movie.poster_path;
    return movie;
  })
}

pickMovieResults(response){
  return response['results'];

}

addMovieToWatchlist(movie){
return this.http.post("http://localhost:8080/movies/save", movie);
}

getWatchListedMovies(): Observable<Array<Movie>> {
  return this.http.get<Array<Movie>>("http://localhost:8080/movies/all");
}


deleteMovie(movie: Movie){
  var url1=  '';
  const    url= url1.concat(this.springEndPoint,'/delete/',movie.id);
console.log(url);
  return this.http.delete(url,{responseType:'text'});

}
}
