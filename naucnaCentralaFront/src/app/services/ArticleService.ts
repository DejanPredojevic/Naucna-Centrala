import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SERVER_URL } from '../app.constant';

@Injectable({
    providedIn: 'root'
  })
  export class ArticleService {

    constructor(private http:HttpClient){
    }

    startProcess(){
      return this.http.get(SERVER_URL + 'startNewArticle')
    }

}