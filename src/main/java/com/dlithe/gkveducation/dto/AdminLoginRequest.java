package com.dlithe.gkveducation.dto;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class AdminLoginRequest {

    private String adminLoginName;
    private String adminLoginPassword;
}
