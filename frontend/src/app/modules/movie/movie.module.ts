import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HelloWorldComponent } from './component/hello-world/hello-world.component';
import { ThumbnailComponent } from './component/thumbnail/thumbnail.component';
import { HttpClientModule } from '@angular/common/http';
import { MovieService } from './movie.service';

import { ContainerComponent } from './component/container/container.component';
import { MovieRouterModule } from './movie-router.module';
import { MatCardModule } from '@angular/material/card';
import { WatchlistComponent } from './component/watchlist/watchlist.component';
import { TmdbContainerComponent } from './component/tmdb-container/tmdb-container.component';
import { MatButtonModule } from '@angular/material/button';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MovieDialogComponent } from './component/movie-dialog/movie-dialog.component';
import { MatInputModule } from '@angular/material/input'
import { FormsModule } from '@angular/forms';
import { SearchComponent } from './component/search/search.component';
@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    MovieRouterModule,MatCardModule,
    MatButtonModule,
    MatSnackBarModule,

    MatInputModule,
    FormsModule,
  ],
  declarations: [
    HelloWorldComponent, 
    ThumbnailComponent,  
    ContainerComponent,
    WatchlistComponent, 
    TmdbContainerComponent, 
    MovieDialogComponent, SearchComponent,
  ],
  entryComponents: [MovieDialogComponent],
  exports: [
    HelloWorldComponent,
    ThumbnailComponent,
    MovieRouterModule,
    MovieDialogComponent,SearchComponent,
  ],
  providers: [MovieService]

})
export class MovieModule { }
