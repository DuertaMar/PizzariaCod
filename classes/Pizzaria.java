import java.util.Scanner;

public class Pizzaria {
    private String nome;
    private String endereco;
    private int caixa;

    public Pizzaria() {
        this.nome = "Nome da Pizzaria";
        this.endereco = "Rua da Pizzaria";
        this.caixa = 0;
    }

    public void apresentarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();
        ClienteFisico cliente = new ClienteFisico(nomeCliente, this);

        System.out.println("Olá, " + cliente.getNome() + ", seja bem-vindo(a) à "+this.getNome()+"!");

        int comando;
        do {
            exibirMenu();
            System.out.println("Escolha o número do item ou digite 0 para encerrar: ");
            comando = scanner.nextInt();

            if (comando == 0) break;

            System.out.println("Digite a quantidade: ");
            int quantidade = scanner.nextInt();

            realizarPedido(comando, cliente, quantidade);
        } while (comando != 0);
        receberPagamento(cliente);
    }

    private void exibirMenu() {
        System.out.println("----- Menu da Pizzaria -----");
        System.out.println("Pizzas:");
        System.out.println("1. Pizza de Calabresa - R$35");
        System.out.println("2. Pizza de Margherita - R$30");
        System.out.println("3. Pizza de Muçarela - R$28");

        System.out.println("\nBebidas:");
        System.out.println("4. Refrigerante - R$5");
        System.out.println("5. Suco - R$7");
        System.out.println("6. Água - R$3");

        System.out.println("\nSobremesas:");
        System.out.println("7. Pudim - R$10");
        System.out.println("8. Brownie - R$12");
        System.out.println("9. Sorvete - R$8");
    }

    private void realizarPedido(int comando, ClienteFisico cliente, int qtd) {
        switch (comando) {
            case 1:
                Pedido calabresa = new Pedido("Pizza de Calabresa", cliente, 35, qtd);
                cliente.receberConta(calabresa.calcularPreco());
                System.out.println("Pedido realizado: " + calabresa.getItem() + " x" + qtd);
                break;
            case 2:
                Pedido margherita = new Pedido("Pizza de Margherita", cliente, 30, qtd);
                cliente.receberConta(margherita.calcularPreco());
                System.out.println("Pedido realizado: " + margherita.getItem() + " x" + qtd);
                break;
            case 3:
                Pedido mussarela = new Pedido("Pizza de Muçarela", cliente, 28, qtd);
                cliente.receberConta(mussarela.calcularPreco());
                System.out.println("Pedido realizado: " + mussarela.getItem() + " x" + qtd);
                break;
            case 4:
                Pedido refrigerante = new Pedido("Refrigerante", cliente, 5, qtd);
                cliente.receberConta(refrigerante.calcularPreco());
                System.out.println("Pedido realizado: " + refrigerante.getItem() + " x" + qtd);
                break;
            case 5:
                Pedido suco = new Pedido("Suco", cliente, 7, qtd);
                cliente.receberConta(suco.calcularPreco());
                System.out.println("Pedido realizado: " + suco.getItem() + " x" + qtd);
                break;
            case 6:
                Pedido agua = new Pedido("Água", cliente, 3, qtd);
                cliente.receberConta(agua.calcularPreco());
                System.out.println("Pedido realizado: " + agua.getItem() + " x" + qtd);
                break;
            case 7:
                Pedido pudim = new Pedido("Pudim", cliente, 10, qtd);
                cliente.receberConta(pudim.calcularPreco());
                System.out.println("Pedido realizado: " + pudim.getItem() + " x" + qtd);
                break;
            case 8:
                Pedido brownie = new Pedido("Brownie", cliente, 12, qtd);
                cliente.receberConta(brownie.calcularPreco());
                System.out.println("Pedido realizado: " + brownie.getItem() + " x" + qtd);
                break;
            case 9:
                Pedido sorvete = new Pedido("Sorvete", cliente, 8, qtd);
                cliente.receberConta(sorvete.calcularPreco());
                System.out.println("Pedido realizado: " + sorvete.getItem() + " x" + qtd);
        }
    }

    private void receberPagamento(ClienteFisico cliente) {
        Scanner scanner = new Scanner(System.in);
        if (cliente.getDivida() > 0) {
            System.out.println("O total a pagar é R$" + cliente.getDivida() + ". Digite 1 para pagar:");
            int comando = scanner.nextInt();

            if (comando == 1) {
                this.caixa += cliente.getDivida();
                cliente.setDivida(0);
                System.out.println(cliente.getNome() + ", pagamento realizado com sucesso! Volte mais vezes");
            } else {
                System.out.println("Pagamento não realizado. Dívida pendente: R$" + cliente.getDivida());
            }
        } else {
            System.out.println("Nenhuma dívida a pagar.");
        }
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getCaixa() {
        return caixa;
    }
    public void setCaixa(int caixa) {
        this.caixa = caixa;
    }
}

/*

 * */
