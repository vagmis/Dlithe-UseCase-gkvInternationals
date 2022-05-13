import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginCustomerService } from 'src/service/login.service';

@Component({
  selector: 'app-edit-student-details',
  templateUrl: './edit-student-details.component.html',
  styleUrls: ['./edit-student-details.component.css']
})
export class EditStudentDetailsComponent implements OnInit {
 editStudentForm: FormGroup;

  submitted:boolean=false;
  editStudent:any;
  editNum:any;
  constructor(private fb : FormBuilder, private router:Router, private loginSerice:LoginCustomerService, private activateRoute:ActivatedRoute) {
    this.editNum=this.activateRoute.snapshot.params['editNum'];
    this.editStudentForm = this.fb.group ({
      gkvStudentName: ['',Validators.required],
      gkvStudentSurname:['',Validators.required],
      gkvClassNumber:['',Validators.required],
      gkvStudentFatherName:['',Validators.required],
      gkvStudentMotherName:['',Validators.required],
      gkvStudentRollNumber:['',Validators.required],
      gkvStudentAddress:['',Validators.required],
      gkvStandardName:['',Validators.required],
      gkvStudentPhoneNumber: [
      '',
      [
        Validators.required,
        Validators.min(1000000000),
        Validators.max(9999999999),
      ],
    ],
    
    });
   }

  ngOnInit(): void {
    this.editEachStudentDeatil();
  
  }

navigateStudentDeatils(){
  this.router.navigateByUrl('/class-list')
}
navigateStudentList(){
  this.router.navigateByUrl('/student-list')
}

navigateClassList(){
  this.router.navigateByUrl('/class-list')
}
navigateLogOut(){
  this.router.navigateByUrl('/log-out')
}

editEachStudentDeatil(){
  this.loginSerice.editStudentDetial(this.editNum).subscribe(
    (res:any) => {
    console.log(res);
    this.editStudent=res.response;
  })

}
}