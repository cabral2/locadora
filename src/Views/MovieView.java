package Views;

import Controllers.MovieController;
import Controllers.UserController;
import Models.Movie;
import Models.User;
import Utils.ViewUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;
    private UserController userController;

    public MovieView(MovieController movieController, UserController userController) {
        this.movieController = movieController;
        this.userController = userController;
    }

    public void showLoggedOptions(Scanner scanner) {
        int answer = -1;

        do {
            ViewUtils.clearScreen();
            System.out.println("(1) Listar todos filmes");
            System.out.println("(2) Listar filmes favoritos");
            System.out.println("(3) Listar filmes alugados");
            System.out.println("(4) Voltar");
            answer = ViewUtils.readOption(scanner);

            switch (answer){
                case 1:
                    this.showAllMovies(scanner);
                    break;

                case 2:
                    this.showFavoriteMovies(scanner);
                    break;

                case 3:
                    this.showRentedMovies(scanner);
                    break;

                default:
                    System.out.println("Não há essa opção, digite outro valor.");
                    break;
            }
        } while(answer != 4);
    }

    public void showAllMovies(Scanner scanner) {
        ArrayList<Movie> movies = movieController.getAllMovies();
        int answer = -1;
        int currentId = 0;

        do {
            for (Movie movie : movies) {
                currentId = movie.getId();
                System.out.println("(" + currentId + ")" + " - " + movie.getName());
            }

            System.out.println("(" + (currentId + 1) + ")" + " Voltar");
            answer = ViewUtils.readOption(scanner);

            if (answer != currentId + 1) {
                Movie selectedMovie = movieController.findMovie(answer);
                showMovieInformation(selectedMovie);
                showMovieOptions(scanner, selectedMovie);
            }

        } while(answer != (currentId + 1));

    }

    private void showMovieInformation(Movie movie) {
        ViewUtils.clearScreen();
        System.out.println("Voce escolheu o filme: " + movie.getName());
        System.out.println();
        System.out.println("Descrição: " + movie.getReleaseYear());
        System.out.println("Ano de lançamento: " + movie.getReleaseYear());
        System.out.println("Diretor: " + movie.getDirector());
        System.out.println("Categoria: " + movie.getCategory());
        System.out.println();
    }

    private void showMovieOptions(Scanner scanner, Movie movie) {
        int answer = -1;

        do {
            System.out.println("O que voce deseja realizar com esse filme?");
            System.out.println();
            System.out.println("(1) Favoritar filme");
            System.out.println("(2) Alugar filme");
            System.out.println("(3) Voltar");
            answer = ViewUtils.readOption(scanner);

            switch (answer){
                case 1:
                    this.favoriteMovie(movie);
                    break;

                case 2:
                    this.rentMovie(movie);
                    break;

                default:
                    System.out.println("Não há essa opção, digite outro valor.");
                    break;
            }
        } while(answer != 3);
    }
    public void showFavoriteMovies(Scanner scanner){

    }
    public void showRentedMovies(Scanner scanner){
        ArrayList<Movie> moviesRented = ViewUtils.loggedUser.getRentMovies();

        for (Movie movie : moviesRented) {
            System.out.println("(" + movie.getId() + ")" + " - " + movie.getName());
        }
    }

    private void rentMovie(Movie movie) {
        ArrayList<Movie> moviesRented = ViewUtils.loggedUser.getRentMovies();
        moviesRented.add(movie);

        ViewUtils.loggedUser.setRentMovies(moviesRented);
    }

    private void favoriteMovie(Movie movie) {
        ArrayList<Movie> favoriteMovies = ViewUtils.loggedUser.getFavoriteMovies();
        favoriteMovies.add(movie);

        ViewUtils.loggedUser.setFavoriteMovies(favoriteMovies);
    }
}
