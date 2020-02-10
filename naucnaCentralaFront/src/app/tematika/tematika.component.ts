import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';

@Component({
  selector: 'app-tematika',
  templateUrl: './tematika.component.html',
  styleUrls: ['./tematika.component.css']
})
export class TematikaComponent implements OnInit {

  articles : any;

  constructor(private articleService : ArticleService) { }

  ngOnInit() {
    this.articleService.getAllArticlesForCheck().subscribe(
      res => {
        this.articles = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  RowSelected(article : any){
    window.location.href = "http://localhost:4201/articleCheck/" + article.procesID;
  }

}
