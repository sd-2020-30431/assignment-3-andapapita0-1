import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { ItemUpdateComponent } from './item-update/item-update.component';
import { LoginComponent } from './login/login.component';
import { WeeklyreportComponent } from './weeklyreport/weeklyreport.component';
import { MonthlyreportComponent } from './monthlyreport/monthlyreport.component';

const routes: Routes = [
  { path: 'groceries', component: ItemListComponent },
  { path: 'additem', component: ItemFormComponent },
  { path: 'updateitem/:id', component: ItemUpdateComponent },
  { path: 'login', component: LoginComponent },
  { path: 'weeklyreport', component: WeeklyreportComponent },
  { path: 'monthlyreport', component: MonthlyreportComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
