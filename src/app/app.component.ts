import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Ordering-System';


  constructor(private route: Router, public db: AngularFireDatabase) {
    // this.items = db.list('items').valueChanges();
  }

  // onSubmit() {
  //   this.db.list('/items').push({ content: this.itemValue });
  //   this.itemValue = '';
  // }

}
