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

    public void showAllMovies(Scanner scanner){
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

            Movie selectedMovie = movieController.findMovie(answer);

            System.out.println(selectedMovie);
        } while(answer != (currentId + 1));

    }

    private void printMovieInformation(Movie movie){

    }
    public void showFavoriteMovies(Scanner scanner){

    }
    public void showRentedMovies(Scanner scanner){

    }
}
