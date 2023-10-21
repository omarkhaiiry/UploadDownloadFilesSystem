package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserHasNoAccessException extends CustomException {

    public UserHasNoAccessException() {
        super("User has no access to this group",HttpStatus.UNAUTHORIZED);
    }

}
