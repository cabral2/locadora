package Controllers;

import Models.Movie;
import Storages.MoviesStorage;
import Utils.ViewUtils;

import java.util.ArrayList;

public class MovieController {
    private MoviesStorage moviesStorage;

    public MovieController(MoviesStorage moviesStorage) {
        this.moviesStorage = moviesStorage;
    }
    public ArrayList<Movie> getAllMovies(){
        return moviesStorage.getMovies();
    }
    public void rentMovie(Movie movie) {
        ArrayList<Movie> moviesRented = ViewUtils.loggedUser.getRentMovies();
        if(!moviesRented.contains(movie))
            moviesRented.add(movie);

        ViewUtils.loggedUser.setRentMovies(moviesRented);
    }

    public void favoriteMovie(Movie movie) {
        ArrayList<Movie> favoriteMovies = ViewUtils.loggedUser.getFavoriteMovies();
        if(!favoriteMovies.contains(movie))
            favoriteMovies.add(movie);

        ViewUtils.loggedUser.setFavoriteMovies(favoriteMovies);
    }

    public void unfavoriteMovie(Movie movie) {
        ArrayList<Movie> favoriteMovies = ViewUtils.loggedUser.getFavoriteMovies();
        if(favoriteMovies.contains(movie))
            favoriteMovies.remove(movie);

        ViewUtils.loggedUser.setFavoriteMovies(favoriteMovies);
    }

    public Movie findMovie(int id){ return moviesStorage.query(id);}


}
