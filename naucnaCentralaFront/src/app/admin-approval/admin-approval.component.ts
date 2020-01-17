import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/userService';
import { TaskService } from '../services/taskService';

@Component({
  selector: 'app-admin-approval',
  templateUrl: './admin-approval.component.html',
  styleUrls: ['./admin-approval.component.css']
})
export class AdminApprovalComponent implements OnInit {

  users : any;

  constructor(private userService : UserService, private repositoryService : TaskService) { }

  ngOnInit() {
    this.userService.getUsers().subscribe(
      res => {
        this.users = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  RowSelected(user : any){
    window.location.href = "http://localhost:4201/userApprove/" + user.procesID;
  }

}
