import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AngularFireModule } from 'angularfire2';
import { AngularFireDatabaseModule } from 'angularfire2/database';
import { environment } from '../environments/environment';
import { MaterialModule } from './material/material.module';
import { AppComponent } from './app.component';
import { RoutingModule } from './routing/routing.module';
import { EntryComponent } from './entry/entry.component';
import { MenuComponent } from './menu/menu.component';
import { WaiterComponent } from './waiter/waiter.component';
import { OrdersComponent } from './orders/orders.component';
import { WSignUpComponent } from './wsign-up/wsign-up.component';
import { AboutComponent } from './about/about.component';
import { FormsModule } from '@angular/forms';
import  {SparkService} from './spark/spark.service'
import  {FirebaseService} from './firebase/firebase.service'

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
    RoutingModule,
    FormsModule,
    AngularFireModule.initializeApp(environment.firebase),
    AngularFireDatabaseModule, // for database
  ],
  providers: [SparkService,FirebaseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
