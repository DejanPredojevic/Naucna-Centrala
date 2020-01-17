import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/userService';
import { TaskService } from '../services/taskService';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-approve',
  templateUrl: './user-approve.component.html',
  styleUrls: ['./user-approve.component.css']
})
export class UserApproveComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private oblasti = [];
  private oblastiS = "";
  private id : any;

  constructor(private userService : UserService, private repositoryService : TaskService,private activatedRoute: ActivatedRoute) {
   }

  ngOnInit() {
     this.activatedRoute.paramMap.subscribe(
      params => {
        this.id = params.get('procesID');
        this.repositoryService.getUser(this.id).subscribe(
          res => {
            this.formFieldsDto = res;
            this.formFields = this.formFieldsDto.formFields;
            this.processInstance = this.formFieldsDto.processInstanceId;
            this.oblasti = this.formFieldsDto.scientificFields;
          },
          err => {
            console.log("Error occured");
        });
      });
  }

  onSubmit(value, form){
    console.log(value)
    let o = new Array();
    for (var property in value) {
       o.push({fieldId : property, fieldValue : value[property]});
    }
    this.userService.approveUser(o, this.id).subscribe(
      res => {
        alert("You approve user successfully!")
        window.location.href = "http://localhost:4201/approval/";
      },
      err => {
        console.log("Error occured");
    });
  }

}
