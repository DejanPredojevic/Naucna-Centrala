import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { Shared } from '../services/Token';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-article-check',
  templateUrl: './article-check.component.html',
  styleUrls: ['./article-check.component.css']
})
export class ArticleCheckComponent implements OnInit {

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
        this.articleService.articleInfo(this.id).subscribe(
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
       o.push({fieldId : property, fieldValue : value[property]});
 
    }
    
    this.articleService.saveTematika(o, this.processInstance).subscribe(
      res => {
        if(res){
          window.location.href = "http://localhost:4201/pdfCheck/" + this.processInstance;
        }else{
          window.location.href = "http://localhost:4201/";
        }
         
      },
      err => {
        console.log("Error occured");
    });
  }

}
