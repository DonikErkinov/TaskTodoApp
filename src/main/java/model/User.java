package model;

import db.DataBase;

public class User {

    private final Integer id;
    private String fullName;
    private final String login;
    private String password;
    private Boolean isAdmin = false;

    public User(String fullName, String login, String password) {

        this.id = DataBase.userList.size()+1;

        this.fullName = fullName;
        this.login = login;
        this.password = password;
    }
    public User(String fullName, String login, String password, Boolean isAdmin) {

        this.id = DataBase.userList.size()+1;

        this.fullName = fullName;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }


}
