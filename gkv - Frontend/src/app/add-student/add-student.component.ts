import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap/modal/modal';
import { LoginCustomerService } from 'src/service/login.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {

  hide = true;

  addStudentForm: FormGroup;
  submitted:boolean=false;
  
  constructor( private fb : FormBuilder, private router:Router, private loginService:LoginCustomerService, private http:HttpClient) {
    this.addStudentForm = this.fb.group ({
      gkvStudentName: ['',Validators.required],
      gkvStudentSurname:['',Validators.required],
      gkvStandardName:['',Validators.required],
      gkvStudentFatherName:['',Validators.required],
      gkvStudentMotherName:['',Validators.required],
      gkvStudentRollNumber:['',Validators.required],
      gkvStudentAddress:['',Validators.required],
     gkvClassNumber:['',Validators.required],
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
}


navigateStudentList(){
  this.loginService.register(this.addStudentForm.value)
     .subscribe((rese)=>{
    console.log(rese);
  }
  
  )
  this.router.navigateByUrl('/class-list')

}

navigateClassList(){
  this.router.navigateByUrl('/class-list')
}


}

  