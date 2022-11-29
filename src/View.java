import Controllers.MovieController;
import Controllers.UserController;
import Storages.MoviesStorage;
import Storages.UsersStorage;
import Utils.ViewUtils;
import Views.UserView;
import Views.MovieView;
import Models.Address;
import Models.User;

import java.util.Scanner;

public class View {
    private UserController userController;
    private MovieController movieController;

    private UserView userView;
    private MovieView movieView;

    public View() {
        UsersStorage usersStorage = new UsersStorage();
        MoviesStorage moviesStorage = new MoviesStorage();

        UserController userController = new UserController(usersStorage);
        MovieController movieController = new MovieController(moviesStorage);

        userView = new UserView(userController);
        movieView = new MovieView(movieController, userController);
    }
    public void runApp(){
        int answer = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindos à Locadora do Davi!");

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("(1) Login Usuario");
            System.out.println("(2) Cadastro");
            System.out.println("(3) Login Admin");
            System.out.println("(9) Sair");
            answer = ViewUtils.readOption(scanner);

            switch (answer){
                case 1:
                    this.verifyLogin(scanner);
                    break;

                case 2:
                    userView.doRegister(scanner);
                    break;

                case 3:
                    this.verifyAdminLogin(scanner);
                    break;

                case 9:
                    break;

                default:
                    System.out.println("Não há essa opção, digite outro valor.");
                    break;
            }

        } while (answer != 9);
    }

    public void verifyLogin(Scanner scanner) {
        User loggedUser = userView.doLogin(scanner);

        if (loggedUser != null) {
            setLoggedUser(loggedUser);
            movieView.showLoggedOptions(scanner);
        } else
            System.out.println("Erro ao logar, tente novamente!");
    }

    public void verifyAdminLogin(Scanner scanner) {
        User loggedUser = userView.doLogin(scanner);

        if (loggedUser != null) {
            setLoggedUser(loggedUser);
            movieView.showLoggedOptions(scanner);
        } else
            System.out.println("Erro ao logar, tente novamente!");
    }

    private void setLoggedUser(User loggedUser) {
        ViewUtils.loggedUser = loggedUser;
    }

}
