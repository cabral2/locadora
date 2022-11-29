package Views;

import Controllers.AdminController;
import Models.Movie;
import Models.User;
import Utils.ViewUtils;

import java.util.ArrayList;
import java.util.Scanner;

import static Utils.ViewUtils.readOption;

public class AdminView {
    private AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
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
            answer = readOption(scanner);

            switch (answer){
                case 1:
                    this.listMovies(scanner);
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
                    this.listUsers(scanner);
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

    private void listMovies(Scanner scanner){
        this.displayMovies();
        System.out.println("(1) Voltar");
        int answer = ViewUtils.readOption(scanner);
    }
    private void createMovie(Scanner scanner){
        boolean result;

        String name;
        String director;
        String releaseYear;
        String description;
        String category;

        do {
            ViewUtils.clearScreen();

            System.out.println("Digite os dados abaixo!");
            System.out.println("Nome:");
            name = scanner.nextLine();
            System.out.println("Diretor:");
            director = scanner.nextLine();
            System.out.println("Ano:");
            releaseYear = scanner.nextLine();
            System.out.println("Descrição:");
            description = scanner.nextLine();
            System.out.println("Categoria:");
            category = scanner.nextLine();

            Movie movie = new Movie(name, director, releaseYear, description, category);

            result = adminController.createMovie(movie);

            ViewUtils.printResultMessage(result);

        } while (!result);
    }
    private void editMovie(Scanner scanner){
        System.out.println("Selecione qual filme deseja editar: ");
        this.displayMovies();
        int id = ViewUtils.readOption(scanner);

        System.out.println("Digite as novas informações(Caso não queira editar uma propriedade basta deixar em branco): ");
        String name;
        String director;
        String releaseYear;
        String description;
        String category;


        ViewUtils.clearScreen();

        System.out.println("Digite os dados abaixo!");
        System.out.println("Nome:");
        name = scanner.nextLine();
        System.out.println("Diretor:");
        director = scanner.nextLine();
        System.out.println("Ano:");
        releaseYear = scanner.nextLine();
        System.out.println("Descrição:");
        description = scanner.nextLine();
        System.out.println("Categoria:");
        category = scanner.nextLine();

        Movie movie = new Movie(name, director, releaseYear, description, category);

        adminController.editMovie(id, movie);
        ViewUtils.printResultMessage(true);

    }
    private void removeMovie(Scanner scanner){
        System.out.println("Selecione qual filme deseja excluir:");
        this.displayMovies();
        int id = ViewUtils.readOption(scanner);

        boolean result = adminController.deleteMovie(id);
        ViewUtils.printResultMessage(result);

    }
    private void listUsers(Scanner scanner){
        this.displayUsers();
        System.out.println("(1) Voltar");
        int answer = ViewUtils.readOption(scanner);
    }
    private void removeUser(Scanner scanner){
        System.out.println("Digite o email do usuario a ser excluido:");
        this.displayUsers();
        String email = scanner.nextLine();

        boolean result = adminController.deleteUser(email);
        ViewUtils.printResultMessage(result);
    }

    private void displayUsers(){
        ArrayList<User> users = adminController.getAllUsers();
        for(User user : users){
            System.out.println("("+user.getEmail()+") "+user.getName());
        }
        System.out.println();
    }

    private void displayMovies(){
        ArrayList<Movie> movies = adminController.getAllMovies();
        for(Movie movie : movies){
            System.out.println("("+movie.getId()+") "+movie.getName());
        }
        System.out.println();
    }
}
