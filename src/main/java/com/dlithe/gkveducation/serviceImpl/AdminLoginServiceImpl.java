package com.dlithe.gkveducation.serviceImpl;


import com.dlithe.gkveducation.dto.*;
import com.dlithe.gkveducation.entity.AdminLoginEntity;
import com.dlithe.gkveducation.entity.TeachersEntity;
import com.dlithe.gkveducation.repository.AdminLoginDAO;
import com.dlithe.gkveducation.service.AdminLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class AdminLoginServiceImpl implements AdminLoginService {

    @Autowired
    private AdminLoginDAO adminLoginDAO;


    @Override
    public ResponseEntity<BaseResponse> addAdminLogin(AdminLoginRequest adminLoginRequest) {
        BaseResponse baseResponse = new BaseResponse();
        AdminLoginEntity adminLoginEntity = new AdminLoginEntity();
        adminLoginEntity.setAdminLoginName(adminLoginRequest.getAdminLoginName());
        adminLoginEntity.setAdminLoginPassword(adminLoginRequest.getAdminLoginPassword());
        adminLoginDAO.save(adminLoginEntity);

        baseResponse.setMessage("Login successfully");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
// add commments
    @Override
    public ResponseEntity<BaseResponse> addedUser(AdminLoginRequest adminLoginRequest) {
        Optional<AdminLoginEntity>  adminLoginEntity = Optional.ofNullable(adminLoginDAO.addedUser(adminLoginRequest.getAdminLoginName(), adminLoginRequest.getAdminLoginPassword()));
        BaseResponse baseResponse = new BaseResponse();
        if(!adminLoginEntity.isPresent()){
            baseResponse.setMessage("Customer not found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<>(baseResponse,HttpStatus.NOT_FOUND);
        }
        baseResponse.setMessage("Login successfully");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> getAdminList() {
            BaseResponse baseResponse = new BaseResponse();
            List<AdminLoginEntity> adminLoginEntities = adminLoginDAO.getAdmins();
            AdminResponse adminResponse = new AdminResponse();
            List<AdminstartorListResponse> adminstartorListResponses = new ArrayList<>();
            for(AdminLoginEntity admins :adminLoginEntities){
                AdminstartorListResponse adminstartorListResponse =  new AdminstartorListResponse();
                adminstartorListResponse.setAdminLoginName(admins.getAdminLoginName());
                adminstartorListResponse.setAdminLoginPassword(admins.getAdminLoginPassword());
                adminstartorListResponse.setAdminPhoto(admins.getAdminPhoto());
                adminstartorListResponse.setAdminDesignation(admins.getAdminDesignation());
                adminstartorListResponses.add(adminstartorListResponse);
            }
            adminResponse.setAdminstartorListResponses(adminstartorListResponses);
            baseResponse.setMessage("Admin Data Fetched");
            baseResponse.setHttpStatus(HttpStatus.OK);
            baseResponse.setHttpStatusCode(HttpStatus.OK.value());
            baseResponse.setResponse(adminResponse);
            return new ResponseEntity<>(baseResponse, HttpStatus.OK);
        }
    }


