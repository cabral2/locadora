import Models.Admin;
import Models.User;
import Utils.UserType;
import Utils.ViewUtils;
import Views.AdminView;
import Views.UserView;
import Views.MovieView;
import Models.CommonUser;

import java.util.Scanner;

public class ViewManager {
    private UserView userView;
    private MovieView movieView;
    private AdminView adminView;

    public ViewManager(UserView userView, MovieView movieView, AdminView adminView) {
        this.userView = userView;
        this.movieView = movieView;
        this.adminView = adminView;
    }

    public void runApp(){
        int answer = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindos à Locadora da Pipoca!");

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("(1) Login Usuario");
            System.out.println("(2) Cadastro");
            System.out.println("(9) Sair");
            answer = ViewUtils.readOption(scanner);

            switch (answer){
                case 1:
                    this.verifyLogin(scanner);
                    break;

                case 2:
                    this.userView.doRegister(scanner);
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
        User loggedUser = this.userView.doLogin(scanner);

        if (loggedUser == null) {
            return;
        }

        setLoggedUser(loggedUser);
        if(loggedUser.getRole() == UserType.ADMIN)
            this.adminView.showLoggedOptions(scanner);
        else
            this.movieView.showLoggedOptions(scanner);
    }

    private void setLoggedUser(User loggedUser) {
        ViewUtils.loggedUser = loggedUser;
    }

}
