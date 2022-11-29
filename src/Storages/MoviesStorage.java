package Storages;

import Models.Address;
import Models.Admin;
import Models.Movie;
import Models.User;

import java.util.ArrayList;
import java.util.Date;

public class MoviesStorage {
    private ArrayList<Movie> movies;
    private int movieIdsControl;

    public MoviesStorage() {
        movieIdsControl = 1;
        this.movies = new ArrayList<Movie>();
        this.initDefaultMovies();
    }

    public boolean insert(Movie movie){
        movie.setId(movieIdsControl);
        movieIdsControl++;
        movies.add(movie);
        return true;
    }
    public boolean delete(){
        return false;
    }
    public Movie update(){
        return new Movie("","", new Date(), "","");
    }
    public Movie query(){
        return new Movie("","", new Date(), "","");
    }

    private void initDefaultMovies() {
        Movie movieUm = new Movie("Oi", "Gaspar Noe", new Date(2018), "Tchau", "Comedia");
        Movie movieDois = new Movie("A Galinha dos Ovos de Ouro", "Gaspar Noe", new Date(2017), "Tchau", "Comedia");
        Movie movieTres = new Movie("Em busca do Templo de Ouro", "Gaspar Noe", new Date(2019), "O filme se passa em Sete Lagoas na casa de um psicopata americano.", "Ação");

        this.insert(movieUm);
        this.insert(movieDois);
        this.insert(movieTres);
    }

}
