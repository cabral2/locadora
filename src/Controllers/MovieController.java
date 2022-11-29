package Controllers;

import Models.Movie;
import Storages.MoviesStorage;

import java.util.ArrayList;

public class MovieController {
    private MoviesStorage moviesStorage;

    public MovieController(MoviesStorage moviesStorage) {
        this.moviesStorage = moviesStorage;
    }
    public ArrayList<Movie> getAllMovies(){
        return moviesStorage.getMovies();
    }

}
