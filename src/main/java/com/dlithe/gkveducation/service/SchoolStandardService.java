package com.dlithe.gkveducation.service;

import com.dlithe.gkveducation.dto.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public interface SchoolStandardService {
    ResponseEntity<BaseResponse> findSchoolData(int schoolStandardId);
}
