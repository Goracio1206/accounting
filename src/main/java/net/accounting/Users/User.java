package net.accounting.Users;

/**
 * Created by Admin on 14-Apr-16.
 */
public class User {
    private int id;
    private String firstName;
    private String password;

    public User(){}

    public User(int id, String name, String password){
        this.firstName = name;
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
