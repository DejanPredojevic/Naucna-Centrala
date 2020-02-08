import { Component, OnInit } from '@angular/core';
import { MagazineService } from '../services/MagazineService';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-publish',
  templateUrl: './admin-publish.component.html',
  styleUrls: ['./admin-publish.component.css']
})
export class AdminPublishComponent implements OnInit {

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
  private magazine:any;

  constructor(private magazineService : MagazineService,private activatedRoute: ActivatedRoute) {

    this.activatedRoute.paramMap.subscribe(
      params => {
        this.id = params.get('procesID');
        this.magazineService.getAdminCheck(this.id).subscribe(
          res => {
            this.formFieldsDto = res;
            this.formFields = this.formFieldsDto.formFields;
            this.processInstance = this.formFieldsDto.processInstanceId;
            this.magazine = this.formFieldsDto.recenzenti;
            this.magazine = this.formFieldsDto.magazine;
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
       o.push({fieldId : property, fieldValue : value[property]});
     }
     
     this.magazineService.saveUrednikCorect(o, this.processInstance).subscribe(
       res => {
          window.location.href = "http://localhost:4201" ;
       },
       err => {
         console.log("Error occured");
     });
   }

}
