import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ImgSliderComponent} from "./img-slider.component";

const routes: Routes = [
  {
    path: 'a',
    component: ImgSliderComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ImgSliderRoutingModule { }
