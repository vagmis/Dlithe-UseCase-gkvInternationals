package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class ClassStudentListResponse {

    private int schoolStandardId;
    private int studentRollNumber;
    private String  studentName;

}
