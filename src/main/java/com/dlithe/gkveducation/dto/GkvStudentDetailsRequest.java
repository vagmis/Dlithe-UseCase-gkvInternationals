package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GkvStudentDetailsRequest {

    private String  gkvStudentName;
    private String  gkvStudentSurname;
    private String gkvStudentFatherName;
    private String gkvStudentMotherName;
    private String gkvStudentAddress;
    private String gkvStudentPhoneNumber;
    private String gkvStudentRollNumber;
    private int gkvClassNumber;
    private String  gkvStandardName;
}
