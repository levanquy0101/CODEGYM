import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ListComponent} from "./product/list/list.component";
import {FormComponent} from "./product/form/form.component";

const routes: Routes = [
  {
    path: 'product/list',
    component: ListComponent
  }, {
    path: 'product/create',
    component: FormComponent
  }, {
    path: 'product/edit/:id',
    component: FormComponent
  }, {
    path: 'product/delete/:id',
    component: ListComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
