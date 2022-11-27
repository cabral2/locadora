import Controllers.MovieController;
import Controllers.UserController;
import Storages.MoviesStorage;
import Storages.UsersStorage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UsersStorage usersStorage = new UsersStorage();
        MoviesStorage moviesStorage = new MoviesStorage();

        UserController userController = new UserController(usersStorage);
        MovieController movieController = new MovieController(moviesStorage);

        View app = new View(userController, movieController);

        app.runApp();
    }

}