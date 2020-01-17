import { Component, OnInit } from '@angular/core';
import { Shared } from '../services/Token';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private tandu: Shared) { }

  ngOnInit() {
            this.tandu.username = localStorage.getItem('username');
            this.tandu.role = localStorage.getItem('role');
  }

  logout(){
    localStorage.setItem('username', 'undefined');   
    localStorage.setItem('role', 'undefined');
    this.tandu.username = 'undefined';
    this.tandu.role = 'undefined';
  }

}
