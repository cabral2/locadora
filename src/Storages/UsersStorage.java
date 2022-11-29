package Storages;

import Models.Address;
import Models.Admin;
import Models.Movie;
import Models.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UsersStorage {
    private HashMap<String, User> users;

    public UsersStorage() {
        this.users = new HashMap<String, User>();
        this.initDefaultUsers();
    }

    public boolean insert(User user){
        users.put(user.getEmail(),user);
        return true;
    }
    public boolean delete(){
        return false;
    }
    public User update(){
        return new User("","","","", new Address("","","","",""));
    }
    public User query(String email){
        return users.get(email);
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    private void initDefaultUsers(){
        Address address = new Address("1", "1", "1", "1", "1");
        User admin = new Admin("admin", "admin@admin", "1", "admin", address, "admin" );

        this.insert(admin);
    }
}
