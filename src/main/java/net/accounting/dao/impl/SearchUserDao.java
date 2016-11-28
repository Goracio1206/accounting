package net.accounting.dao.impl;

import net.accounting.Entity.Users.User;
import net.accounting.dao.Exceptions.DaoSystemExceptions;
import net.accounting.dao.Exceptions.NoSuchUserException;
import net.accounting.dao.Exceptions.UserAlreadyExistException;
import net.accounting.dao.UserDao;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SearchUserDao implements UserDao {
    private Map<Integer, User> user = new ConcurrentHashMap<Integer, User>();

    public SearchUserDao() {
        this.user.put(1, new User("vitalii.nedzelskyi@test.com", "Passw0rd"));
        this.user.put(2, new User("Ivan@test.com", "Qawsed1234"));
        this.user.put(3, new User("Petro@test.com", "Qwerty"));
    }

    @Override
    public User selectByID(int id) throws NoSuchUserException, DaoSystemExceptions {
        if(!user.containsKey(id)){
            throw new NoSuchUserException("User was not found!!!");
        }
        return user.get(id);
    }

    @Override
    public User selectUserByID(int id) throws  NoSuchUserException, DaoSystemExceptions {
        User aUser1 = null;
        for (Map.Entry<Integer, User> entry : user.entrySet()){
            if (entry.getKey() == id) {
                aUser1 = entry.getValue();
            }
        }
        return aUser1;
    }

    @Override
    public List<User> selectAllUsers() throws NoSuchUserException, DaoSystemExceptions {
        List<User> allUsers = new ArrayList<>(user.values());
        return allUsers;
    }

    @Override
    public User selectUser(String login, String password) throws NoSuchUserException, DaoSystemExceptions {
        User aUser = null;
        for (Map.Entry<Integer, User> entry : user.entrySet()){
            if (entry.getValue().getFirstName().toLowerCase().equals(login.toLowerCase()) && entry.getValue().getPassword().equals(password)){
                aUser = entry.getValue();
                aUser.setID(entry.getKey());
            }
        }
        return aUser;
    }

    @Override
    public void createNewUser(int id, String firstName, String password) throws DaoSystemExceptions, UserAlreadyExistException {
        this.user.put(id, new User(firstName, password));
    }
}
