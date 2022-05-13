import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
@Injectable({
    providedIn:'root'
})
export class LoginCustomerService{
    registerBody(value: any) {
      throw new Error('Method not implemented.');
    }
    baseUrl="http://localhost:8089/";
    constructor(private http:HttpClient){

    }
    login(loginBody:any){
        const url=`${this.baseUrl}add-admin-login`
        return this.http.post(url,loginBody);
    }
// add-class-student-single-details
    register(registerBody:any){
        const url=`${this.baseUrl}add-gkv-student-details`
        return this.http.post(url,registerBody);
    }

    addStandard(standard:any){
        const url=`${this.baseUrl}add-class`
        return this.http.post(url,standard);
    }

    getStudentDetails(schoolStandardId:any){
        const url=`${this.baseUrl}get-full-student-details/{schoolStandardId}`
        return this.http.get(url);
    }

    getClassList(){
        const url=`${this.baseUrl}get-gkv-class-list`
        return this.http.get(url);
    }

    getStudentsList(gkvClassNumber:any){
        const url=`${this.baseUrl}get-gkv-class-student-list/${gkvClassNumber}`
        return this.http.get(url);
    }

    // get-gkv-student-details/{gkvStudentRollNumber}
    getEachStudentDetial(gkvStudentRollNumber:any){
        const url=`${this.baseUrl}get-gkv-student-details/${gkvStudentRollNumber}`
        return this.http.get(url);
    }

    editStudentDetial(gkvStudentRollNumber:any){
        const url=`${this.baseUrl}get-gkv-student-details/${gkvStudentRollNumber}`
        return this.http.get(url);
    }
    
    getTeacherList(){
        const url=`${this.baseUrl}get-teacher-list`
        return this.http.get(url);
    }

    getAdmin(){
        const url=`${this.baseUrl}get-administrator-list`
        return this.http.get(url);
    }
}
