import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Http, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SparkService {
  endpoint:string="https://orderingsystem8984.herokuapp.com";
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
   }).catch(res=>{
    console.log(res);
   });
   return hotels;
  }
}
