package com.dlithe.gkveducation.service;

import com.dlithe.gkveducation.dto.AdminLoginRequest;
import com.dlithe.gkveducation.dto.BaseResponse;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface AdminLoginService {


    ResponseEntity<BaseResponse> addAdminLogin(AdminLoginRequest adminLoginRequest);

    ResponseEntity<BaseResponse> addedUser(AdminLoginRequest adminLoginRequest);

    ResponseEntity<BaseResponse> getAdminList();

}
