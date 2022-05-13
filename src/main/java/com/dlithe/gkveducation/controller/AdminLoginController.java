package com.dlithe.gkveducation.controller;

import com.dlithe.gkveducation.dto.AdminLoginRequest;
import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.service.AdminLoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class AdminLoginController {

    @Autowired
    private AdminLoginService adminLoginService;

    @PostMapping("add-admin-login-query")
    public ResponseEntity<BaseResponse> addAdminNewLogin(@RequestBody AdminLoginRequest adminLoginRequest){
        if(adminLoginRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return adminLoginService.addAdminLogin(adminLoginRequest);
    }

    @PostMapping("add-admin-login")
    public ResponseEntity<BaseResponse> addLogin(@RequestBody AdminLoginRequest adminLoginRequest){
        if(adminLoginRequest  == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage(" Value should not be null ");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return adminLoginService.addedUser(adminLoginRequest);
    }

    @GetMapping("get-administrator-list")
    public  ResponseEntity<BaseResponse>  getTeachersList(){
        return adminLoginService.getAdminList();
    }

}
