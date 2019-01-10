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
  searchUrl: string;
  constructor(private http: HttpClient) { 
    this.apiKey ='api_key=e6d3b27023d42d6684fbd8e6c8bb8dd5';
    this.tmdbEndPoint = 'https://api.themoviedb.org/3/movie';
    this.imagePrefix = 'https://image.tmdb.org/t/p/w500';
    this.watchListEndPoint= 'http://localhost:3000/posts';

    this.springEndPoint ='http://localhost:8080/api/v1/movieservice';
    this.searchUrl ='https://api.themoviedb.org/3/search/movie?';
 

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
return this.http.post("http://localhost:8080/api/v1/movieservice/save", this.convertMovieBE(movie));
}

getWatchListedMovies(): Observable<Array<Movie>> {

  return this.http.get<Array<Movie>>("http://localhost:8080/api/v1/movieservice/all").pipe(
    retry(3),
    map(this.convertBEMovieToWL.bind(this))
  );
}


convertBEMovieToWL(movies){
return movies.map(movie=> {
  movie.poster_path= movie.posterPath;
  movie.overview = movie.movieComments;
  movie.movieId = movie.id;
  return movie;
})
}

deleteMovie(movie: Movie){
  var url1=  '';
  const    url= url1.concat(this.springEndPoint,'/delete/',movie.movieId);
console.log(url);
  return this.http.delete(url,{responseType:'text'});

}

convertMovieBE(movie){

  movie.movieName = movie.title;
  movie.movieComments= movie.overview;
  movie.posterPath = movie.poster_path;
  return movie;

}

updateComments(movie){
  var url1=  '';
  const    url= url1.concat(this.springEndPoint,'/update');
  console.log(movie.title,'update to list');
  return this.http.put(url, movie);

}

searchMovies(searchKey, page:number =5): Observable<Array<Movie>> {
  if(searchKey.length>0){
    const url=`${this.searchUrl}${this.apiKey}&page=${page}&include_adult=false&query=${searchKey}`;
    return this.http.get(url).pipe(
      retry(3),
      map(this.pickMovieResults),
      map(this.transformPosterPath.bind(this))
    );
  }
}


}
