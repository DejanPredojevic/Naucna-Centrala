import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { Shared } from '../services/Token';

@Component({
  selector: 'app-recenzent-pregled',
  templateUrl: './recenzent-pregled.component.html',
  styleUrls: ['./recenzent-pregled.component.css']
})
export class RecenzentPregledComponent implements OnInit {

  articles : any;

  constructor(private articleService : ArticleService,private tandu: Shared) { 
    this.tandu.username = localStorage.getItem('username');
  }

  ngOnInit() {
    this.articleService.getForRecenziju(this.tandu.username).subscribe(
      res => {
        this.articles = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  RowSelected(article : any){
    window.location.href = "http://localhost:4201/recenzentiPregled/" + article.procesID;
  }
}
