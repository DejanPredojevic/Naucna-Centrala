import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pdf-corection',
  templateUrl: './pdf-corection.component.html',
  styleUrls: ['./pdf-corection.component.css']
})
export class PdfCorectionComponent implements OnInit {

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


  otvoriFileChooer(){
    this.articleService.getPath().subscribe(
      res => {
        this.path = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  onSubmit(value, form){
    let o = new Array();
    o.push({fieldId : 'pdf', fieldValue : this.path.procesID});
    
    this.articleService.saveBasicInfo(o, this.processInstance).subscribe(
      res => {
         window.location.href = "http://localhost:4201/";
      },
      err => {
        console.log("Error occured");
    });
  }

}
