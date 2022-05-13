import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './home/home.component';

import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatNativeDateModule} from '@angular/material/core';
import {MatSelectModule} from '@angular/material/select';
import {MatIconModule} from '@angular/material/icon';
import {MatRadioModule} from '@angular/material/radio';
import {MatGridListModule} from '@angular/material/grid-list';
import { AddStudentComponent } from './add-student/add-student.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { EditStudentDetailsComponent } from './edit-student-details/edit-student-details.component';
import { LoginComponent } from './login/login.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { HttpClientModule } from '@angular/common/http';
import { TeacherComponent } from './teacher/teacher.component';
import { YouTubePlayerModule } from "@angular/youtube-player";
import { ClassListComponent } from './class-list/class-list.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import { StudentListComponent } from './student-list/student-list.component';
import { MatDialogModule } from '@angular/material/dialog';
import { LogOutComponent } from './log-out/log-out.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatTableModule} from '@angular/material/table';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AddStudentComponent,
    EditStudentDetailsComponent,
    LoginComponent,
    StudentDetailsComponent,
    LandingPageComponent,
    TeacherComponent,
    ClassListComponent,
    StudentListComponent,
    LogOutComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatInputModule,
    MatSelectModule,
    MatDatepickerModule,
    MatIconModule,
    MatRadioModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    HttpClientModule,
    YouTubePlayerModule,
    MatToolbarModule,
    MatDialogModule,
    MatDividerModule,
    MatSidenavModule,
    MatTableModule,
 
  

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
