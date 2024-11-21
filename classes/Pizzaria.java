import java.util.Random;
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

    public void atenderCliente() {
        Scanner scanner = new Scanner(System.in);
        String nomeCliente, tipoCliente;
        System.out.println("Digite seu nome: ");
        nomeCliente = scanner.nextLine();
        System.out.println("Que tipo de cliente você é? Digite 'F' para cliente físico " +
                "ou 'V' para cliente virtual.");
        tipoCliente = scanner.nextLine().toUpperCase();

        if (tipoCliente.equals("V")) {
            System.out.print("Digite seu endereço para entrega: ");
            String enderecoEntrega = scanner.nextLine();
            ClienteVirtual cliente = new ClienteVirtual(nomeCliente, this, enderecoEntrega);
            apresentarMenu(cliente);
        } else {
            ClienteFisico cliente = new ClienteFisico(nomeCliente, this);
            apresentarMenu(cliente);
        }
    }
    private void apresentarMenu(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
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

    private void realizarPedido(int comando, Cliente cliente, int qtd) {
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

    private void receberPagamento(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        if (cliente.getDivida() > 0) {
            if (cliente instanceof ClienteVirtual) {
                ClienteVirtual clienteVirtual = (ClienteVirtual) cliente;
                System.out.println("O pedido será entregue para o endereço "+clienteVirtual.getEndereco());
                System.out.println("O tempo estimado de entrega é de " + clienteVirtual.getTempoEntrega() + " minutos.");
            }
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


    public void pedirDemanda () {
        Scanner scanner = new Scanner(System.in);
        int escolha, qnt;
        Random random = new Random();
        fornecedor fornecedor1 = new fornecedor("PizzaPrima", random.nextInt(21),"Pizzas");
        fornecedor fornecedor2 = new fornecedor("PizzaMateria", random.nextInt(21),"Pizzas");
        fornecedor fornecedor3 = new fornecedor("BebidasLighs", random.nextInt(10),"Bebidas");
        fornecedor fornecedor4 = new fornecedor("SucosNatural", random.nextInt(10),"Sucos");
        fornecedor fornecedor5 = new fornecedor("SobreHoje", random.nextInt(14),"Sobremesas");
        fornecedor fornecedor6 = new fornecedor("SobreGelados", random.nextInt(14),"Sobremesas");
        if (this.caixa > 0) {
            do {
                System.out.println("A pizzaria está precisando de que tipo de demanda? pressione o valor entre 1 a 3.");
                System.out.println("1_Pizzas\n2_Bebidas, Sucos\n3_Sobremesas");
                escolha = scanner.nextInt();
            } while (escolha<1|escolha>3);

            if (escolha == 1){
                do {
                    System.out.println("Os fornecedores são: " +
                            "\n1_Nome: " + fornecedor1.getNome() + " com os preços de: " + fornecedor1.getPreco() +
                            "\n2_Nome: " + fornecedor2.getNome() + " com os preços de: " + fornecedor2.getPreco());
                    System.out.println("Escolha entre os fornecedores.");
                    escolha = scanner.nextInt();
                } while (escolha<1||escolha>2);
                do {


                    System.out.println("Agora escolha a quantidade.\nLembrar da quantidade disponivel em caixa que atualmente é R$" + getCaixa());
                    qnt = scanner.nextInt();
                } while(qnt*fornecedor1.getPreco()>getCaixa()||qnt*fornecedor2.getPreco()>getCaixa());
                if (escolha == 1){
                    setCaixa(getCaixa()-fornecedor1.Demanda(qnt));
                } else {
                    setCaixa(getCaixa()-fornecedor2.Demanda(qnt));
                }


            } else if (escolha==2) {
                do {
                    System.out.println("Os fornecedores são: " +
                            "\n1_Nome: " + fornecedor3.getNome() + " com os preços de: " + fornecedor3.getPreco() +
                            "\n2_Nome: " + fornecedor4.getNome() + " com os preços de: " + fornecedor4.getPreco());
                    System.out.println("Escolha entre os fornecedores.");
                    escolha = scanner.nextInt();
                } while (escolha<1||escolha>2);
                do {


                    System.out.println("Agora escolha a quantidade.\nLembrar da quantidade disponivel em caixa que atualmente é R$" + getCaixa());
                    qnt = scanner.nextInt();
                } while(qnt*fornecedor3.getPreco()>getCaixa()||qnt*fornecedor4.getPreco()>getCaixa());
                if (escolha == 1){
                    setCaixa(getCaixa()-fornecedor3.Demanda(qnt));
                } else {
                    setCaixa(getCaixa()-fornecedor4.Demanda(qnt));
                }

            } else {
                do {
                    System.out.println("Os fornecedores são: " +
                            "\n1_Nome: " + fornecedor5.getNome() + " com os preços de: " + fornecedor5.getPreco() +
                            "\n2_Nome: " + fornecedor6.getNome() + " com os preços de: " + fornecedor6.getPreco());
                    System.out.println("Escolha entre os fornecedores.");
                    escolha = scanner.nextInt();
                } while (escolha<1||escolha>2);
                do {


                    System.out.println("Agora escolha a quantidade.\nLembrar da quantidade disponivel em caixa que atualmente é R$" + getCaixa());
                    qnt = scanner.nextInt();
                } while(qnt*fornecedor5.getPreco()>getCaixa()||qnt*fornecedor6.getPreco()>getCaixa());
                if (escolha == 1){
                    setCaixa(getCaixa()-fornecedor5.Demanda(qnt));
                } else {
                    setCaixa(getCaixa()-fornecedor6.Demanda(qnt));
                }

            }
        } else {
            System.out.println("A pizzaria está sem dinheiro, atualmente para demandas.");
        }

    }

    public int calcularTempoEntrega() {
        Random random = new Random();
        return 10 + random.nextInt(11);
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


