import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pizzaria pizzaria = new Pizzaria();
        Gestor gestorPizzaria;
        String frase;
        int escolha,escolha2, saida;

        System.out.println("Definindo o nome da pizzaria");
        frase=scanner.next();
        pizzaria.setNome(frase);
        System.out.println("Defina o caixa incial");
        escolha=scanner.nextInt();
        pizzaria.setCaixa(escolha);
        System.out.println("Defina o endereço da pizzaria");
        frase=scanner.nextLine();
        pizzaria.setEndereco(frase);
        gestorPizzaria = new Gestor(pizzaria);
        do {
            System.out.println("O quê gostaria de fazer na pizzaria\n1_Cliente\n2_Gestor\n3_Sair");
            saida = scanner.nextInt();

            if (saida == 1) {
                do {


                    do {
                        System.out.println("Começando como cliente, gostaria de ser cliente fisico ou virtual?");
                        System.out.println("\n1_Fisico");
                        System.out.println("\n2_Virtual");
                        System.out.println("\n3_Sair");
                        escolha = scanner.nextInt();

                    } while (escolha < 1 || escolha > 3);
                    if (escolha==1){}
                    if (escolha==2){}

                }  while (escolha != 3);
            }
            // Gestor Cod
            if (saida==2) {
                do {
                    do {
                        System.out.println("Olá gestor da pizzaria " + pizzaria.getNome() + " escolha o quê gostaria de fazer" +
                                "\n1_Ver informações\n2_Pedir demanda\n3_Dar bonus(Funcionario)\n4_Sair");
                        escolha2 = scanner.nextInt();
                    } while (escolha2 < 1 || escolha2 > 4);
                    if (escolha2 == 1) {
                        pizzaria.verInformacoes();
                    }
                    if (escolha2 == 2) {
                       gestorPizzaria.fazerDemanda();
                    }
                    if (escolha2 == 3) {
                        pizzaria.pagarFuncionario();
                    }
                } while (escolha2 != 4);
            }

        }while (saida!=3);

        //
        //A main vai ser o gestor e o cliente ao mesmo tempo, quando a pizza, sobremesa, ou bebida for menor que um determinado valor
        // ele troca para gestor, para pedir as demandas e oq tiver, e quando recuperar ele votla a ser cliente;
        // teria que ver como funcionaria os relacionamentos entre os códigos e os outros códigos e as trocas
    }
}
