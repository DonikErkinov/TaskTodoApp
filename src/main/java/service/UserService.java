package service;

import container.ComponentContainer;
import controller.Main;
import db.DataBase;
import model.User;
import report.GenerateUserReport;

public class UserService {
    public static String login(String login, String password) {
        for (User user : DataBase.userList) {
            if(user.getLogin().equals(login)&&user.getPassword().equals(password)){
                Main.currentUser = user;
                return user.getFullName()+", welcome";
            }
        }
        return "There is not such user";
    }

    public static String register(String fullName, String login, String password) {
        for (User user : DataBase.userList) {
            if(user!=null&&user.getLogin().equals(login)&&user.getPassword().equals(password)){
                return user.getFullName()+" is exist";
            }
        }
        DataBase.userList.add(new User(fullName,login,password));
        GenerateUserReport.writeDataUserFile(DataBase.userList, ComponentContainer.USER_FILE);

        return "New user added";
    }
}
