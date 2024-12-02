import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gestor gestorPizzaria;
        String nomePizzaria, endereco;
        int caixa, escolha, saida;

        System.out.println("Definindo o nome da pizzaria");
        nomePizzaria=scanner.nextLine();
        System.out.println("Defina o caixa incial");
        caixa=scanner.nextInt();
        scanner.nextLine();
        System.out.println("Defina o endereço da pizzaria");
        endereco=scanner.nextLine();
        Pizzaria pizzaria = new Pizzaria(nomePizzaria, endereco, caixa);

        gestorPizzaria = new Gestor(pizzaria);

        do {
            System.out.println("O quê gostaria de fazer na pizzaria\n1_Cliente\n2_Gestor\n3_Sair");
            saida = scanner.nextInt();
            if (saida == 1) {
                pizzaria.atenderCliente();
            }
            // Gestor Cod
            if (saida==2) {
                gestorPizzaria.gerir();
            }
        }while (saida!=3);

        //A main vai ser o gestor e o cliente ao mesmo tempo, quando a pizza, sobremesa, ou bebida for menor que um determinado valor
        // ele troca para gestor, para pedir as demandas e oq tiver, e quando recuperar ele votla a ser cliente;
        // teria que ver como funcionaria os relacionamentos entre os códigos e os outros códigos e as trocas
    }
}
