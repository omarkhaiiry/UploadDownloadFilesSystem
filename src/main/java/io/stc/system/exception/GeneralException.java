package io.stc.system.exception;

import lombok.Getter;

@Getter
public class GeneralException extends Exception {

    public GeneralException() {
        super("General Exception");
    }

}
