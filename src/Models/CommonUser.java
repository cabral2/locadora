package Models;

import Utils.UserType;

import java.util.ArrayList;

public class CommonUser extends User{
    public CommonUser(String name, String email, String phone, String password, Address address, UserType role) {
        super(name, email, phone, password, address, role);
    }
}




