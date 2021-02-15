package com.epam.engx.cleancode.naming.task5.thirdpartyjar;

public class MissingConfigFileException extends RuntimeException {
	final String message;
    public MissingConfigFileException(String message) {
        super(message);
        this.message = message;
    }

    public MissingConfigFileException(String message, Exception exceptionName) {
        super(message,exceptionName);
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
    
    
}
