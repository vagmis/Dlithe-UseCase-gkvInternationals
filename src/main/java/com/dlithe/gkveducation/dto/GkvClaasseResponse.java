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
public class GkvClaasseResponse {

    private List<GkvClassListResponse> gkvClassListResponses;
}
