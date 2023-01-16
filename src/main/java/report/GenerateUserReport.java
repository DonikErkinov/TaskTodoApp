package report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import container.ComponentContainer;
import db.DataBase;
import model.Todo;
import model.User;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;

public class GenerateUserReport {
   public  static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    public static void readTodoInfoFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ComponentContainer.TODO_FILE))) {

            Type type = new TypeToken<List<Todo>>() {
            }.getType();

            List<Todo> historyInfoList = gson.fromJson(reader, type);

            DataBase.toDoList.clear();
            DataBase.toDoList.addAll(historyInfoList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

    public static void writeDataToDoFile(List<Todo> toDoList, File historyFile) {
        try (PrintWriter printWriter = new PrintWriter(historyFile)) {
            printWriter.print(gson.toJson(toDoList));
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataUserFile(List<User> userList, File userFile) {
        try (PrintWriter printWriter = new PrintWriter(userFile)) {
            printWriter.print(gson.toJson(userList));
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void readUserInfoFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ComponentContainer.USER_FILE))) {

            Type type = new TypeToken<List<User>>() {
            }.getType();

            List<User> userList = gson.fromJson(reader, type);

            DataBase.userList.clear();
            DataBase.userList.addAll(userList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
