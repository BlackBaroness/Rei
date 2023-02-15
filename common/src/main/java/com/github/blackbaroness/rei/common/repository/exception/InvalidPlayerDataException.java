package com.github.blackbaroness.rei.common.repository.exception;

public class InvalidPlayerDataException extends RepositoryException {

    public InvalidPlayerDataException() {
    }

    public InvalidPlayerDataException(String message) {
        super(message);
    }

    public InvalidPlayerDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPlayerDataException(Throwable cause) {
        super(cause);
    }

    public InvalidPlayerDataException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
