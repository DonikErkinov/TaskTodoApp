package controller;

import service.TodoService;
import util.ScannerUtil;

public class TodoController {
    public static void completeTodo() {
        boolean hasNewTodos = TodoService.showOwnNewTodos();

        if(!hasNewTodos) return;

        System.out.print("Enter id number of task: ");
        Integer id= ScannerUtil.SCANNER_NUM.nextInt();
        System.out.println(TodoService.completeToDo(id));
    }

    public static void addNewTask() {
        System.out.print("Enter task name: ");
        String title = ScannerUtil.SCANNER_STR.nextLine();

        String response = TodoService.addTodo(title, Main.currentUser);
        System.out.println(response);
    }
}
