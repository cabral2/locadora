import Controllers.AdminController;
import Controllers.MovieController;
import Controllers.UserController;
import Storages.MoviesStorage;
import Storages.UsersStorage;
import Views.AdminView;
import Views.MovieView;
import Views.UserView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersStorage usersStorage = new UsersStorage();
        MoviesStorage moviesStorage = new MoviesStorage();

        UserController userController = new UserController(usersStorage);
        MovieController movieController = new MovieController(moviesStorage);
        AdminController adminController = new AdminController(usersStorage, moviesStorage);

        UserView userView = new UserView(userController);
        AdminView adminView = new AdminView(adminController);
        MovieView movieView = new MovieView(movieController, userController);

        View app = new View(userView, movieView, adminView);

        app.runApp();
    }

}