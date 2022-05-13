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
public class ClassStudentListRequest {

    private int  studentDetailsId;
    private String  studentName;
    private String  studentSurname;
    private String studentFatherName;
    private String studentMotherName;
    private String studentAddress;
    private String studentPhoneNumber;
    private int studentRollNumber;
    // private int schoolStandardId;
}
