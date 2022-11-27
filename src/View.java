import Controllers.UserController;
import Models.Address;
import Models.User;

import java.util.Scanner;

public class View {
    private UserController userController;
    public View(UserController userController) {
        this.userController = userController;
    }
    public void runApp(){
        int answer = -1;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Bem vindos à Locadora do Davi!");

        do {
            System.out.println("O que deseja fazer?");
            System.out.println("(1) Login Usuario");
            System.out.println("(2) Cadastro");
            System.out.println("(3) Login Admin");
            System.out.println("(9) Sair");
            answer = readOption(scanner);

            switch (answer){
                case 1:
                    this.verifyLogin(scanner);
                    break;

                case 2:
                    this.doRegister(scanner);
                    break;

                case 3:
                    this.verifyAdminLogin(scanner);
                    break;

                default:
                    System.out.println("Não há essa opção, digite outro valor.");
                    break;
            }

        } while (answer != 9);
    }

    private void doRegister(Scanner scanner){
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
            this.clearScreen();

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

            this.printRegisterResultMessage(result);

        } while (!result);
    }

    private boolean doLogin(Scanner scanner){
        boolean result;
        String email;
        String password;

        this.clearScreen();

        System.out.println("Digite seu email:");
        email = scanner.nextLine();
        System.out.println("Digite sua senha:");
        password = scanner.nextLine();

        result = userController.login(email, password);

        this.printLoginResultMessage(result);

        return result;
    }

    private void verifyLogin(Scanner scanner) {
        boolean loginResult = this.doLogin(scanner);

        if (loginResult)
            this.showLoggedOptions(scanner);
        else
            System.out.println("Erro ao logar, tente novamente!");
    }

    private void verifyAdminLogin(Scanner scanner) {
        boolean loginResult = this.doLogin(scanner);

        if (loginResult)
            this.showLoggedOptions(scanner);
        else
            System.out.println("Erro ao logar, tente novamente!");
    }

    private void showLoggedOptions(Scanner scanner) {
        int answer = -1;

        do {
            System.out.println("(1) Listar todos filmes");
            System.out.println("(2) Listar filmes favoritos");
            System.out.println("(3) Listar filmes alugados");
            System.out.println("(4) Voltar");
            answer = readOption(scanner);
        } while(answer != 4);
    }

    private void clearScreen() {
        for(int i =0; i< 50; i++){
            System.out.println();
        }
    }

    private void printLoginResultMessage(boolean result) {
        if (result)
            System.out.println("Login realizado!");
        else
            System.out.println("Erro, tente novamente mais tarde!");
    }

    private void printRegisterResultMessage(boolean result) {
        if(result)
            System.out.println("Cadastro realizado!");
        else
            System.out.println("Erro, tente novamente mais tarde!");
    }

    private int readOption(Scanner scanner) {
        int answer = scanner.nextInt();
        scanner.nextLine();

        return answer;
    }
}
