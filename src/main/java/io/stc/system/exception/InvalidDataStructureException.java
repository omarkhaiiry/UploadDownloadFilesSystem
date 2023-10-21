package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvalidDataStructureException extends CustomException {

    public InvalidDataStructureException() {
        super("Invalid Data Structure",HttpStatus.BAD_REQUEST);
    }

}
