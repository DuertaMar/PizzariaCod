import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestor gestorPizzaria;
        String nomePizzaria, endereco;
        int caixa, escolha, saida;

        System.out.println("Definindo o nome da pizzaria.");
        nomePizzaria=scanner.nextLine();
        do {


            System.out.println("Defina o caixa incial, caixa maior ou igual a 0.");
            caixa = scanner.nextInt();
        } while (caixa<0);
        scanner.nextLine();
        System.out.println("Defina o endereço da pizzaria.");
        endereco=scanner.nextLine();
        Pizzaria pizzaria = new Pizzaria(nomePizzaria, endereco, caixa);

        gestorPizzaria = new Gestor(pizzaria);

        do {
            System.out.println("\nO quê gostaria de fazer na pizzaria\n1_Cliente\n2_Gestor\n3_Sair");
            saida = scanner.nextInt();
            if (saida == 1) {
                pizzaria.atenderCliente();
            }
            if (saida==2) {
                gestorPizzaria.gerir();
            }
        }while (saida!=3);
    }
}
