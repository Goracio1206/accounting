package net.accounting.dao.Exceptions;

/**
 * Created by Admin on 14-Apr-16.
 */
public class DaoSystemExceptions extends Exception {

    public DaoSystemExceptions(String message) {
        super(message);
    }

    public DaoSystemExceptions(String message, Throwable cause) {
        super(message, cause);
    }
}
