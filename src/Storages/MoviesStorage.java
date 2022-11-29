package Storages;

import Models.Address;
import Models.Admin;
import Models.Movie;
import Models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MoviesStorage {
    private HashMap<Integer,Movie> movies;
    private int movieIdsControl;

    public MoviesStorage() {
        movieIdsControl = 1;
        this.movies = new HashMap<Integer, Movie>();
        this.initDefaultMovies();
    }

    public ArrayList<Movie> getMovies() {
        return (ArrayList<Movie>) movies.values();
    }

    public boolean insert(Movie movie){
        movie.setId(movieIdsControl);
        movies.put(movieIdsControl,movie);
        movieIdsControl++;
        return true;
    }
    public boolean delete(){
        return false;
    }
    public Movie update(){
        return new Movie("","", new Date(), "","");
    }
    public Movie query(int id){ return movies.get(id); }

    private void initDefaultMovies() {
        Movie movieUm = new Movie("Oi", "Gaspar Noe", new Date(2018), "Tchau", "Comedia");
        Movie movieDois = new Movie("A Galinha dos Ovos de Ouro", "Gaspar Noe", new Date(2017), "Tchau", "Comedia");
        Movie movieTres = new Movie("Em busca do Templo de Ouro", "Gaspar Noe", new Date(2019), "O filme se passa em Sete Lagoas na casa de um psicopata americano.", "Ação");

        this.insert(movieUm);
        this.insert(movieDois);
        this.insert(movieTres);
    }

}
