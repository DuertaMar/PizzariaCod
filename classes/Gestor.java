import java.util.Scanner;

public class Gestor {
    private Pizzaria pizzaria;

    public Gestor(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

    public void fazerDemanda (){
        pizzaria.pedirDemanda();
    }

    public void gerir() {
        Scanner scanner = new Scanner(System.in);
        int escolha;
        do {
            do {
                System.out.println("\nOlá gestor da pizzaria " + pizzaria.getNome() + " escolha." +
                        "\n1_Ver informações\n2_Pedir demanda\n3_Dar bônus aos funcionário\n4_Ver Funcionários\n5_Sair");
                escolha = scanner.nextInt();
            } while (escolha < 1 || escolha > 5);
            if (escolha == 1) {
                pizzaria.verInformacoes();
            }
            if (escolha == 2) {
                this.fazerDemanda();
            }
            if (escolha == 3) {
                pizzaria.pagarFuncionario();
            }
            if (escolha == 4) {
                pizzaria.verFuncionarios();
            }
        } while (escolha != 5);
    }

    public Pizzaria getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

}
