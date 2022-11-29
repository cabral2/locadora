package Controllers;


import Models.Movie;
import Models.User;
import Storages.MoviesStorage;
import Storages.UsersStorage;

import java.util.ArrayList;
import java.util.Date;

public class AdminController extends UserController{ ;
    private MoviesStorage moviesStorage;

    public AdminController(UsersStorage usersStorage, MoviesStorage moviesStorage) {
        super(usersStorage);
        this.moviesStorage = moviesStorage;
    }

    public boolean deleteUser(String email){
        return super.getUsersStorage().delete(email);
    }

    public boolean createMovie(Movie movie){
        return moviesStorage.insert(movie);
    }

    public Movie editMovie(int id, Movie movie){
        return moviesStorage.update(id, movie);
    }

    public boolean deleteMovie(int id){
        return moviesStorage.delete(id);
    }

    public ArrayList<Movie> getAllMovies(){
        return moviesStorage.getMovies();
    }

}
