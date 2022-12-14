package Utils;

import Models.CommonUser;
import Models.User;

import java.util.Scanner;

public class ViewUtils {
    public static User loggedUser;

    public static void clearScreen() {
        for(int i =0; i< 50; i++){
            System.out.println();
        }
    }

    public static void printResultMessage(boolean result) {
        if (result)
            System.out.println("Ação realizada!");
        else
            System.out.println("Erro, tente novamente mais tarde!");
    }

    public static int readOption(Scanner scanner) {
        int answer = scanner.nextInt();
        scanner.nextLine();

        return answer;
    }
}
