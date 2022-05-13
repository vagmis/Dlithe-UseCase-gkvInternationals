package com.dlithe.gkveducation.service;

import com.dlithe.gkveducation.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface ClassService {
    ResponseEntity<BaseResponse> addClassStudentDetail(ClassListRequest classListRequest);

    ResponseEntity<BaseResponse> getClassStudentList(int schoolStandardId);


    ResponseEntity<BaseResponse> addNewClassStudentDetail(ClassStudentListRequest classStudentListRequest);

    ResponseEntity<BaseResponse> addClass(ClassRequest classRequest);

    ResponseEntity<BaseResponse> getStudentDetails(int schoolStandardId);


    ResponseEntity<BaseResponse> getAllClassList();

}

