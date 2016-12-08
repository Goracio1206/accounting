package net.accounting.Entity;

import java.util.Calendar;

/**
 * Created by Admin on 14-Apr-16.
 */
public class User {
    private int ID;
    private String fName;
    private String lName;
    private String userName;
    private String password;
    private String gender;
    private String eMail;
    private Calendar registDate;
    private Address address;

    public User(){}

    public User(String fName, String lName, String userName, String password, String gender,String eMail, Calendar registDate, String Country, String City, String Street){
        this(fName, password, userName);

    }

    public User(String fName, String password, String userName){
        this.fName = fName;
        this.password = password;
        this.userName = userName;
    }


    public int getId() {
        return ID;
    }
    public void setID(int id) {
        this.ID = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return "\n" + "ID: " + ID + "\n"
                + "Name: " + fName + "\n"
                + "Password: " + password + "\n";
    }
}
