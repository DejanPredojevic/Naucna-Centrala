import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-choose-recenzente',
  templateUrl: './choose-recenzente.component.html',
  styleUrls: ['./choose-recenzente.component.css']
})
export class ChooseRecenzenteComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private magazines = [];
  private oblastiS = "";
  private oblast = "";
  private id:any;
  private fileToUpload : any;
  private path:any;

  constructor(private articleService : ArticleService,private activatedRoute: ActivatedRoute) {

    this.activatedRoute.paramMap.subscribe(
      params => {
        this.id = params.get('procesID');
        this.articleService.getRecenzetChoose(this.id).subscribe(
          res => {
            this.formFieldsDto = res;
            this.formFields = this.formFieldsDto.formFields;
            this.processInstance = this.formFieldsDto.processInstanceId;
            this.oblastiS = this.formFieldsDto.scientificFields;
          },
          err => {
            console.log("Error occured");
        });
      });
   }

  ngOnInit() {

  }

  onSubmit(value, form){
    let o = new Array();
    console.log(form);
    for (var property in value) {
      if(property == "recenzent"){
        for (let entry of value[property]) {
          this.oblast += entry + ',';
        }
        o.push({fieldId : property, fieldValue : this.oblast});
      }else{
        o.push({fieldId : property, fieldValue : value[property]});
      }
 
    }
    
    this.articleService.saveRecenzente(o, this.processInstance).subscribe(
      res => {
         window.location.href = "http://localhost:4201/";
      },
      err => {
        console.log("Error occured");
    });
  }

}
