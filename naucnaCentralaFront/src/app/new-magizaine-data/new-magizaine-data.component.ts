import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/userService';
import { TaskService } from '../services/taskService';
import { MagazineService } from '../services/MagazineService';

@Component({
  selector: 'app-new-magizaine-data',
  templateUrl: './new-magizaine-data.component.html',
  styleUrls: ['./new-magizaine-data.component.css']
})
export class NewMagizaineDataComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private oblasti = [];
  private oblastiS = "";

  constructor(private magazineService : MagazineService) {
    this.magazineService.startProcess().subscribe(
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
      if(property == "naucneOblasti"){
        for (let entry of value[property]) {
          this.oblastiS += entry + ',';
        }
        o.push({fieldId : property, fieldValue : this.oblastiS});
      }else{
        o.push({fieldId : property, fieldValue : value[property]});
      }
    }
    this.magazineService.saveMagazine(o, this.formFieldsDto.taskId).subscribe(
      res => {
        alert("You magazine is saved successfully!")
        window.location.href = "http://localhost:4201/newEditorAndReviwer/" + res.procesID;
      },
      err => {
        console.log("Error occured");
    });
  }

}
