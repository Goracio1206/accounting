package net.accounting.dao.Exceptions;

/**
 * Created by vitalii.nedzelskyi on 15.04.2016.
 */
public class DaoBusinessException extends Exception {

    public DaoBusinessException(String message){
        super(message);
    }
    public DaoBusinessException(String message, Throwable cause){
        super(message, cause);
    }
}
