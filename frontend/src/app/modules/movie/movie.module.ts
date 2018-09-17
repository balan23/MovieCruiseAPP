import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HelloWorldComponent } from './component/hello-world/hello-world.component';
import { ThumbnailComponent } from './component/thumbnail/thumbnail.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule
  ],
  declarations: [
    HelloWorldComponent, 
    ThumbnailComponent],
  exports: [
    HelloWorldComponent,
    ThumbnailComponent
  ],
  providers: [

  ]

})
export class MovieModule { }
