import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserService } from '../services/userService';
import { AnonymousSubject } from 'rxjs/internal/Subject';
import { Shared } from '../services/Token';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  SingIn:FormGroup;
  submitted = false;
  userInfo: any;
  username: any;
  addPayment: any;

  constructor(
    private service : UserService,
    private formBuilder:FormBuilder,
    private router:Router,
    private activatedRoute: ActivatedRoute,
    private tandu: Shared) { }

  ngOnInit() {
      this.SingIn = this.formBuilder.group({
        username:['',Validators.compose([Validators.required, Validators.pattern('[a-zA-Z 0-9!]+')])],
        password:['',Validators.compose([Validators.required, Validators.pattern('[a-zA-Z 0-9!]+')])]
      });
  }

  get f() { return this.SingIn.controls; }

  onSubmit(event:any) {
    this.submitted = true;
    this.userInfo = this.SingIn.getRawValue();
    this.service.login(this.userInfo).subscribe(
      data => {
          this.tandu.role = data.role;
          this.tandu.username = data.username;
          localStorage.setItem('username', data.username);
          localStorage.setItem('role', data.role);
          this.router.navigateByUrl("");
      }
    );
     
  }

}
