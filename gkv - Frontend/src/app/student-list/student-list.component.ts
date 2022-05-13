import { Component, OnInit, Output } from '@angular/core';
import { studentList } from './list';
import { EventEmitter } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginCustomerService } from 'src/service/login.service';


@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent implements OnInit {

    listOfTeacher:any;
    teacherId:any;
    classNumber:any;
  students = studentList;
  studentList: any;

  @Output () passDataToApp = new EventEmitter();

  constructor(private router:Router, private loginService:LoginCustomerService, private activatedRoute:ActivatedRoute) {
    this.classNumber=this.activatedRoute.snapshot.params['classNumber'];
   }


  ngOnInit(): void {
    this.getstudentList();
  }
  
  navigateClassList(){
    this.router.navigateByUrl('/class-list')

  }
  navigatestudentDeatils(studentNum:any){
    this.router.navigate(['/student-details',studentNum])
  }

  getstudentList(){
      this.loginService.getStudentsList(this.classNumber).subscribe(
        (res:any) => {
        console.log(res);
        this.studentList=res.response.gkvStudentDetailsListResponses;
      })
  }

}