import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemFormComponent } from './item-form/item-form.component';
import { ItemService } from './service/item-service.service';

import { ItemUpdateComponent } from './item-update/item-update.component';
import { LoginComponent } from './login/login.component';
import { UserService } from './service/user-service.service';

@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    ItemFormComponent,
    ItemUpdateComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ItemService],
  bootstrap: [AppComponent]
})
export class AppModule { }
