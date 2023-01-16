package service;

import container.ComponentContainer;
import controller.Main;
import db.DataBase;
import model.Todo;
import model.User;
import report.GenerateUserReport;
import util.ScannerUtil;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    public static int endIndex = 0;

    public static void showOwnAllTodos() {
        System.out.println();
        List<Todo> userToDo = new ArrayList<>();

        boolean hasTodos = false;
        for (Todo todo : DataBase.toDoList) {
            if (todo.getUser().equals(String.valueOf(Main.currentUser.getId()))) {
                hasTodos = true;
//                System.out.println(todo);
                userToDo.add(todo);
            }
        }
        if (!hasTodos) {
            System.out.println("There is not any tasks");
        }
        int startingIndex = 0;
        generate10Time(userToDo, startingIndex);


    }

    private static void generate10Time(List<Todo> userToDo, int startingIndex) {
        int count = 0;
        if (userToDo.size() <= 10) {
            for (Todo todo : userToDo) {
                System.out.println(todo);
            }
        } else {
            for (int i = startingIndex; i < userToDo.size(); i++) {
                count++;
                System.out.println((i+1) + ")" + userToDo.get(i));
                endIndex = i;
                if (count == 10) {
                    if (endIndex - 9 == 0) {
                        System.out.println("\n1.Next");
                        System.out.println("2.Exit");
                        System.out.println("Choose operation : ");
                        int option = ScannerUtil.SCANNER_NUM.nextInt();
                        switch (option) {
                            case 1:
                                generate10Time(userToDo, endIndex + 1);
                                count = 0;
                                break;
                            case 2:
                                break;

                            default:
                        }
                    } else if (startingIndex + 9 == endIndex) {
                        System.out.println("\n1.Next");
                        System.out.println("2.Previous");
                        System.out.println("3.Exit");
                        System.out.println("Choose operation : ");
                        int option = ScannerUtil.SCANNER_NUM.nextInt();
                        switch (option) {
                            case 1:
                                generate10Time(userToDo, endIndex + 1);
                                count = 0;
                                break;
                            case 2:
                                generate10Time(userToDo, endIndex - 19);
                                count = 0;
                                break;
                            case 3:
                                break;
                        }
                    }
                    break;
                }
                else if(endIndex==userToDo.size()-1){
                    System.out.println("\n1.Previous");
                    System.out.println("2.Exit");
                    System.out.print("Choose operation : ");
                    int option = ScannerUtil.SCANNER_NUM.nextInt();
                    switch (option) {
                        case 1:
                            generate10Time(userToDo, endIndex - 9-count);
                            count = 0;
                            break;
                        case 3:
                            break;
                    }
                }
            }
        }
    }

    public static boolean showOwnNewTodos() {
        System.out.println();

        boolean hasNewTodos = false;
        for (Todo todo : DataBase.toDoList) {
            if (todo.getUser().equals(String.valueOf(Main.currentUser.getId())) && !todo.getCompleted()) {
                hasNewTodos = true;
                System.out.println(todo);
            }
        }
        if (!hasNewTodos) {

            System.out.println("You do not have new tasks");
        }
        return hasNewTodos;
    }

    public static String completeToDo(Integer id) {
        System.out.println();
        for (Todo todo : DataBase.toDoList) {
            if (todo != null && todo.getId().equals(id) && todo.getUser().equals(String.valueOf(Main.currentUser.getId()))) {
                if (todo.getCompleted()) {
                    return "Task was already completed";
                } else {
                    todo.setCompleted(true);
                    GenerateUserReport.writeDataToDoFile(DataBase.toDoList, ComponentContainer.TODO_FILE);
                    return "Task successfully done";
                }
            }
        }
        return "There is not such id number task";

    }

    public static void showAllTodos() {
        System.out.println();
        if (DataBase.toDoList.isEmpty()) {
            System.out.println("There is not tasks");
            ;
        }
        int startingIndex = 0;
        generate10Time(DataBase.toDoList, startingIndex);
//        for (Todo todo : DataBase.toDoList) {
//            System.out.println(todo);
//        }
    }

    public static void showAllUsers() {
        System.out.println();
        if (DataBase.userList.isEmpty()) {
            System.out.println("There is not users");
            ;
        }
        for (User user : DataBase.userList) {
            System.out.println(user);
        }
    }

    public static String addTodo(String title, User currentUser) {

        Todo todo = new Todo(title, String.valueOf(currentUser.getId()));
        DataBase.toDoList.add(todo);
        GenerateUserReport.writeDataToDoFile(DataBase.toDoList, ComponentContainer.TODO_FILE);
        return "Task successfully installed";

    }
}
