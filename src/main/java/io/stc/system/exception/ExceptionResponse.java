package io.stc.system.exception;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ExceptionResponse {
    private String message;
}