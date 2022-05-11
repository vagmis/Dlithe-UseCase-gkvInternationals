package com.dlithe.gkveducation.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class GKVStudentDetailsListResponse {

        private int gkvClassNumber;
        private String gkvStandardName;
        private String gkvStudentName;
        private String gkvStudentRollNumber;

}
