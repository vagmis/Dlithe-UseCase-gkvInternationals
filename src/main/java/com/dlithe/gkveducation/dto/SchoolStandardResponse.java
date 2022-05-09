package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SchoolStandardResponse {

    private int schoolStandardId;
    private String schoolStandardName;
    private String schoolStandardPhoto;
    private String schoolStandardTagline;

    private List<StudentDetailsRequest> studentDetailsRequestList;
}
