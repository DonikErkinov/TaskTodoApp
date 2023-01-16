package controller;

import service.TodoService;
import service.UserService;
import util.ScannerUtil;

public class UserController {
    public static void login() {
        System.out.println();
        System.out.print("Login: ");
        String login = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Password: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        String response = UserService.login(login, password);
        System.out.println(response);
    }

    public static void register() {
        System.out.println();
        System.out.print("Fullname: ");
        String fullName = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Login : ");
        String login = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Password: ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        String response = UserService.register(fullName, login, password);
        System.out.println(response);
    }

    public static void adminPage() {
        System.out.println();
        System.out.println("1. Show all todos");
        System.out.println("2. Show all users");
        System.out.println("3. Show own todos");
        System.out.println("4. Verify task that was done");
        System.out.println("5. Add new task");
        System.out.println("0. Exit");

        System.out.print("Choose operation : ");
        int operation = ScannerUtil.SCANNER_NUM.nextInt();

        switch (operation){

            case 1: TodoService.showAllTodos(); break;
            case 2: TodoService.showAllUsers(); break;
            case 3: TodoService.showOwnAllTodos(); break;
            case 4: TodoController.completeTodo(); break;
            case 5: TodoController.addNewTask(); break;
            case 0: UserController.logout(); break;
        }
    }

    public static void userPage() {
        System.out.println();
        System.out.println("1. Show  own all todos");
        System.out.println("2. Show own new todos");
        System.out.println("3. Verify task that was done");
        System.out.println("4. Add new task");
        System.out.println("0. Exit");

        System.out.print("Choose operation : ");
        int operation = ScannerUtil.SCANNER_NUM.nextInt();

        switch (operation){

            case 1: TodoService.showOwnAllTodos(); break;
            case 2: TodoService.showOwnNewTodos(); break;
            case 3: TodoController.completeTodo(); break;
            case 4: TodoController.addNewTask(); break;
            case 0: UserController.logout(); break;
        }
    }

    private static void logout() {
        Main.currentUser = null;
    }
}
