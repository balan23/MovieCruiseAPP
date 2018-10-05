import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router';
import { ContainerComponent } from './component/container/container.component';
import { TmdbContainerComponent } from './component/tmdb-container/tmdb-container.component';
import { WatchlistComponent } from './component/watchlist/watchlist.component';
import {SearchComponent } from './component/search/search.component';

const movieRoutes: Routes =[
    {
        path: 'movies',

        children: [
            {
                path :'',
                redirectTo:'/movies/popular',
                pathMatch: 'full'
            },
            {
                path: 'popular',
                component: TmdbContainerComponent,
                data: {
                    movieType: 'popular',
                }
            },
            {
                path: 'top_rated',
                component: TmdbContainerComponent,
                data:{
                    movieType: 'top_rated',
                }
            },
            {
                path: 'watchlist',
                component: WatchlistComponent,
            },
            {
                path: 'search',
                component: SearchComponent,
            }
            
        ]
    },
]

@NgModule({
imports: [
    RouterModule.forChild(movieRoutes),
],
exports: [
    RouterModule,
]
})
export class MovieRouterModule{ }