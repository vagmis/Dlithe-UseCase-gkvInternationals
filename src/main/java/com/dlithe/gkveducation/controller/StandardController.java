package com.dlithe.gkveducation.controller;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.dto.SchoolStandardResponse;
import com.dlithe.gkveducation.dto.StudentDetailsRequest;
import com.dlithe.gkveducation.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StandardController {

    @Autowired
    private StandardService standardService;

    /* Adding standards class to the list */
   /* @PostMapping("add-standard")
    public ResponseEntity<BaseResponse> addNewStandard(@RequestBody StandardRequest standardRequest){
        if(standardRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return standardService.addStandard(standardRequest);
    } */

    @PostMapping("add-student-details") //standard ID
    public ResponseEntity<BaseResponse> addNewStudent(@RequestBody StudentDetailsRequest studentDetailsRequest){
        if(studentDetailsRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return standardService.addStudent(studentDetailsRequest);
    }

    @GetMapping("get-student-detail/{studentId}")
    public ResponseEntity<BaseResponse> getStudentDeatils(@PathVariable int studentId){
        if(studentId == 0 || String.valueOf(studentId) == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("User ID not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());

            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return standardService.findStudentDetails(studentId);
    }

    @GetMapping("get-student-data/{studentDetailsId}/{studentRollNumber}")
    public ResponseEntity<BaseResponse> getStudentData(@PathVariable int studentDetailsId,@PathVariable int studentRollNumber){
        if(studentDetailsId == 0 || String.valueOf(studentDetailsId) == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("User ID not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());

            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return standardService.findStudentIdAndRollNumber(studentDetailsId,studentRollNumber);
    }

    @PostMapping("purchase-product")
    public ResponseEntity<BaseResponse> purchaseNewProduct(@RequestBody SchoolStandardResponse schoolStandardResponse){
        if(schoolStandardResponse  == null || schoolStandardResponse.getStudentDetailsRequestList().isEmpty()){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return standardService.purchaseProduct(schoolStandardResponse);
    }







}
