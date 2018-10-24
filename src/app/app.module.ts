import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MaterialModule} from './material/material.module';
import { AppComponent } from './app.component';
import {RoutingModule} from './routing/routing.module';
import {EntryComponent} from './entry/entry.component';
import {MenuComponent} from './menu/menu.component';



@NgModule({
  declarations: [
    AppComponent,
    EntryComponent,
    MenuComponent
  ],
  imports: [
    BrowserModule,
    MaterialModule,
    RoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
