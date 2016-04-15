package net.accounting.dao.Exceptions;

/**
 * Created by vitalii.nedzelskyi on 15.04.2016.
 */
public class DaoBusinesException extends Exception {

    public DaoBusinesException(String message){
        super(message);
    }
    public DaoBusinesException(String message, Throwable cause){
        super(message, cause);
    }
}
