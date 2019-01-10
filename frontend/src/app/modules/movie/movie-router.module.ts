import { NgModule } from '@angular/core'
import { RouterModule, Routes } from '@angular/router';
import { ContainerComponent } from './component/container/container.component';
import { TmdbContainerComponent } from './component/tmdb-container/tmdb-container.component';
import { WatchlistComponent } from './component/watchlist/watchlist.component';
import {SearchComponent } from './component/search/search.component';
import { AuthGuardService } from '../../authGuard.service';

const movieRoutes: Routes =[
    {
        path: 'movies',

        children: [
            {
                path :'',
                redirectTo:'/movies/popular',
                pathMatch: 'full',
                canActivate: [AuthGuardService]
            },
            {
                path: 'popular',
                component: TmdbContainerComponent,
                canActivate: [AuthGuardService],
                data: {
                    movieType: 'popular',
                }
            },
            {
                path: 'top_rated',
                component: TmdbContainerComponent,
                canActivate: [AuthGuardService],
                data:{
                    movieType: 'top_rated',
                }
            },
            {
                path: 'watchlist',
                component: WatchlistComponent,
                canActivate: [AuthGuardService],
            },
            {
                path: 'search',
                component: SearchComponent,
                canActivate: [AuthGuardService],
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