import { Component, OnInit } from '@angular/core';
import { Movie } from '../../movie';
import { MovieService} from '../../movie.service';
@Component({
  selector: 'movie-search',
  templateUrl : './search.component.html',
  styleUrls : ['./search.component.css']
})
export class SearchComponent implements OnInit {

  movies: Array<Movie>;

  constructor(private movSvc : MovieService) { }

  ngOnInit() {
  }
  onEnter(searchKey){
    console.log('searchKey',searchKey);
    this.movSvc.searchMovies(searchKey).subscribe(movies =>{
      this.movies = movies;
    })
  }

}
