package io.stc.system.exception;

import lombok.Data;

@Data
public class Violation {

    private  String fieldName;

    private  String message;

	public Violation(String fieldName, String message) {
		super();
		this.fieldName = fieldName;
		this.message = message;
	}


    

}
