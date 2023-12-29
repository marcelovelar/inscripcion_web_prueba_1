package com.inscripcionweb.exception;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class LockedExceptionResponse {

    private String message;

    public LockedExceptionResponse(String message) {
        this.message = message;
    }

}
