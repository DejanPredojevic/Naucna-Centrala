import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';

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

  constructor(private magazineService : ArticleService) {
    this.magazineService.startProcess().subscribe(
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
  }

}
