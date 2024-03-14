import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListComponent} from "./product/list/list.component";
import {CreateComponent} from "./product/create/create.component";

const routes: Routes = [
  {
    path: 'product/list',
    component: ListComponent
  }, {
    path: 'product/create',
    component: CreateComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
