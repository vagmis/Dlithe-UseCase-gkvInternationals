import { Component, OnInit, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';
import { Router } from '@angular/router';
import { LoginCustomerService } from 'src/service/login.service';

@Component({
  selector: 'app-class-list',
  templateUrl: './class-list.component.html',
  styleUrls: ['./class-list.component.css']
})
export class ClassListComponent implements OnInit {

  classes:any;

  @Output () passDataToApp = new EventEmitter();
  constructor( private router:Router, private loginService:LoginCustomerService) {
  }
  ngOnInit(): void {
    this.classList();
  }
  classList(){
    this.loginService.getClassList()
      .subscribe((res:any) =>{
        console.log(res);
        this.classes=res.response.gkvClassListResponses;
      })
  }

  navigateAddStudent(){
    this.router.navigate(["/add-student"])
  }

  navigatelandingPage(){
    this.router.navigate(["/landing-page"])
  }
  navigateStudentList(classNumber:any){
    this.router.navigate(['/student-list',classNumber])
  }

}
