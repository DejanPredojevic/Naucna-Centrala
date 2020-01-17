import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/userService';
import { TaskService } from '../services/taskService';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private oblasti = [];
  private oblastiS = "";

  constructor(private userService : UserService, private repositoryService : TaskService) {
    this.repositoryService.startProcess().subscribe(
      res => {
        this.formFieldsDto = res;
        this.formFields = this.formFieldsDto.formFields;
        this.processInstance = this.formFieldsDto.processInstanceId;
        this.oblasti = this.formFieldsDto.scientificFields;
      },
      err => {
        console.log("Error occured");
    });
   }

  ngOnInit() {
  }

  onSubmit(value, form){
    console.log(value)
    let o = new Array();
    for (var property in value) {
      if(property == "oblast"){
        for (let entry of value[property]) {
          this.oblastiS += entry + ',';
        }
        o.push({fieldId : property, fieldValue : this.oblastiS});
      }else{
        o.push({fieldId : property, fieldValue : value[property]});
      }
    }
    this.userService.registerUser(o, this.formFieldsDto.taskId).subscribe(
      res => {
        alert("You registered successfully!")
        window.location.href = "http://localhost:4201/login/";
      },
      err => {
        console.log("Error occured");
    });
  }

}
