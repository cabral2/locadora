package Storages;

import Models.Address;
import Models.User;

import java.util.ArrayList;
import java.util.HashMap;

public class UsersStorage {
    private HashMap<String, User> users;

    public UsersStorage() {
        this.users = new HashMap<String, User>();
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
}
