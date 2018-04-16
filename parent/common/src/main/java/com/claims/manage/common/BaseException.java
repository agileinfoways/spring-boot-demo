package com.claims.manage.common;




public class BaseException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 981549330322374115L;

    private final String message;
    private final Throwable cause;

    public BaseException() {
        super();
        this.message = null;
        this.cause = null;
    }

    /**
     * @param message
     * @param cause
     */
    public BaseException(String message, Throwable cause) {
        super();
        this.message = message;
        this.cause = cause;
    }

    /**
     * @return the message
     */
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }
}