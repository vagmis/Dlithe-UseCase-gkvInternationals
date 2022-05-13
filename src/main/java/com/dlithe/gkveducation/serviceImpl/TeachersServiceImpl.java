package com.dlithe.gkveducation.serviceImpl;

import com.dlithe.gkveducation.dto.*;
import com.dlithe.gkveducation.entity.GkvEntity;
import com.dlithe.gkveducation.entity.TeachersEntity;
import com.dlithe.gkveducation.repository.TeachersDAO;
import com.dlithe.gkveducation.service.TeachersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeachersServiceImpl implements TeachersService {

    @Autowired
    private TeachersDAO teachersDAO;

    @Override
    public ResponseEntity<BaseResponse> findTeacherData(int teacherId) {
        BaseResponse baseResponse = new BaseResponse();

        TeachersListResponse teachersListResponse = new TeachersListResponse();
        Optional<TeachersEntity> teachersEntity = teachersDAO.findById(teacherId);
        if(!teachersEntity.isPresent()){
            baseResponse.setMessage("Id not found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }

        TeachersEntity teacherData = teachersEntity.get();

        teachersListResponse.setTeacherName(teacherData.getTeacherName());
        teachersListResponse.setTeacherPhoto(teacherData.getTeacherPhoto());
        teachersListResponse.setTeacherDescription(teacherData.getTeacherDescription());

        baseResponse.setMessage("User found");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(teachersListResponse);

        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> getTeachersList() {
        BaseResponse baseResponse = new BaseResponse();
        List<TeachersEntity> teachersEntities = teachersDAO.getTeacherList();
        TeacherResponse teacherResponse = new TeacherResponse();
        List<TeachersListResponse> teachersListResponseList = new ArrayList<>();
        for(TeachersEntity teachers :teachersEntities){
            TeachersListResponse teachersListResponse =  new TeachersListResponse();
            teachersListResponse.setTeacherName(teachers.getTeacherName());
            teachersListResponse.setTeacherDescription(teachers.getTeacherDescription());
            teachersListResponse.setTeacherPhoto(teachers.getTeacherPhoto());
            teachersListResponseList.add(teachersListResponse);
        }
        teacherResponse.setTeachersListResponses(teachersListResponseList);
        baseResponse.setMessage("Teachers List  Fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(teacherResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

}
