import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SERVER_URL } from '../app.constant';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class ArticleService {

    constructor(private http:HttpClient){
    }

    startProcess(){
      return this.http.get(SERVER_URL + 'startNewArticle')
    }

    chooseMagazine(magazine, taskId, username) {
      return this.http.post(SERVER_URL + 'chooseMagazine/' + taskId + '/' + username, magazine) as Observable<any>;
    }

    articleInfo(id:any){
      return this.http.get(SERVER_URL + 'getBasicInfo/'+id)
    }

    getPath(){
      return this.http.get(SERVER_URL + 'getPath')
    }

    downloadPDF(procesID){
      return this.http.post(SERVER_URL + 'downloadPDF/' + procesID, null);
    }

    saveBasicInfo(info, pocesID){
      return this.http.post(SERVER_URL + 'saveBasicInfo/' + pocesID, info) as Observable<any>;
    }

    getAllArticlesForCheck(){
      return this.http.get(SERVER_URL + 'getTematika')
    }

    getForPdfCorection(){
      return this.http.get(SERVER_URL + 'getForPdfCorection')
    }

    saveTematika(info, pocesID){
      return this.http.post(SERVER_URL + 'saveTematika/' + pocesID, info) as Observable<any>;
    }
}