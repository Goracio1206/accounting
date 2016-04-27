package net.accounting.dao.Exceptions;

/**
 * Created by vitalii.nedzelskyi on 25.04.2016.
 */
public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(String message) {
        super(message);
    }

    public UserAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }
}
