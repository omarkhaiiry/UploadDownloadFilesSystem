package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PermissionGroupNotFoundException extends CustomException {

    public PermissionGroupNotFoundException() {
        super("Permission group not found", HttpStatus.NOT_FOUND);
    }

}
