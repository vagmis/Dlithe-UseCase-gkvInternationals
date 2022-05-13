import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginCustomerService } from 'src/service/login.service';
@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {

  eachStudent:any;
  studentNum:any;
  constructor( private router:Router, private loginSerice:LoginCustomerService, private activateRoute:ActivatedRoute ) {
    this.studentNum=this.activateRoute.snapshot.params['studentNum'];
  }

  ngOnInit(): void {
    this.getEachStudentDeatil();
  }
  navigateStudentList(){
      this.router.navigateByUrl('/student-list')
  }
  navigateEditPage(editStudent:any){
    this.router.navigate(['/edit-student-details',editStudent])
  }

  getEachStudentDeatil(){
    this.loginSerice.getEachStudentDetial(this.studentNum).subscribe(
      (res:any) => {
      console.log(res);
      this.eachStudent=res.response;
    })
}



}
