package Views;

import Controllers.UserController;
import Models.Address;
import Models.User;
import Utils.ViewUtils;
import java.util.Scanner;

public class UserView {
    public UserView(UserController userController) {
        this.userController = userController;
    }

    private UserController userController;

    public void doRegister(Scanner scanner){
        boolean result;

        String name;
        String email;
        String phone;
        String street;
        String city;
        String state;
        String postalCode;
        String country;
        String password;

        do {
            ViewUtils.clearScreen();

            System.out.println("Comece digitandos os seus dados abaixo!\n");
            System.out.println("Nome:");
            name = scanner.nextLine();
            System.out.println("Email:");
            email = scanner.nextLine();
            System.out.println("Telefone(Apenas números):");
            phone = scanner.nextLine();
            System.out.println("Rua:");
            street = scanner.nextLine();
            System.out.println("Cidade:");
            city = scanner.nextLine();
            System.out.println("Estado:");
            state = scanner.nextLine();
            System.out.println("CEP:");
            postalCode = scanner.nextLine();
            System.out.println("País:");
            country = scanner.nextLine();
            System.out.println("Agora, defina sua senha:");
            password = scanner.nextLine();

            Address address = new Address(street, city, state, postalCode, country);
            User user = new User(name, email, phone, password, address);

            result = userController.createUser(user);

            ViewUtils.printResultMessage(result);

        } while (!result);
    }

    public boolean doLogin(Scanner scanner){
        boolean result;
        String email;
        String password;

        ViewUtils.clearScreen();

        System.out.println("Digite seu email:");
        email = scanner.nextLine();
        System.out.println("Digite sua senha:");
        password = scanner.nextLine();

        result = userController.login(email, password);

        ViewUtils.printResultMessage(result);

        return result;
    }
}
