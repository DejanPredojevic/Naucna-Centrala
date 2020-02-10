import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';
import { Shared } from '../services/Token';

@Component({
  selector: 'app-urednik-choose-recenzente',
  templateUrl: './urednik-choose-recenzente.component.html',
  styleUrls: ['./urednik-choose-recenzente.component.css']
})
export class UrednikChooseRecenzenteComponent implements OnInit {

  articles : any;

  constructor(private articleService : ArticleService,private tandu: Shared) { 
    this.tandu.username = localStorage.getItem('username');
  }

  ngOnInit() {
    this.articleService.getForUrednikChoose(this.tandu.username).subscribe(
      res => {
        this.articles = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  RowSelected(article : any){
    window.location.href = "http://localhost:4201/chooseRecenzente/" + article.procesID;
  }

}
