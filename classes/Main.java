import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            Pizzaria pizzaria = new Pizzaria();
            pizzaria.atenderCliente();

            int escolha;
            do {
                System.out.println("Escolha se gostaria de ser um cliente ou o gestor da pizzaria."
                        +"1- Gestor da pizzaria \n2- Cliente da Pizzaria");
                escolha = scanner.nextInt();
            } while (escolha<1||escolha>2);

            if (escolha==1){

            } else {

            }
        }
}


