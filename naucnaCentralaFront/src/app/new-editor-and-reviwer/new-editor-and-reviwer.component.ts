import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/userService';
import { TaskService } from '../services/taskService';
import { ActivatedRoute } from '@angular/router';
import { MagazineService } from '../services/MagazineService';

@Component({
  selector: 'app-new-editor-and-reviwer',
  templateUrl: './new-editor-and-reviwer.component.html',
  styleUrls: ['./new-editor-and-reviwer.component.css']
})
export class NewEditorAndReviwerComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private oblasti = [];
  private oblastiS = "";
  private id:any;
  private recenzenti:any;
  private urednici:any;

  constructor(private magazineService : MagazineService,private activatedRoute: ActivatedRoute) {

    this.activatedRoute.paramMap.subscribe(
      params => {
        this.id = params.get('procesID');
        this.magazineService.getEnums(this.id).subscribe(
          res => {
            this.formFieldsDto = res;
            this.formFields = this.formFieldsDto.formFields;
            this.processInstance = this.formFieldsDto.processInstanceId;
            this.recenzenti = this.formFieldsDto.recenzenti;
            this.urednici = this.formFieldsDto.urednici;
          },
          err => {
            console.log("Error occured");
        });
      });
   }

  ngOnInit() {
  }

  onSubmit(value, form){
   console.log(value)
    let o = new Array();
    for (var property in value) {
      if(property == "urednici" || property == "recenzenti"){
        for (let entry of value[property]) {
          this.oblastiS += entry + ',';
        }
        o.push({fieldId : property, fieldValue : this.oblastiS});
        this.oblastiS = "";
      }else{
        o.push({fieldId : property, fieldValue : value[property]});
      }
    }

    this.magazineService.updateMagazineData(o, this.processInstance).subscribe(
      res => {
        alert("You successfuly chose editors and reviwers!")
        window.location.href = "http://localhost:4201/adminCheck/" + this.processInstance ;
      },
      err => {
        console.log("Error occured");
    });
  }

}
