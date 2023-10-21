package io.stc.system.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FileNotFoundException extends CustomException {

    public FileNotFoundException() {
        super("File not found", HttpStatus.NOT_FOUND);
    }

}
