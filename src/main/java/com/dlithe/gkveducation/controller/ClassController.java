package com.dlithe.gkveducation.controller;

import com.dlithe.gkveducation.dto.*;
import com.dlithe.gkveducation.service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class ClassController {

    @Autowired
    private ClassService classService;


    @PostMapping("add-class-student-details")
    public ResponseEntity<BaseResponse> addClassStudentDetails(@RequestBody ClassListRequest classListRequest){
        if(classListRequest  == null || classListRequest.getClassStudentListRequests().isEmpty()){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Not able to added");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return classService.addClassStudentDetail(classListRequest);
    }

    @GetMapping("get-class-list-students/{schoolStandardId}")
    public ResponseEntity<BaseResponse> getClassStudentLists(@PathVariable int schoolStandardId){
        if(schoolStandardId == 0 || String.valueOf(schoolStandardId) == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("User ID not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return classService.getClassStudentList(schoolStandardId);
    }

    @PostMapping("add-class-student-single-details")
    public ResponseEntity<BaseResponse> addNewClassStudentDetails(@RequestBody ClassStudentListRequest classStudentListRequest){
        if(classStudentListRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Not able to added");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return classService.addNewClassStudentDetail(classStudentListRequest);
    }
//   To add the classes thsese is used
    @PostMapping("add-class")
    public ResponseEntity<BaseResponse> addNewClass(@RequestBody ClassRequest classRequest){
        if(classRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Not able to added");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return classService.addClass(classRequest);
    }

// to get whole details of students to pass in student details
    @GetMapping("get-full-student-details/{schoolStandardId}")
    public ResponseEntity<BaseResponse> getStudentDetails(@PathVariable int schoolStandardId){
        if(schoolStandardId == 0 || String.valueOf(schoolStandardId) == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("User ID not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return classService.getStudentDetails(schoolStandardId);
    }


    @GetMapping("get-class-list")
    public  ResponseEntity<BaseResponse>  getClassList(){
        return classService.getAllClassList();
    }

}
