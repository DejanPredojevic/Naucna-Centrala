import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { Shared } from '../services/Token';

@Component({
  selector: 'app-new-article',
  templateUrl: './new-article.component.html',
  styleUrls: ['./new-article.component.css']
})
export class NewArticleComponent implements OnInit {

  private repeated_password = "";
  private categories = [];
  private formFieldsDto = null;
  private formFields = [];
  private choosen_category = -1;
  private processInstance = "";
  private tasks = [];
  private magazines = [];
  private oblastiS = "";

  constructor(private articleService : ArticleService,private tandu: Shared) {
    this.articleService.startProcess().subscribe(
      res => {
        this.formFieldsDto = res;
        this.formFields = this.formFieldsDto.formFields;
        this.processInstance = this.formFieldsDto.processInstanceId;
        this.magazines = this.formFieldsDto.magazines;
      },
      err => {
        console.log("Error occured");
    });
   }

  ngOnInit() {
    this.tandu.username = localStorage.getItem('username');
  }

  onSubmit(value, form){
     let o = new Array();
     
     for (var property in value) {
       o.push({fieldId : property, fieldValue : value[property]});
       console.log(value[property])
     }
     
     this.articleService.chooseMagazine(o, this.formFieldsDto.taskId, this.tandu.username).subscribe(
       res => {
          window.location.href = "http://localhost:4201/articleInfo/" + this.processInstance ;
       },
       err => {
         console.log("Error occured");
     });
   }
}
