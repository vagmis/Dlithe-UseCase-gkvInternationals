package com.dlithe.gkveducation.service;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.dto.SchoolStandardResponse;

import com.dlithe.gkveducation.dto.StudentDetailsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface StandardService {
    // ResponseEntity<BaseResponse> addStandard(StandardRequest standardRequest);

    ResponseEntity<BaseResponse> addStudent(StudentDetailsRequest studentDetailsRequest);

    ResponseEntity<BaseResponse> findStudentDetails(int studentId);

    ResponseEntity<BaseResponse> findStudentIdAndRollNumber(int studentDetailsId, int studentRollNumber);

    ResponseEntity<BaseResponse> purchaseProduct(SchoolStandardResponse schoolStandardResponse);

}
