package net.accounting.dao.Exceptions;

/**
 * Created by vitalii.nedzelskyi on 15.04.2016.
 */
public class DaoException extends Exception{

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause){
        super(message, cause);
    }
}
