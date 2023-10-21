package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class GeneralException extends Exception {

    public GeneralException() {
        super("General Exception");
    }

}
