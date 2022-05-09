package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StudentDetailsRequest {

    private String studentName;
    private String studentSurname;
    private String studentFatherName;
    private String studentMotherName;
    private String studentAddress;
    private String studentPhoneNumber;
    private int studentRollNumber;
    private String studentClassName;
    private String studentSection;
    private String studentEmail;
    private String studentPincode;
    private String studentPerformance;
    private String studentDate;
    private int schoolStandardId;

   // private StandardRequest standardRequest;

}
