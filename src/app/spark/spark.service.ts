import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
import { Http, Headers } from '@angular/http';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SparkService {

  constructor(private http: HTTP) { }
}
