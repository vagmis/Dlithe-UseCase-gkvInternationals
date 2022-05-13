package com.dlithe.gkveducation.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@ToString
public class BaseResponse {
    private String message;
    private HttpStatus httpStatus;
    private int httpStatusCode;
    private Object response;
}
