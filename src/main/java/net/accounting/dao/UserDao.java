package net.accounting.dao;

import net.accounting.Entity.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.Exceptions.UserAlreadyExistException;

import java.util.List;

/**
 * Created by Admin on 14-Apr-16.
 */
public interface UserDao {
    User selectByID(int id) throws NoSuchUserException, DaoSystemExceptions;

    List<User> selectAllUsers() throws NoSuchUserException, DaoSystemExceptions;

    User selectUser(String login, String Password) throws NoSuchUserException, DaoSystemExceptions;

    void createNewUser(int id, String firstName, String password) throws DaoSystemExceptions, UserAlreadyExistException;
}
