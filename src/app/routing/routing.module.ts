import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
// import { Route, RoutingModule } from '@angular/route';
import { RouterModule, Routes } from '@angular/router';
import { EntryComponent} from '../entry/entry.component';
import { MenuComponent } from '../menu/menu.component';
import { WaiterComponent } from '../waiter/waiter.component';
import { OrdersComponent } from '../orders/orders.component';
import {WSignUpComponent} from '../wsign-up/wsign-up.component';

const routes: Routes = [
  { path: "entry", component: EntryComponent },
  { path: "menu", component: MenuComponent },
  { path: "waiter", component: WaiterComponent},
  {path: "orders", component: OrdersComponent},
  {path: "signUp", component: WSignUpComponent},
  {path: '',redirectTo: '/entry',pathMatch: 'full'}

]
@NgModule({
  imports: [
    CommonModule,
    //RoutingModule replaced
    RouterModule.forRoot(routes)
     // { enableTracing: true }
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class RoutingModule { }
