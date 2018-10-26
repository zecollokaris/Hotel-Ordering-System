import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Http, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import {Category} from '../category'
import  {Food} from '../food'
@Injectable({
  providedIn: 'root'
})
export class SparkService {
  show:boolean=true;
  endpoint:string="https://orderingsystem8984.herokuapp.com";
  categorys:Category[]=[];
  httpOtions={
    headers:new Headers()
  }
  constructor(private http: HttpClient) {
  }

  fetchHotel(){
    let hotels=[];
    interface Apiresponse extends Array<any>{
    }
   this.http.get<Apiresponse>(this.endpoint+"/getHotelList").toPromise().then(res=>{
     for(let data of res){
       hotels.push(data);
     }
    this.show=false;
   }).catch(res=>{
    console.log(res);
   });
   return {
     hotels:hotels,
     show:this.show
   }
  }
  getCategorys(hotel:string){
    let category=new Category(0,"","",false);
    interface ApiObject{
      id:number,
      name:string,
      hotel:string,
      existing:boolean
    }
    interface Apiresponse extends Array<ApiObject>{
    }
    this.http.get<Apiresponse>(this.endpoint+`/getCategory?hotel=${hotel}`).toPromise().then(res=>{
      for(let cat of res){
        category.id=cat.id;
        category.name=cat.name;
        category.hotel=cat.hotel;
        category.existing=cat.existing;
        this.categorys.push(category);
        category=new Category(0,"","",false);
      }
      console.log(this.categorys);
    }).catch(err=>{
      console.log(err)
    });
    return this.categorys;
  }
  foods:Food[]=[];
  getFoods(id:number,hotel:string){
  }
}
