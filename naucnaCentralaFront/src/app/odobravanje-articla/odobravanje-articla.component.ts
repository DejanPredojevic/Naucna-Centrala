import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-odobravanje-articla',
  templateUrl: './odobravanje-articla.component.html',
  styleUrls: ['./odobravanje-articla.component.css']
})
export class OdobravanjeArticlaComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private magazines = [];
  private article = "";
  private oblast = "";
  private id:any;
  private fileToUpload : any;
  private path:any;

  constructor(private articleService : ArticleService,private activatedRoute: ActivatedRoute) {

    this.activatedRoute.paramMap.subscribe(
      params => {
        this.id = params.get('procesID');
        this.articleService.getOdobravanje(this.id).subscribe(
          res => {
            this.formFieldsDto = res;
            this.formFields = this.formFieldsDto.formFields;
            this.processInstance = this.formFieldsDto.processInstanceId;
            this.article = this.formFieldsDto.article;
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
       o.push({fieldId : property, fieldValue : value[property]});
 
    }
    
    this.articleService.saveRecenziju(o, this.processInstance).subscribe(
      res => {
         window.location.href = "http://localhost:4201/";
      },
      err => {
        console.log("Error occured");
    });
  }

}
