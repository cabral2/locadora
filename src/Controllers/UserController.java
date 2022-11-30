package Controllers;

import Models.CommonUser;
import Models.User;
import Storages.UsersStorage;

import java.util.ArrayList;

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

    public boolean createUser(CommonUser commonUser){
        boolean result = usersStorage.insert(commonUser);
        return result;
    }

    public User findUser(String email) {
        return usersStorage.query(email);
    }

    public ArrayList<User> getAllUsers() {
        return usersStorage.getUsers();
    }
    public UsersStorage getUsersStorage() {
        return usersStorage;
    }

}
