import { Injectable } from '@angular/core';
import {AngularFireDatabase} from  'angularfire2/database'
import {Customer} from '../customer'

@Injectable({
  providedIn: 'root'
})
export class FirebaseService {
  constructor(public db:AngularFireDatabase) {
  }
  pushCustomerToDB(hotel:string,order:object){
    let customer={
      order:order,
      time:new Date().getTime();
    }
    this.db.object(hotel).update(customer);
  }
}
