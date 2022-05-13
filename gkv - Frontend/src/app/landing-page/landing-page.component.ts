import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginCustomerService } from 'src/service/login.service';

@Component({
  selector: 'app-landing-page',
  templateUrl: './landing-page.component.html',
  styleUrls: ['./landing-page.component.css']
})
export class LandingPageComponent implements OnInit {

  teacher: any;
  constructor(private router:Router , private loginService:LoginCustomerService) { }

  ngOnInit(): void {
    this.teacherList();
  }

  navigateToLogin(){
    this.router.navigateByUrl('/login');
  }

  teacherList(){
    this.loginService.getTeacherList()
      .subscribe((res:any) =>{
        console.log(res);
        this.teacher=res.response.teachersListResponses;
      })
  }

}
