package Storages;

import Models.Movie;

import java.util.ArrayList;
import java.util.Date;

public class MoviesStorage {
    private ArrayList<Movie> movies;

    public Movie insert(){
        return new Movie("","",new Date(), "","");
    }
    public boolean delete(){
        return false;
    }
    public Movie update(){
        return new Movie("","",new Date(), "","");
    }
    public Movie query(){
        return new Movie("","",new Date(), "","");
    }

}
