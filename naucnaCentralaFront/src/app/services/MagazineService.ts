import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_URL } from '../app.constant';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class MagazineService {

    constructor(private http:HttpClient){
    }

    startProcess(){
      return this.http.get(SERVER_URL + 'startNewMagazine')
    }

    saveMagazine(user, taskId) {
      return this.http.post(SERVER_URL + 'saveMagazine/' + taskId, user) as Observable<any>;
    }

    getEnums(id:any){
      return this.http.get(SERVER_URL + 'getEnums/'+id)
    }

    updateMagazineData(approve, pocesID){
      return this.http.post(SERVER_URL + 'updateMagazineData/' + pocesID, approve) as Observable<any>;
    }

    getAdminCheck(id:any){
      return this.http.get(SERVER_URL + 'getAdminCheck/'+id)
    }

    saveAdminCheck(check, pocesID){
      return this.http.post(SERVER_URL + 'saveAdminCheck/' + pocesID, check) as Observable<any>;
    }

    saveUrednikCorect(corect, pocesID){
      return this.http.post(SERVER_URL + 'saveUrednikCorect/' + pocesID, corect) as Observable<any>;
    }

}