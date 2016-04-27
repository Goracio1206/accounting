package net.accounting.dao;

import net.accounting.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.Exceptions.UserAlreadyExistException;

/**
 * Created by Admin on 14-Apr-16.
 */
public interface UserDao {
    User selectByID(int id) throws NoSuchUserException, DaoSystemExceptions;

    void createNewUser(int id, String firstName, String password) throws DaoSystemExceptions, UserAlreadyExistException;
}
