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
public class GkvClassListResponse {

    private String  gkvStandardName;
    private String gkvStandardPhoto;
    private String gkvStandardTagLine;
    private int gkvClassNumber;
}
