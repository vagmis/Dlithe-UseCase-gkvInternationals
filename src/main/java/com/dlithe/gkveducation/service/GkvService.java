package com.dlithe.gkveducation.service;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.dto.GkvStudentDetailsRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface GkvService {
    ResponseEntity<BaseResponse> getGkvClassStudentList(int gkvClassNumber);

    ResponseEntity<BaseResponse> fetchGkvStudentDetails(String gkvStudentRollNumber);

    ResponseEntity<BaseResponse> gkvAddStudentDetails(GkvStudentDetailsRequest gkvStudentDetailsRequest);


    ResponseEntity<BaseResponse> getGkvClassList();

    ResponseEntity<BaseResponse> updateStudentDeatils(GkvStudentDetailsRequest gkvStudentDetailsRequest);


//    ResponseEntity<BaseResponse> updateGkvStudentDeatails(String gkvStudentRollNumber);



}
