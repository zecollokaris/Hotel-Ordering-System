import { Component, OnInit } from '@angular/core';
import {ParamMap,ActivatedRoute} from '@angular/router'
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  hotel:string;

  constructor(public route:ActivatedRoute) {
  }

  ngOnInit() {
    this.hotel=this.route.snapshot.paramMap.get("name");
    alert(this.hotel);
  }

}
