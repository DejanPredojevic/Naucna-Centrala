import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_URL } from '../app.constant';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
  })
  export class UserService {

    constructor(private http:HttpClient){
    }

    registerUser(user, taskId) {
      return this.http.post(SERVER_URL + 'register/' + taskId, user) as Observable<any>;
    }

    getUsers(){
      return this.http.get(SERVER_URL + 'getUsersApproval')
    }

    approveUser(approve, pocesID){
      return this.http.post(SERVER_URL + 'approveUser/' + pocesID, approve) as Observable<any>;
    }

    login(log:any){
        return this.http.post(SERVER_URL + 'login', log) as Observable<any>;
    }

}