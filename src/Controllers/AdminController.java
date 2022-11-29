package Controllers;


import Models.Movie;
import Models.User;
import Storages.MoviesStorage;

import java.util.ArrayList;
import java.util.Date;

public class AdminController {
    private MoviesStorage moviesStorage;

    public AdminController(MoviesStorage moviesStorage) {
        this.moviesStorage = moviesStorage;
    }

    public boolean deleteUser(){
        return false;
    }

    public Movie createMovie(){
        return new Movie(0,"","",new Date(), "","");
    }

    public Movie editMovie(){
        return new Movie(0,"","",new Date(), "","");
    }

    public boolean deleteMovie(){
        return false;
    }

    public ArrayList<User> listUsers(){
        return new ArrayList<User>();
    }
}
