package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class StudentDetailsResponse {


    private String studentName;
    private String studentFatherName;
    private String studentMotherName;
    private String studentAddress;
    private String studentPhoneNumber;
    private int studentRollNumber;

    public static class GkvClassListRequest {
    }
}
