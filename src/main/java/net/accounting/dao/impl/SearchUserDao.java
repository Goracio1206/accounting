package net.accounting.dao.impl;

import net.accounting.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.UserDao;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Admin on 14-Apr-16.
 */
public class SearchUserDao implements UserDao {
    private Map<Integer, User> user = new ConcurrentHashMap<Integer, User>();

    public SearchUserDao() {
        this.user.put(1, new User(1, "Vitalii", "Passw0rd"));
        this.user.put(2, new User(2, "Ivan", "Qawsed1234"));
        this.user.put(3, new User(3, "Petro", "Qwerty"));
    }

    public User selectByID(int id) throws NoSuchUserException, DaoSystemExceptions {
        if(!user.containsKey(id)){
            throw new NoSuchUserException("User was not found!!!");
        }
        return user.get(id);
    }
}
