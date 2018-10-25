import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

    // submitOrder(){
    //   this.addOrder
    // }

  hotels = [
    "Java",
    "Serena",
    "Mugg & Bean"];



  constructor(route: ActivatedRoute) { }
  ngOnInit() {
  }

}
