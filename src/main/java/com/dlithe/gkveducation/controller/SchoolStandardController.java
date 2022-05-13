package com.dlithe.gkveducation.controller;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.service.SchoolStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolStandardController {

    @Autowired
    private SchoolStandardService schoolStandardService;

    @GetMapping("get-standard-data/{schoolStandardId}")
    public ResponseEntity<BaseResponse> getSchoolStandard(@PathVariable int schoolStandardId){
        if(schoolStandardId == 0 || String.valueOf(schoolStandardId) == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("User ID not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());

            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return schoolStandardService.findSchoolData(schoolStandardId);
    }
}
