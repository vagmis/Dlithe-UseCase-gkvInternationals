package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GkvStudentDetailsResponse {

    private String  gkvStudentRollNumber;
    private String  gkvStudentName;
    private String  gkvStudentSurname;
    private String  gkvStudentFatherName;
    private String  gkvStudentMotherName;
    private String  gkvStudentAddress;
    private String  gkvStudentPhoneNumber;
    private int gkvClassNumber;
    private String  gkvStandardName;

}
