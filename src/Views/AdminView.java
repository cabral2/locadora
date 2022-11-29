package Views;

import Controllers.MovieController;
import Controllers.UserController;
import Models.Movie;
import Utils.ViewUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class AdminView {
    private MovieController movieController;
    private UserController userController;

    public AdminView(MovieController movieController, UserController userController) {
        this.movieController = movieController;
        this.userController = userController;
    }

    public void showLoggedOptions(Scanner scanner) {
        int answer = -1;

        do {
            System.out.println("(1) Listar filmes");
            System.out.println("(2) Cadastrar filme");
            System.out.println("(3) Editar filme");
            System.out.println("(4) Remover filme");
            System.out.println("(5) Listar usuários");
            System.out.println("(6) Remover usuário");
            System.out.println("(7) Voltar");
            answer = ViewUtils.readOption(scanner);

            switch (answer){
                case 1:
                    this.listMovies();
                    break;
                case 2:
                    this.createMovie(scanner);
                    break;
                case 3:
                    this.editMovie(scanner);
                    break;
                case 4:
                    this.removeMovie(scanner);
                    break;
                case 5:
                    this.listUsers();
                    break;
                case 6:
                    this.removeUser(scanner);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Não há essa opção, digite outro valor.");
                    break;
            }
        } while(answer != 7);
    }

    private void listMovies(){
        ArrayList<Movie> movies = movieController.getAllMovies();

        for(Movie movie : movies){

        }
    }
    private void createMovie(Scanner scanner){}
    private void editMovie(Scanner scanner){}
    private void removeMovie(Scanner scanner){}
    private void listUsers(){}
    private void removeUser(Scanner scanner){}
}
