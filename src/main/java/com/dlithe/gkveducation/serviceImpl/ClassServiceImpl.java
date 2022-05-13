package com.dlithe.gkveducation.serviceImpl;

import com.dlithe.gkveducation.dto.*;
import com.dlithe.gkveducation.entity.AdminLoginEntity;
import com.dlithe.gkveducation.entity.ClassListEntity;
import com.dlithe.gkveducation.entity.StudentDetail;
import com.dlithe.gkveducation.repository.ClassListDAO;
import com.dlithe.gkveducation.repository.StudentDetailsListDAO;
import com.dlithe.gkveducation.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassListDAO classListDAO;

    @Autowired
    private StudentDetailsListDAO studentDetailsListDAO;

    @Override
    public ResponseEntity<BaseResponse> addClassStudentDetail(ClassListRequest classListRequest) {
            ClassListEntity classListEntity = new ClassListEntity();
            BaseResponse baseResponse = new BaseResponse();

           // classListEntity.setSchoolStandardId(classListRequest.getSchoolStandardId());
            classListDAO.save(classListEntity);

            for(ClassStudentListRequest classStudentListRequest: classListRequest.getClassStudentListRequests()){

                StudentDetail classStudentListEntity = new StudentDetail();

                classStudentListEntity.setStudentName(classStudentListRequest.getStudentName());
                classStudentListEntity.setStudentSurname(classStudentListRequest.getStudentSurname());
                classStudentListEntity.setStudentFatherName(classStudentListRequest.getStudentFatherName());
                classStudentListEntity.setStudentMotherName(classStudentListRequest.getStudentMotherName());
                classStudentListEntity.setStudentRollNumber(classStudentListRequest.getStudentRollNumber());
                classStudentListEntity.setStudentAddress(classStudentListRequest.getStudentAddress());
                classStudentListEntity.setStudentPhoneNumber(classStudentListRequest.getStudentPhoneNumber());
                //classStudentListEntity.setSchoolStandardId(classStudentListRequest.getSchoolStandardId());


                studentDetailsListDAO.save(classStudentListEntity);
            }
            baseResponse.setMessage("Student added Successfully");
            baseResponse.setHttpStatus(HttpStatus.CREATED);
            baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
            return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
        }

    @Override
    public ResponseEntity<BaseResponse> getClassStudentList(int schoolStandardId) {
        BaseResponse baseResponse = new BaseResponse();

        List<StudentDetail> studentDetailList = studentDetailsListDAO.findBySchoolStandardId(schoolStandardId);

        ClassStudentResponse classStudentResponse = new ClassStudentResponse();

        List<ClassStudentListResponse> classStudentListResponseList = new ArrayList<>();
        for(StudentDetail studentDetail:studentDetailList){
            ClassStudentListResponse classStudentListResponse =  new ClassStudentListResponse();
            classStudentListResponse.setStudentName(studentDetail.getStudentName());
            classStudentListResponse.setStudentRollNumber(studentDetail.getStudentRollNumber());
           // classStudentListResponse.setSchoolStandardId(studentDetail.getSchoolStandardId());
            classStudentListResponseList.add(classStudentListResponse);


        }

        classStudentResponse.setClassStudentListResponseList(classStudentListResponseList);

        baseResponse.setMessage("Student Data Fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());

        baseResponse.setResponse(classStudentResponse);

        return new ResponseEntity<>(baseResponse, HttpStatus.OK);

    }

    @Override
    public ResponseEntity<BaseResponse> addNewClassStudentDetail(ClassStudentListRequest classStudentListRequest) {
        BaseResponse baseResponse = new BaseResponse();
        StudentDetail studentDetail = new StudentDetail();
        studentDetail.setStudentName(classStudentListRequest.getStudentName());
        studentDetail.setStudentSurname(classStudentListRequest.getStudentSurname());
        studentDetail.setStudentFatherName(classStudentListRequest.getStudentFatherName());
        studentDetail.setStudentMotherName(classStudentListRequest.getStudentMotherName());
        studentDetail.setStudentPhoneNumber(classStudentListRequest.getStudentPhoneNumber());
        studentDetail.setStudentAddress(classStudentListRequest.getStudentAddress());
        studentDetail.setStudentRollNumber(classStudentListRequest.getStudentRollNumber());
       // studentDetail.setStudentDetailsId(classStudentListRequest.getStudentDetailsId());
        studentDetailsListDAO.save(studentDetail);
        baseResponse.setMessage("Login successfully");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse> addClass(ClassRequest classRequest) {
        BaseResponse baseResponse = new BaseResponse();
        ClassListEntity classListEntity = new ClassListEntity();
        classListEntity.setSchoolStandardId(classRequest.getSchoolStandardId());
        classListDAO.save(classListEntity);
        baseResponse.setMessage("Added Class successfully");
        baseResponse.setHttpStatus(HttpStatus.CREATED);
        baseResponse.setHttpStatusCode(HttpStatus.CREATED.value());
        return new ResponseEntity<>(baseResponse, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BaseResponse> getStudentDetails(int schoolStandardId) {
        BaseResponse baseResponse = new BaseResponse();
        List<StudentDetail> studentDetailList = studentDetailsListDAO.findBySchoolStandardIdAllStudents(schoolStandardId);
        StudentResponse studentResponse = new StudentResponse();
        List<StudentListResponse> studentListResponseList = new ArrayList<>();
        for(StudentDetail studentDetail:studentDetailList){
            StudentListResponse studentListResponse =  new StudentListResponse();
            studentListResponse.setStudentName(studentDetail.getStudentName());
            studentListResponse.setStudentSurname(studentDetail.getStudentSurname());
            studentListResponse.setStudentFatherName(studentDetail.getStudentFatherName());
            studentListResponse.setStudentMotherName(studentDetail.getStudentMotherName());
            studentListResponse.setStudentAddress(studentDetail.getStudentAddress());
            studentListResponse.setStudentPhoneNumber(studentDetail.getStudentPhoneNumber());
            studentListResponse.setStudentRollNumber(studentDetail.getStudentRollNumber());
            studentListResponseList.add(studentListResponse);
        }
        studentResponse.setStudentListResponses(studentListResponseList);
        baseResponse.setMessage("Student Data Fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(studentResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<BaseResponse> getAllClassList() {
        BaseResponse baseResponse = new BaseResponse();
        List<ClassListEntity> classListEntities = classListDAO.getAllClassList();
        SchoolClassesResponse schoolClassesResponse = new SchoolClassesResponse();
        List<SchoolClassesListResponse> schoolClassesListResponses = new ArrayList<>();
        for(ClassListEntity classList :classListEntities){
            SchoolClassesListResponse schoolClassesListResponse =  new SchoolClassesListResponse();
            schoolClassesListResponse.setClassNumber(classList.getClassNumber());
            schoolClassesListResponse.setSchoolStandardName(classList.getSchoolStandardName());
            schoolClassesListResponse.setSchoolStandardPhoto(classList.getSchoolStandardPhoto());
            schoolClassesListResponse.setSchoolStandardTagline(classList.getSchoolStandardTagline());
            schoolClassesListResponse.setSchoolStandardId(classList.getSchoolStandardId());
            schoolClassesListResponses.add(schoolClassesListResponse);
        }
        schoolClassesResponse.setSchoolClassesListResponses(schoolClassesListResponses);
        baseResponse.setMessage("Student Data Fetched");
        baseResponse.setHttpStatus(HttpStatus.OK);
        baseResponse.setHttpStatusCode(HttpStatus.OK.value());
        baseResponse.setResponse(schoolClassesResponse);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);

        }
    }


