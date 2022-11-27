package Models;

public class Admin extends User {
    private String role;

    public Admin(String name, String email, String phone, String password, Address address, String role) {
        super(name, email, phone, password, address);
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
