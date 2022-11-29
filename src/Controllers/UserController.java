package Controllers;

import Models.Address;
import Models.Movie;
import Models.User;
import Storages.UsersStorage;

import java.util.ArrayList;
import java.util.Date;

public class UserController {
    private UsersStorage usersStorage;

    public UserController(UsersStorage usersStorage) {
        this.usersStorage = usersStorage;
    }

    public boolean login(String email, String password) {
        User user = usersStorage.query(email);
        if(user == null)
            return false;
        return user.getPassword().equals(password);
    }
    public boolean logout(){
        return false;
    }

    public User editUser(){
        return new User("","","","", new Address("","","","",""));
    }

    public boolean createUser(User user){
        boolean result = usersStorage.insert(user);
        return result;
    }

    public Movie favoriteMovie(){
        return new Movie("","","2020", "","");
    }

    public Movie unfavoriteMovie(){
        return new Movie("","","2020", "","");
    }

    public ArrayList<Movie> listFavoriteMovies(){
        return new ArrayList<Movie>();
    }

    public Movie rentMovie(){
        return new Movie("","","2020", "","");
    }

    public Movie unrentMovie(){
        return new Movie("","","2020", "","");
    }

    public ArrayList<Movie> listRentMovies(){
        return new ArrayList<Movie>();
    }
    public ArrayList<User> getAllUsers() {
        return usersStorage.getUsers();
    }
    public UsersStorage getUsersStorage() {
        return usersStorage;
    }

}
