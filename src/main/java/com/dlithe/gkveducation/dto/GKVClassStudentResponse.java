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
public class GKVClassStudentResponse {
    //variable nameeeeee
    private List<GKVStudentDetailsListResponse> gkvStudentDetailsListResponses;
}
