import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';

const routes: Routes = [
  { path: 'groceries', component: ItemListComponent },
  { path: 'additem', component: ItemFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }