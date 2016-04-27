package net.accounting.Users;

/**
 * Created by Admin on 14-Apr-16.
 */
public class User {
    private static int id = 0;
    private String firstName;
    private String password;

    public User(){}

    public User(String name, String password){
        this.firstName = name;
        this.password = password;
        this.id = ++id;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString(){
        return "\n" + "ID: " + id + "\n"
                + "Name: " + firstName + "\n"
                + "Password: " + password + "\n";
    }
}
