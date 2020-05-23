import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { ItemUpdateComponent } from './item-update/item-update.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: 'groceries', component: ItemListComponent },
  { path: 'additem', component: ItemFormComponent },
  { path: 'updateitem/:id', component: ItemUpdateComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }