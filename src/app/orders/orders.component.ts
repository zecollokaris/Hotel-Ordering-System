import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

tables = [
  "Table 5"
];
orders = [
  " Family Pack Fries",
  " 2 Chicken  Wings 2 Meidum Fries"
];


  constructor() { }

  ngOnInit() {
  }

}
