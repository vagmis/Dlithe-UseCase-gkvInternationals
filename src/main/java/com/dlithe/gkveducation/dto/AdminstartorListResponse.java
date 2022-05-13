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
public class AdminstartorListResponse {

    private String adminLoginName;
    private String adminLoginPassword;
    private String adminPhoto;
    private String adminDesignation;
}
