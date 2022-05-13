package com.dlithe.gkveducation.controller;


import com.dlithe.gkveducation.dto.BaseResponse;
import com.dlithe.gkveducation.service.StandardService;
import com.dlithe.gkveducation.service.TeachersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
public class TeachersController {
    @Autowired
    private TeachersService teachersService;

    @GetMapping("get-teacher-data/{teacherId}")
    public ResponseEntity<BaseResponse> getTeacherDeatils(@PathVariable int teacherId){
        if(teacherId == 0 || String.valueOf(teacherId) == null){
            BaseResponse baseResponse = new BaseResponse();
            baseResponse.setMessage("User ID not found");
            baseResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            baseResponse.setHttpStatusCode(HttpStatus.BAD_REQUEST.value());

            return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
        }
        return teachersService.findTeacherData(teacherId);
    }

    @GetMapping("get-teacher-list")
    public  ResponseEntity<BaseResponse>  getTeachersList(){
        return teachersService.getTeachersList();
    }
}


//  DETAILS FEILDS ADD----------------done
// GET LIST-not done
//  CLASS LIST - FORIGN KEY ADD JOIN 2 TABLES OF THIS --priya
// LOGIN - PASSWORD ADD
// PUT
// STD AND ROLLNUMBER