package com.dlithe.gkveducation.service;

import com.dlithe.gkveducation.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface TeachersService {
    ResponseEntity<BaseResponse> findTeacherData(int teacherId);

    ResponseEntity<BaseResponse> getTeachersList();

}
