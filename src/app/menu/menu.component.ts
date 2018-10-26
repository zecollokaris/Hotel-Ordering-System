import { Component, OnInit } from '@angular/core';
import {ParamMap,ActivatedRoute} from '@angular/router';
import  {SparkService} from '../spark/spark.service';
import {Category} from '../category';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  hotel:string;
  categorys=[];
  category=new Category(0,"","",false);
  constructor(public route:ActivatedRoute,public serve: SparkService) {

  }
  ngOnInit() {

    this.hotel=this.route.snapshot.paramMap.get("name");
    this.categorys=this.serve.getCategorys(this.hotel);
  }
  getId(name:string){
   for(let category of this.categorys){
     if(name==category.name){
        return category.id;
     }
   }
  }
  getFoods(){
    console.log(this.category.name.id);

  }
}
