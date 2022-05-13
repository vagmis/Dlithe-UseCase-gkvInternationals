package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class TeachersListResponse {
    private String teacherName;
    private String teacherPhoto;
    private String teacherDescription;
}
