import { Component, OnInit } from '@angular/core';
import { ArticleService } from '../services/ArticleService';

@Component({
  selector: 'app-popravka-pdf',
  templateUrl: './popravka-pdf.component.html',
  styleUrls: ['./popravka-pdf.component.css']
})
export class PopravkaPdfComponent implements OnInit {

  articles : any;

  constructor(private articleService : ArticleService) { }

  ngOnInit() {
    this.articleService.getForPdfCorection().subscribe(
      res => {
        this.articles = res;
      },
      err => {
        console.log("Error occured");
    });
  }

  RowSelected(article : any){
    window.location.href = "http://localhost:4201/pdfCorect/" + article.procesID;
  }

}
