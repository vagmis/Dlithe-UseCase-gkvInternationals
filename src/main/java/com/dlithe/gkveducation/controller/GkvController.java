package com.dlithe.gkveducation.controller;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.dto.GkvStudentDetailsRequest;
import com.dlithe.gkveducation.service.GkvService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class GkvController {

    @Autowired
    private GkvService gkvService;

    @PostMapping("add-gkv-student-details")
    public ResponseEntity<BaseResponse> gkvAddStudent(@RequestBody GkvStudentDetailsRequest gkvStudentDetailsRequest){
        if(gkvStudentDetailsRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Not able to added");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return gkvService.gkvAddStudentDetails(gkvStudentDetailsRequest);
    }

    @GetMapping("get-gkv-class-list")
    public  ResponseEntity<BaseResponse>  getGkvClassLists(){
        return gkvService.getGkvClassList();
    }

    @GetMapping("get-gkv-class-student-list/{gkvClassNumber}")
    public ResponseEntity<BaseResponse> getGkvClassStudentLists(@PathVariable int gkvClassNumber){
        if(gkvClassNumber == 0 || String.valueOf(gkvClassNumber) == null || gkvClassNumber > 12){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Standard not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return gkvService.getGkvClassStudentList(gkvClassNumber);
    }

    @GetMapping("get-gkv-student-details/{gkvStudentRollNumber}")
    public ResponseEntity<BaseResponse> fetchGkvNewStudentDetails(@PathVariable String gkvStudentRollNumber){
        return gkvService.fetchGkvStudentDetails(gkvStudentRollNumber);
    }


    @PutMapping("update-gkv-student-details")
    public ResponseEntity<BaseResponse> updateStudentDetails(@RequestBody GkvStudentDetailsRequest gkvStudentDetailsRequest){
        if(gkvStudentDetailsRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("Not able to added");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return gkvService.updateStudentDeatils(gkvStudentDetailsRequest);
    }



}
