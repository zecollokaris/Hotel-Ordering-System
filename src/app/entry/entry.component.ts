import { Component, OnInit,OnChanges,SimpleChanges,SimpleChange} from '@angular/core';
import { Router } from '@angular/router';
import {Customer}  from '../customer'
import  {SparkService} from '../spark/spark.service'
import  {FirebaseService} from '../firebase/firebase.service'
@Component({
  selector: 'app-entry',
  templateUrl: './entry.component.html',
  styleUrls: ['./entry.component.css']
})
export class EntryComponent implements OnInit {

  color = 'accent';
  mode = 'indeterminate';
  value = 10;
  obj={
    show:true,
    hotels:[]
  }
  serve: SparkService
  router:Router;
  customer:Customer=new Customer("",0,0);
    submitOrder(){
      this.fire.pushCustomerToDB(this.customer.hotel,{
       orders:['Chips','Kuku'],
       price:600
      });
    }
  hotels;
  constructor(route: Router,service : SparkService,public fire:FirebaseService) {
    this.router=route;
    this.serve=service;
  }
  ngOnInit(){
    let promise=new Promise((res,rej)=>{
      this.obj=this.serve.fetchHotel();
      if(!this.obj.show){
        res(true)
      }
      else{
        setTimeout(_=>{
         this.obj.show=false;
        },2500);
      }
    })
    promise.then(res=>{
      console.log(res);
    }).catch(err=>{
      console.log(err);
    })
  }
  goToUrl(){
    if(this.customer.hotel!=""){
      this.router.navigate(['/menu',this.customer.hotel]);
    }
  }
}
