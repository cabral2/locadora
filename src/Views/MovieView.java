package Views;

import Controllers.MovieController;
import Models.Movie;
import Utils.ViewUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieView {

    private MovieController movieController;

    public MovieView(MovieController movieController) {
        this.movieController = movieController;
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

        boolean isFavorite = ViewUtils.loggedUser.getFavoriteMovies().contains(movie);

        System.out.println("O que voce deseja realizar com esse filme?");
        System.out.println();
        if (!isFavorite)
            System.out.println("(1) Favoritar filme");
        else
            System.out.println("(1) Desfavoritar filme");
        System.out.println("(2) Alugar filme");
        System.out.println("(3) Voltar");
        answer = ViewUtils.readOption(scanner);
        switch (answer){
            case 1:
                if (!isFavorite)
                    this.movieController.favoriteMovie(movie);
                else
                    this.movieController.unfavoriteMovie(movie);
                break;
            case 2:
                this.movieController.rentMovie(movie);
                break;

            case 3:
                break;
            default:
                System.out.println("Não há essa opção, digite outro valor.");
                break;
            }
    }
    public void showFavoriteMovies(Scanner scanner){
        ArrayList<Movie> favoriteMovies = ViewUtils.loggedUser.getFavoriteMovies();

        for (Movie movie : favoriteMovies) {
            System.out.println("(" + movie.getId() + ")" + " - " + movie.getName());
        }

        System.out.println("\n(1) Voltar");
        int answer = ViewUtils.readOption(scanner);
    }
    public void showRentedMovies(Scanner scanner){
        ArrayList<Movie> moviesRented = ViewUtils.loggedUser.getRentMovies();

        for (Movie movie : moviesRented) {
            System.out.println("(" + movie.getId() + ")" + " - " + movie.getName());
        }

        System.out.println("\n(1) Voltar");
        int answer = ViewUtils.readOption(scanner);
    }
}
