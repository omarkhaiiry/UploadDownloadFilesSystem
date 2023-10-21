package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserUnAuthorizedException extends CustomException {

    public UserUnAuthorizedException() {
        super("User not authorized", HttpStatus.UNAUTHORIZED);
    }

}
