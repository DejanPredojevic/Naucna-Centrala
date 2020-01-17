import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_URL } from '../app.constant';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class TaskService {

    constructor(private http:HttpClient){

    }

    startProcess(){
        return this.http.get(SERVER_URL + 'startRegistration')
    }

    getUser(id:any){
      return this.http.get(SERVER_URL + 'getAdminApprove/'+id)
    }
}