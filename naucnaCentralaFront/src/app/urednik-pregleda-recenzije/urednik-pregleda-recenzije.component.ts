import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { Shared } from '../services/Token';

@Component({
  selector: 'app-urednik-pregleda-recenzije',
  templateUrl: './urednik-pregleda-recenzije.component.html',
  styleUrls: ['./urednik-pregleda-recenzije.component.css']
})
export class UrednikPregledaRecenzijeComponent implements OnInit {

  articles : any;

  constructor(private articleService : ArticleService) { 
  }

  ngOnInit() {
    this.articleService.getPregledRecenzija().subscribe(
      res => {
        this.articles = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  RowSelected(article : any){
    window.location.href = "http://localhost:4201/odobravanjeArticla/" + article.procesID;
  }

}
