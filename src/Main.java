import Controllers.UserController;
import Storages.UsersStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersStorage usersStorage = new UsersStorage();
        UserController userController = new UserController(usersStorage);
        View app = new View(userController);
        app.runApp();
    }

}