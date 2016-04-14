package net.accounting.dao.Exceptions;

/**
 * Created by Admin on 14-Apr-16.
 */
public class NoSuchUserException extends Throwable {
    public NoSuchUserException(String message){
        super(message);
    }
    public NoSuchUserException(String message, Throwable cause){
        super(message, cause);
    }
}
