package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserNotFoundException extends CustomException {

    public UserNotFoundException() {
        super("User not found",HttpStatus.NOT_FOUND);
    }

}
