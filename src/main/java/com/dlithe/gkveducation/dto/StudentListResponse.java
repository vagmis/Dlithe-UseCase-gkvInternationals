package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StudentListResponse {

    private String  studentName;
    private String  studentSurname;
    private String studentFatherName;
    private String studentMotherName;
    private String studentAddress;
    private String studentPhoneNumber;
    private int studentRollNumber;
}
