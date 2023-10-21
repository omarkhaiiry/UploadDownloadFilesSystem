package io.stc.system.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice()
@NoArgsConstructor
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<Object> handleCustomExceptions(final CustomException ex) {
        ex.printStackTrace();
        return ResponseEntity.status(ex.getHttpStatus()).body(ExceptionResponse.builder().message(ex.getMessage()).build());
    }
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleExceptions(final Exception ex) {
        ex.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ExceptionResponse.builder().message(ex.getMessage()).build());
    }


}
