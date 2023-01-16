package controller;

import model.User;
import util.ScannerUtil;

import static db.DataBase.loadData;

public class Main {
    public static User currentUser = null;
    public static void mainMenu() {
        loadData();
        while(true){
            if(currentUser == null){
                System.out.println();
                System.out.println("1. Enter");
                System.out.println("2. Register");
                System.out.println("0. Exit");

                System.out.print("Choose operation : ");
                int operation = ScannerUtil.SCANNER_NUM.nextInt();

                switch (operation){
                    case 1: {
                        UserController.login();
                    }break;
                    case 2: {
                        UserController.register();
                    }break;
                    default: return;
                }
            }
            else{
                if(currentUser.getAdmin()){
                    UserController.adminPage();
                }else{
                    UserController.userPage();
                }
            }
        }
    }
}
