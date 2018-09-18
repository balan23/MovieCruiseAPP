import { Component } from '@angular/core';
import { ThumbnailComponent } from './modules/movie/component/thumbnail/thumbnail.component';

@Component({
  selector: 'app-root',
  template: `
  <movie-thumbnail> </movie-thumbnail>
     
  `,
  styles: []
})
export class AppComponent {
  title = 'app';
}
