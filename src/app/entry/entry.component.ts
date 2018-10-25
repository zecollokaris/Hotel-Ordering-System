import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Customer}  from '../customer'
import  {SparkService} from '../spark/spark.service'
@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {
  serve: SparkService
  router:Router;
  customer:Customer=new Customer("",0,0);
    submitOrder(){
    }
  hotels;
  constructor(route: Router,service : SparkService) {
    this.router=route;
    this.serve=service;
  }
  ngOnInit() {
    this.hotels=this.serve.fetchHotel();
  }

  goToUrl(){
    if(this.customer.hotel!=""){
      this.router.navigate(['/menu',this.customer.hotel]);
    }
  }
}
