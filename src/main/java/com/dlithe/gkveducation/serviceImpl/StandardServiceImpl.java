package com.dlithe.gkveducation.serviceImpl;

import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.dto.SchoolStandardResponse;
import com.dlithe.gkveducation.dto.StudentDetailsRequest;
import com.dlithe.gkveducation.dto.StudentDetailsResponse;
import com.dlithe.gkveducation.entity.SchoolStandardEntity;
import com.dlithe.gkveducation.entity.StudentDetailsEntity;
import com.dlithe.gkveducation.repository.SchoolStandardDAO;
import com.dlithe.gkveducation.repository.StudentDetailsDAO;
import com.dlithe.gkveducation.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StandardServiceImpl implements StandardService {
//    @Autowired
//    private StandardDAO standardDAO;

    @Autowired
    private StudentDetailsDAO studentDetailsDAO;

    @Autowired
    private SchoolStandardDAO schoolStandardDAO;

    /*Adding the standard to the list*/
   /* @Override
    public ResponseEntity<BaseResponse> addStandard(StandardRequest standardRequest) {
        BaseResponse baseResponse = new BaseResponse();

        StandardEntity standardEntity = new StandardEntity();
        standardEntity.setStandardName(standardRequest.getStandardName());
        standardEntity.setStandardTagline(standardRequest.getStandardTagline());
        standardDAO.save(standardEntity);

        baseResponse.setMessage("Standard added successfully");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }*/

    /*  Adding the students details to the list  */
    @Override
    public ResponseEntity<BaseResponse> addStudent(StudentDetailsRequest studentDetailsRequest) {
        BaseResponse baseResponse = new BaseResponse();

        StudentDetailsEntity studentDetailsEntity = new StudentDetailsEntity();
        studentDetailsEntity.setStudentName(studentDetailsRequest.getStudentName());
        studentDetailsEntity.setStudentFatherName(studentDetailsRequest.getStudentFatherName());
        studentDetailsEntity.setStudentMotherName(studentDetailsRequest.getStudentMotherName());
        studentDetailsEntity.setStudentAddress(studentDetailsRequest.getStudentAddress());
        studentDetailsEntity.setStudentPhoneNumber(studentDetailsRequest.getStudentPhoneNumber());
        studentDetailsEntity.setStudentRollNumber(studentDetailsRequest.getStudentRollNumber());
        studentDetailsEntity.setStudentSurname(studentDetailsRequest.getStudentSurname());


        studentDetailsDAO.save(studentDetailsEntity);

        baseResponse.setMessage("Student added successfully");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse> findStudentDetails(int studentId) {
        BaseResponse baseResponse = new BaseResponse();

        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();

        Optional<StudentDetailsEntity> studentDetailsEntity = studentDetailsDAO.findById(studentId);
        if(!studentDetailsEntity.isPresent()){
            baseResponse.setMessage("Id not found");
            baseResponse.setHttpStatus(HttpStatus.NOT_FOUND);
            baseResponse.setHttpStatusCode(HttpStatus.NOT_FOUND.value());

            return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.NOT_FOUND);
        }

        StudentDetailsEntity studentData = studentDetailsEntity.get();

        studentDetailsResponse.setStudentName(studentData.getStudentName());
        studentDetailsResponse.setStudentFatherName(studentData.getStudentFatherName());
        studentDetailsResponse.setStudentMotherName(studentData.getStudentMotherName());
        studentDetailsResponse.setStudentPhoneNumber(studentData.getStudentPhoneNumber());
        studentDetailsResponse.setStudentAddress(studentData.getStudentAddress());
        studentDetailsResponse.setStudentRollNumber(studentData.getStudentRollNumber());

        baseResponse.setMessage("User found");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(studentDetailsResponse);

        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);

    }
    // LIST OF STUDENTS

    @Override
    public ResponseEntity<BaseResponse> findStudentIdAndRollNumber(int studentDetailsId, int studentRollNumber) {

        BaseResponse baseResponse = new BaseResponse();

        StudentDetailsResponse studentDetailsResponse = new StudentDetailsResponse();

        StudentDetailsEntity studentDetailsEntity= studentDetailsDAO.findStudentIdAndRollNumber(studentDetailsId,studentRollNumber);

        studentDetailsResponse.setStudentName(studentDetailsEntity.getStudentName());
        studentDetailsResponse.setStudentFatherName(studentDetailsEntity.getStudentFatherName());
        studentDetailsResponse.setStudentMotherName(studentDetailsEntity.getStudentMotherName());
        studentDetailsResponse.setStudentAddress(studentDetailsEntity.getStudentAddress());
        studentDetailsResponse.setStudentPhoneNumber(studentDetailsEntity.getStudentPhoneNumber());
        studentDetailsResponse.setStudentRollNumber(studentDetailsEntity.getStudentRollNumber());


        baseResponse.setMessage("User found");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(studentDetailsResponse);

        return new ResponseEntity<BaseResponse>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> purchaseProduct(SchoolStandardResponse schoolStandardResponse) {
        SchoolStandardEntity schoolStandardEntity = new SchoolStandardEntity();
        BaseResponse baseResponse = new BaseResponse();

        schoolStandardEntity.setSchoolStandardId(schoolStandardResponse.getSchoolStandardId());
        schoolStandardEntity.setSchoolStandardName(schoolStandardResponse.getSchoolStandardName());
        schoolStandardEntity.setSchoolStandardPhoto(schoolStandardResponse.getSchoolStandardPhoto());
        schoolStandardEntity.setSchoolStandardTagline(schoolStandardResponse.getSchoolStandardTagline());
        schoolStandardDAO.save(schoolStandardEntity);

        for(StudentDetailsRequest studentDetailsRequest: schoolStandardResponse.getStudentDetailsRequestList()){

            StudentDetailsEntity studentDetailsEntity = new StudentDetailsEntity();

            studentDetailsEntity.setStudentName(studentDetailsRequest.getStudentName());
            studentDetailsEntity.setStudentSurname(studentDetailsRequest.getStudentSurname());
            studentDetailsEntity.setStudentFatherName(studentDetailsRequest.getStudentFatherName());
            studentDetailsEntity.setStudentMotherName(studentDetailsRequest.getStudentMotherName());
            studentDetailsEntity.setStudentAddress(studentDetailsRequest.getStudentAddress());

            studentDetailsDAO.save(studentDetailsEntity);
        }
        baseResponse.setMessage("Product added to cart successfully");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }
    }




