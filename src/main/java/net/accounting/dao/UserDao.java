package net.accounting.dao;

import net.accounting.Users.User;
import net.accounting.dao.Exceptions.NoSuchUserException;

/**
 * Created by Admin on 14-Apr-16.
 */
public interface UserDao {
    User selectByID(int id) throws NoSuchUserException;
}
