package db;

import container.ComponentContainer;
import model.Todo;
import model.User;
import report.GenerateUserReport;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public interface DataBase {


    List<User> userList = new ArrayList<>();
    List<Todo> toDoList = new ArrayList<>();

    static void loadData() {
        userList.add(new User("Davronov Otabek","Otabek","7777",true));
//        userList.add(new User("Samandarov Oqil","Oqil","1111"));
//        toDoList.add(new Todo("uyga vazifa","1"));
//        toDoList.add(new Todo("tekshirish","2"));
        //GenerateUserReport.writeDataUserFile(userList,ComponentContainer.USER_FILE);
//        GenerateUserReport.writeDataToDoFile(toDoList, ComponentContainer.TODO_FILE);
        GenerateUserReport.readTodoInfoFile();
        GenerateUserReport.readUserInfoFile();

    }

}
