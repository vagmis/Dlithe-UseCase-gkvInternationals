import { Component,OnInit, Output, ViewChild } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { LoginCustomerService } from 'src/service/login.service';
import { BreakpointObserver } from '@angular/cdk/layout';
import { MatSidenav } from '@angular/material/sidenav';
import { delay, filter } from 'rxjs/operators';
import { NavigationEnd, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})



export class AppComponent {
  title = 'gkv';

  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
   admins:any;

  @Output () passDataToApp = new EventEmitter();
  constructor( private router:Router, private loginService:LoginCustomerService) {
  }
  ngOnInit(): void {
    this.classList();
  }
  classList(){
    this.loginService.getAdmin()
      .subscribe((res:any) =>{
        console.log(res);
        this.admins=res.response.adminstartorListResponses;
      })
  }
  
}

