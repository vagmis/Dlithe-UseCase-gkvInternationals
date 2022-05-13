import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddStudentComponent } from './add-student/add-student.component';
import { ClassListComponent } from './class-list/class-list.component';

import { EditStudentDetailsComponent } from './edit-student-details/edit-student-details.component';

import { HomeComponent } from './home/home.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { LogOutComponent } from './log-out/log-out.component';
import { LoginComponent } from './login/login.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { StudentListComponent } from './student-list/student-list.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'add-student', component: AddStudentComponent },
  { path: 'edit-student-details/:editNum', component: EditStudentDetailsComponent },
  { path: 'student-details/:studentNum', component: StudentDetailsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'landing-page', component: LandingPageComponent },
  { path: 'class-list', component: ClassListComponent },
  { path: 'student-list/:classNumber', component: StudentListComponent },
  { path: 'log-out', component: LogOutComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
