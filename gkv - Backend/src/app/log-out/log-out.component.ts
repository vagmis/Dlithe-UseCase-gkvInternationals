import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-log-out',
  templateUrl: './log-out.component.html',
  styleUrls: ['./log-out.component.css']
})
export class LogOutComponent implements OnInit {

  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  navigateClassList(){
    this.router.navigateByUrl('/class-list')
  }
  navigateLandingPage(){
    this.router.navigateByUrl('/landing-page')
  }
  navigateLogout(){
    window.location.href = 'https://www.google.co.in/';
  }

}
