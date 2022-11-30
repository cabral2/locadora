package Storages;

import Models.Address;
import Models.Admin;
import Models.CommonUser;
import Models.User;
import Utils.UserType;

import java.util.ArrayList;
import java.util.HashMap;

public class UsersStorage {
    private HashMap<String, User> users;

    public UsersStorage() {
        this.users = new HashMap<String, User>();
        this.initDefaultUsers();
    }

    public boolean insert(User user){
        users.put(user.getEmail(), user);
        return true;
    }
    public boolean delete(String email){
        User user = users.remove(email);
        return user != null;
    }
    public User query(String email){
        return users.get(email);
    }

    public ArrayList<User> getUsers() {
        return new ArrayList<User>(users.values());
    }

    private void initDefaultUsers(){
        Address address = new Address("1", "1", "1", "1", "1");
        Admin admin = new Admin("admin", "admin@admin", "1", "admin", address, UserType.ADMIN);
        CommonUser common = new CommonUser("user", "user@user", "1", "user", address, UserType.COMMON);

        this.insert(admin);
        this.insert(common);
    }
}
