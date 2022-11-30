package Models;

import Utils.UserType;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String phone;
    private String password;
    private ArrayList<Movie> favoriteMovies;
    private ArrayList<Movie> rentMovies;
    private Address address;
    private UserType role;

    public User(String name, String email, String phone, String password, Address address, UserType role) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.favoriteMovies = new ArrayList<Movie>();
        this.rentMovies = new ArrayList<Movie>();
        this.address = address;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(ArrayList<Movie> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public ArrayList<Movie> getRentMovies() {
        return rentMovies;
    }

    public void setRentMovies(ArrayList<Movie> rentMovies) {
        this.rentMovies = rentMovies;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UserType getRole() {
        return role;
    }

    public void setRole(UserType role) {
        this.role = role;
    }
}
