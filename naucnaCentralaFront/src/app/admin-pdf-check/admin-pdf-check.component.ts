import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-pdf-check',
  templateUrl: './admin-pdf-check.component.html',
  styleUrls: ['./admin-pdf-check.component.css']
})
export class AdminPdfCheckComponent implements OnInit {

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
          },
          err => {
            console.log("Error occured");
        });
      });
   }

  ngOnInit() {

  }

  otvoriSaveChooser(){
    this.articleService.downloadPDF(this.processInstance).subscribe(
      res => {

      },
      err => {
        console.log("Error occured");
    });
  }

  onSubmit(value, form){
    let o = new Array();
    console.log(form);
    for (var property in value) {
       o.push({fieldId : property, fieldValue : value[property]});
 
    }
    
    this.articleService.saveBasicInfo(o, this.processInstance).subscribe(
      res => {
         window.location.href = "http://localhost:4201/";
      },
      err => {
        console.log("Error occured");
    });
  }
}
