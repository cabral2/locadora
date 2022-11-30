package Models;

import Utils.UserType;

public class Admin extends User {
    public Admin(String name, String email, String phone, String password, Address address, UserType role) {
        super(name, email, phone, password, address, role);
    }
}
