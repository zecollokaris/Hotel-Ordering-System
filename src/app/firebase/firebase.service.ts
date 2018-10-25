import { Injectable } from '@angular/core';
import {AngularFireDatabase} from  'angularfire2/database'
import {Customer} from '../customer'

@Injectable({
  providedIn: 'root'
})
export class FirebaseService {
  constructor(private db:AngularFireDatabase) {

  }
}
