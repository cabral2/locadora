package Views;

import Utils.ViewUtils;

import java.util.Scanner;

public class MovieView {

    public void showLoggedOptions(Scanner scanner) {
        int answer = -1;

        do {
            System.out.println("(1) Listar todos filmes");
            System.out.println("(2) Listar filmes favoritos");
            System.out.println("(3) Listar filmes alugados");
            System.out.println("(4) Voltar");
            answer = ViewUtils.readOption(scanner);

            switch (answer){
                case 1:
                    this.showAllMovies(scanner);
                    break;

                case 2:
                    this.showFavoriteMovies(scanner);
                    break;

                case 3:
                    this.showRentedMovies(scanner);
                    break;

                default:
                    System.out.println("Não há essa opção, digite outro valor.");
                    break;
            }
        } while(answer != 4);
    }

    public void showAllMovies(Scanner scanner){

    }
    public void showFavoriteMovies(Scanner scanner){

    }
    public void showRentedMovies(Scanner scanner){

    }
}
