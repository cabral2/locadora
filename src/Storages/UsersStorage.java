package Storages;

import Models.Address;
import Models.User;

import java.util.ArrayList;

public class UsersStorage {
    private ArrayList<User> users;

    public User insert(){
        return new User("","","","", new Address("","","","",""));
    }
    public boolean delete(){
        return false;
    }
    public User update(){
        return new User("","","","", new Address("","","","",""));
    }
    public User query(){
        return new User("","","","", new Address("","","","",""));
    }

}
