import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { MaterialModule } from './material/material.module';
import { AppComponent } from './app.component';
import { RoutingModule } from './routing/routing.module';
import { EntryComponent } from './entry/entry.component';
import { MenuComponent } from './menu/menu.component';
import { WaiterComponent } from './waiter/waiter.component';
import { OrdersComponent } from './orders/orders.component';
import { WSignUpComponent } from './wsign-up/wsign-up.component';
import { AboutComponent } from './about/about.component';



@NgModule({
  declarations: [
    AppComponent,
    EntryComponent,
    MenuComponent,
    WaiterComponent,
    OrdersComponent,
    WSignUpComponent,
    AboutComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MaterialModule,
    RoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
