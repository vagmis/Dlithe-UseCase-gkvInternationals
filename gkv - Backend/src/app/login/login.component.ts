import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginCustomerService } from 'src/service/login.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  registrationForm: FormGroup;
  submitted:boolean=false;

  constructor( private fb : FormBuilder, private loginService:LoginCustomerService, private router:Router) { 
    this.registrationForm = this.fb.group ({
      adminLoginName: ['',Validators.required],
      adminLoginPassword: ['',Validators.required]
      
    })
  }
   
  ngOnInit(): void {
  }
  navigateLandingPage(){
    this.router.navigateByUrl('/landing-page');
  }

  onNavigateHome(){
    this.loginService.login(this.registrationForm.value)
    .subscribe((res)=>{
      console.log(res);
      this.router.navigate(['/class-list']);
    },err =>{
      console.log("Admin Username is required !")
    
    })
    
}
}