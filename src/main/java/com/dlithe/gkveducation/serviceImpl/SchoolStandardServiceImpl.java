package com.dlithe.gkveducation.serviceImpl;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.dto.SchoolStandardResponse;
import com.dlithe.gkveducation.entity.SchoolStandardEntity;
import com.dlithe.gkveducation.repository.SchoolStandardDAO;
import com.dlithe.gkveducation.service.SchoolStandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolStandardServiceImpl implements SchoolStandardService {

    @Autowired
    private SchoolStandardDAO schoolStandardDAO;

    @Override
    public ResponseEntity<BaseResponse> findSchoolData(int schoolStandardId) {
        BaseResponse baseResponse = new BaseResponse();
        SchoolStandardResponse schoolStandardResponse =  new SchoolStandardResponse();
        Optional<SchoolStandardEntity> schoolStandardEntity = schoolStandardDAO.findById(schoolStandardId);

        if(!schoolStandardEntity.isPresent()){
            baseResponse.setMessage("Id not found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }

        SchoolStandardEntity schoolListData =  schoolStandardEntity.get();

        schoolStandardResponse.setSchoolStandardName(schoolListData.getSchoolStandardName());
        schoolStandardResponse.setSchoolStandardPhoto(schoolListData.getSchoolStandardPhoto());


        baseResponse.setMessage("User found");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(schoolStandardResponse);

        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }
}

