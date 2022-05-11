package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class SchoolClassesListResponse {

    private int schoolStandardId;
    private String  schoolStandardName;
    private String schoolStandardPhoto;
    private String schoolStandardTagline;
    private int classNumber;

}
