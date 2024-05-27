package com.example.components;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApiResponse {
    private String message;
    private Boolean status;
    private Object object;

    public ApiResponse(Boolean status, String message) {
        this.message = message;
        this.status = status;
    }

    public ApiResponse(Boolean status, String message, Object object) {
        this.message = message;
        this.status = status;
        this.object = object;
    }
}
