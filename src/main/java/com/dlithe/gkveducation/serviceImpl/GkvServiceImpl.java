package com.dlithe.gkveducation.serviceImpl;

import com.dlithe.gkveducation.dto.*;
import com.dlithe.gkveducation.entity.GkvEntity;
import com.dlithe.gkveducation.repository.GkvDAO;
import com.dlithe.gkveducation.service.GkvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class GkvServiceImpl implements GkvService {

    @Autowired
    private GkvDAO gkvDAO;

    @Override
    public ResponseEntity<BaseResponse> getGkvClassStudentList(int gkvClassNumber) {
        BaseResponse baseResponse = new BaseResponse();
        List<GkvEntity> gkvEntityList = gkvDAO.getGkvStudentList(gkvClassNumber);
        GKVClassStudentResponse gkvClassStudentResponse = new GKVClassStudentResponse();
        List<GKVStudentDetailsListResponse> gkvStudentDetailsListResponseList = new LinkedList<>();
        for(GkvEntity gkvEntity:gkvEntityList){
            GKVStudentDetailsListResponse gkvStudentDetailsListResponse =  new GKVStudentDetailsListResponse();
            gkvStudentDetailsListResponse.setGkvClassNumber(gkvEntity.getGkvClassNumber());
            gkvStudentDetailsListResponse.setGkvStandardName(gkvEntity.getGkvStandardName());
            gkvStudentDetailsListResponse.setGkvStudentName(gkvEntity.getGkvStudentName());
            gkvStudentDetailsListResponse.setGkvStudentRollNumber(gkvEntity.getGkvStudentRollNumber());
            gkvStudentDetailsListResponseList.add(gkvStudentDetailsListResponse);
        }
        gkvClassStudentResponse.setGkvStudentDetailsListResponses(gkvStudentDetailsListResponseList);
        baseResponse.setMessage("Fetched student list in a class");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(gkvClassStudentResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> fetchGkvStudentDetails(String gkvStudentRollNumber) {
        BaseResponse baseResponse = new BaseResponse();
        GkvStudentDetailsResponse gkvStudentDetailsResponse = new GkvStudentDetailsResponse();
        Optional<GkvEntity> gkvEntity1 = gkvDAO.getGkvStudentDetailsRollNumber(gkvStudentRollNumber);
        if(!gkvEntity1.isPresent()){
            baseResponse.setMessage("Student Details not Found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());
            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }
        GkvEntity gkvStudentData = gkvEntity1.get();
        gkvStudentDetailsResponse.setGkvStudentName(gkvStudentData.getGkvStudentName());
        gkvStudentDetailsResponse.setGkvStudentSurname(gkvStudentData.getGkvStudentSurname());
        gkvStudentDetailsResponse.setGkvStudentFatherName(gkvStudentData.getGkvStudentFatherName());
        gkvStudentDetailsResponse.setGkvStudentMotherName(gkvStudentData.getGkvStudentMotherName());
        gkvStudentDetailsResponse.setGkvStudentRollNumber(gkvStudentData.getGkvStudentRollNumber());
        gkvStudentDetailsResponse.setGkvStudentAddress(gkvStudentData.getGkvStudentAddress());
        gkvStudentDetailsResponse.setGkvStudentPhoneNumber(gkvStudentData.getGkvStudentPhoneNumber());
        gkvStudentDetailsResponse.setGkvClassNumber(gkvStudentData.getGkvClassNumber());
        gkvStudentDetailsResponse.setGkvStandardName(gkvStudentData.getGkvStandardName());

        baseResponse.setMessage("Student Details Found ");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(gkvStudentDetailsResponse);
        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> gkvAddStudentDetails(GkvStudentDetailsRequest gkvStudentDetailsRequest) {
        BaseResponse baseResponse = new BaseResponse();
        GkvEntity gkvEntity = new GkvEntity();
        gkvEntity.setGkvStudentName(gkvStudentDetailsRequest.getGkvStudentName());
        gkvEntity.setGkvStudentFatherName(gkvStudentDetailsRequest.getGkvStudentFatherName());
        gkvEntity.setGkvStudentMotherName(gkvStudentDetailsRequest.getGkvStudentMotherName());
        gkvEntity.setGkvStudentAddress(gkvStudentDetailsRequest.getGkvStudentAddress());
        gkvEntity.setGkvStudentPhoneNumber(gkvStudentDetailsRequest.getGkvStudentPhoneNumber());
        gkvEntity.setGkvClassNumber(gkvStudentDetailsRequest.getGkvClassNumber());
        gkvEntity.setGkvStudentSurname(gkvStudentDetailsRequest.getGkvStudentSurname());
        gkvEntity.setGkvStudentRollNumber(gkvStudentDetailsRequest.getGkvStudentRollNumber());
        gkvEntity.setGkvStandardName(gkvStudentDetailsRequest.getGkvStandardName());

        gkvDAO.save(gkvEntity);
        baseResponse.setMessage("added Student details");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse> getGkvClassList() {
        BaseResponse baseResponse = new BaseResponse();
        List<GkvEntity> gkvEntities = gkvDAO.getGkvClassList();
        GkvClaasseResponse gkvClaasseResponse = new GkvClaasseResponse();
        List<GkvClassListResponse> gkvClassListResponseList = new ArrayList<>();
        for(GkvEntity gkvClassList :gkvEntities){
            GkvClassListResponse gkvClassListResponse =  new GkvClassListResponse();
            gkvClassListResponse.setGkvClassNumber(gkvClassList.getGkvClassNumber());
            gkvClassListResponse.setGkvStandardPhoto(gkvClassList.getGkvStandardPhoto());
            gkvClassListResponse.setGkvStandardTagLine(gkvClassList.getGkvStandardTagLine());
            gkvClassListResponse.setGkvStandardName(gkvClassList.getGkvStandardName());
            gkvClassListResponseList.add(gkvClassListResponse);
        }
        gkvClaasseResponse.setGkvClassListResponses(gkvClassListResponseList);
        baseResponse.setMessage("Student Data Fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(gkvClaasseResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> updateStudentDeatils(GkvStudentDetailsRequest gkvStudentDetailsRequest) {
        BaseResponse baseResponse = new BaseResponse();
        GkvEntity gkvEntity = new GkvEntity();
        GkvEntity gkvEntity1 = gkvDAO.updateGkvStudentDetails(gkvEntity.getGkvStudentRollNumber());
        gkvEntity1.setGkvStudentRollNumber(gkvStudentDetailsRequest.getGkvStudentRollNumber());
        gkvEntity1.setGkvStudentName(gkvStudentDetailsRequest.getGkvStudentName());
        gkvEntity1.setGkvStudentSurname(gkvStudentDetailsRequest.getGkvStudentSurname());
        gkvDAO.save(gkvEntity);

        baseResponse.setMessage("added Student details");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

//    @Override
//    public ResponseEntity<BaseResponse> updateGkvStudentDeatails(String gkvStudentRollNumber) {
//        BaseResponse baseResponse = new BaseResponse();
//        Optional<GkvEntity> gkvEntity = gkvDAO.updateGkvStudentDetails(gkvStudentRollNumber);
//
//        GkvEntity gkvEntity1 = new GkvEntity();
//        gkvEntity1.setGkvStudentName();
//
//
//        return null;
//    }
}

