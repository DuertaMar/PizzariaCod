import java.util.Random;
import java.util.Scanner;

public class Pizzaria {
    private String nome;
    private String endereco;
    private int caixa;
    private int estoquePizza = 10;
    private int estoqueBebida = 10;
    private int estoqueSobremesa = 10;
    private int taxaEntrega = 10;
    private Funcionario atendente;
    private Funcionario garcom;
    private Funcionario motoboy;
    private Funcionario pizzaiolo;

    public Pizzaria(String nome, String endereco, int caixa) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setCaixa(caixa);
        this.atendente = new Atendente(1600,"atender on-line e fisico", "Adriana");
        this.garcom = new Garcom(1450,"direcionar e receber clientes fisicos","Juninho");
        this.motoboy = new Motoboy(1600,"entregar os pedidos virtuais","Fernando");
        this.pizzaiolo= new Pizzaiolo(1700,"preparar as pizzas","Barmelon");

    }
    public void verInformacoes (){
        System.out.println("O nome da pizzaria é "+getNome()+", o endereço da pizzaria é "+getEndereco()+", o atual caixa da pizzaria é "+getCaixa()+"\nA quantidade de pizzas" +
                ": "+getEstoquePizza()+", a quantidade de bebidas: "+getEstoqueBebida()+", a quantidade de sobremesas: "+getEstoqueSobremesa());
    }
    public void verFuncionarios(){
        System.out.println("\nPara atendente temos a funcionária: "+atendente.getNome()+", com o salario de R$"+atendente.getSalario()+", possuindo de funcionalidade "+atendente.getFuncao());
        atendente.receberComissao();
        System.out.println("\nPara motoboy temos o funcionário: "+motoboy.getNome()+", com salario de R$"+motoboy.getSalario()+", possuindo de funcionalidade "+motoboy.getFuncao());
        motoboy.receberComissao();
        System.out.println("\nPara garçom temos o funcionário: "+garcom.getNome()+", com o salario de R$"+garcom.getSalario()+", possuindo de funcionalidade "+garcom.getFuncao());
        garcom.receberComissao();
        System.out.println("\nPara pizzaiolo temos o funcionário: "+pizzaiolo.getNome()+", com o salario de R$"+pizzaiolo.getSalario()+", possuindo de funcionalidade "+pizzaiolo.getFuncao());
        pizzaiolo.receberComissao();
    }

    public void atenderCliente() {
        Scanner scanner = new Scanner(System.in);
        String nomeCliente, tipoCliente;
        System.out.println("Pedido recebido pela atendente "+atendente.getNome());
        System.out.println("Digite seu nome: ");
        nomeCliente = scanner.nextLine();
        do {
            System.out.println("Que tipo de cliente você é? Digite 'F' para cliente físico " +
                    "ou 'V' para cliente virtual.");
            tipoCliente = scanner.nextLine().toUpperCase();
        } while (!tipoCliente.equals("V")&&!tipoCliente.equals("F"));
        if (tipoCliente.equals("V")) {
            System.out.print("Digite seu endereço para entrega: ");
            String enderecoEntrega = scanner.nextLine();
            ClienteVirtual cliente = new ClienteVirtual(nomeCliente, this, enderecoEntrega);
            escolherItem(cliente);
        } else {
            ClienteFisico cliente = new ClienteFisico(nomeCliente, this);
            escolherItem(cliente);
        }
    }
    private void escolherItem(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Olá, " + cliente.getNome() + ", seja bem-vindo(a) à "+this.getNome()+"!");

        int comando, quantidade;
        do {
            exibirMenu();
            do {
                System.out.println("Escolha o número do item ou digite 0 para encerrar: ");
                comando = scanner.nextInt();
            } while (comando < 0 || comando > 9);

            if (comando == 0) break;

            do {
                System.out.println("Digite a quantidade: ");
                quantidade = scanner.nextInt();
                if (quantidade > 0)
                    realizarPedido(comando, cliente, quantidade);
            } while (quantidade <= 0);
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
                if(this.getEstoquePizza() == 0 || this.getEstoquePizza()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoquePizza() > 0) {
                this.setEstoquePizza(this.getEstoquePizza()-qtd);
                }
                cliente.receberConta(calabresa.calcularPreco());
                System.out.println("Pedido realizado: " + calabresa.getItem() + " x" + qtd);
                System.out.println("Pizza feita pelo pizzaiolo "+pizzaiolo.getNome());
                break;
            case 2:
                Pedido margherita = new Pedido("Pizza de Margherita", cliente, 30, qtd);
                if(this.getEstoquePizza() == 0 || this.getEstoquePizza()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoquePizza() > 0) {
                this.setEstoquePizza(this.getEstoquePizza()-qtd);
                }
                cliente.receberConta(margherita.calcularPreco());
                System.out.println("Pedido realizado: " + margherita.getItem() + " x" + qtd);
                System.out.println("Pizza feita pelo pizzaiolo "+pizzaiolo.getNome());
                break;
            case 3:
                Pedido mussarela = new Pedido("Pizza de Muçarela", cliente, 28, qtd);
                if(this.getEstoquePizza() == 0 || this.getEstoquePizza()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoquePizza() > 0) {
                    this.setEstoquePizza(this.getEstoquePizza()-qtd);
                }
                cliente.receberConta(mussarela.calcularPreco());
                System.out.println("Pedido realizado: " + mussarela.getItem() + " x" + qtd);
                System.out.println("Pizza feita pelo pizzaiolo "+pizzaiolo.getNome());
                break;
            case 4:
                Pedido refrigerante = new Pedido("Refrigerante", cliente, 5, qtd);
                if(this.getEstoqueBebida() == 0 || this.getEstoqueBebida()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoqueBebida() > 0) {
                    this.setEstoqueBebida(this.getEstoqueBebida()-qtd);
                }
                cliente.receberConta(refrigerante.calcularPreco());
                System.out.println("Pedido realizado: " + refrigerante.getItem() + " x" + qtd);
                break;
            case 5:
                Pedido suco = new Pedido("Suco", cliente, 7, qtd);
                if(this.getEstoqueBebida() == 0 || this.getEstoqueBebida()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoqueBebida() > 0) {
                    this.setEstoqueBebida(this.getEstoqueBebida()-qtd);
                }
                cliente.receberConta(suco.calcularPreco());
                System.out.println("Pedido realizado: " + suco.getItem() + " x" + qtd);
                break;
            case 6:
                Pedido agua = new Pedido("Água", cliente, 3, qtd);
                if(this.getEstoqueBebida() == 0 || this.getEstoqueBebida()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoqueBebida() > 0) {
                    this.setEstoqueBebida(this.getEstoqueBebida()-qtd);
                }
                cliente.receberConta(agua.calcularPreco());
                System.out.println("Pedido realizado: " + agua.getItem() + " x" + qtd);
                break;
            case 7:
                Pedido pudim = new Pedido("Pudim", cliente, 10, qtd);
                if(this.getEstoqueSobremesa() == 0 || this.getEstoqueSobremesa()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoqueSobremesa() > 0) {
                    this.setEstoqueSobremesa(this.getEstoqueSobremesa()-qtd);
                }
                cliente.receberConta(pudim.calcularPreco());
                System.out.println("Pedido realizado: " + pudim.getItem() + " x" + qtd);
                break;
            case 8:
                Pedido brownie = new Pedido("Brownie", cliente, 12, qtd);
                if(this.getEstoqueSobremesa() == 0 || this.getEstoqueSobremesa()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoqueSobremesa() > 0) {
                    this.setEstoqueSobremesa(this.getEstoqueSobremesa()-qtd);
                }
                cliente.receberConta(brownie.calcularPreco());
                System.out.println("Pedido realizado: " + brownie.getItem() + " x" + qtd);
                break;
            case 9:
                Pedido sorvete = new Pedido("Sorvete", cliente, 8, qtd);
                if(this.getEstoqueSobremesa() == 0 || this.getEstoqueSobremesa()-qtd < 0) {
                    System.out.println("Estoque insuficiente, faça o gerenciamento da pizzaria");
                    break;
                } else if(this.getEstoqueSobremesa() > 0) {
                    this.setEstoqueSobremesa(this.getEstoqueSobremesa()-qtd);
                }
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
            if (cliente instanceof ClienteVirtual) {
                cliente.setDivida(cliente.getDivida()+this.taxaEntrega);
                System.out.println("A taxa de entrega de R$"+this.getTaxaEntrega()+",00 foi adicionada"+"\nQuem entregará será o motoboy "+motoboy.getNome());
            }
            if (cliente instanceof ClienteFisico){
                System.out.println("Quem enviará a pizza será o garçom "+garcom.getNome());
            }
            do {
                System.out.println("O total a pagar é R$" + cliente.getDivida() + ". Digite 1 para pagar:");
                int comando = scanner.nextInt();

                if (comando == 1) {
                    this.caixa += cliente.getDivida();
                    cliente.setDivida(0);
                    System.out.println(cliente.getNome() + ", pagamento realizado com sucesso! Volte mais vezes");
                } else {
                    System.out.println("Pagamento não realizado. Dívida pendente: R$" + cliente.getDivida());
                }
            } while (cliente.getDivida()!=0);
        } else {
            System.out.println("Nenhuma dívida a pagar.");
        }
    }

    public void pedirDemanda () {
        Scanner scanner = new Scanner(System.in);
        int escolha, qnt;
        Random random = new Random();
        Fornecedor fornecedor1 = new Fornecedor("PizzaPrima", random.nextInt(21),"Pizzas");
        Fornecedor fornecedor2 = new Fornecedor("PizzaMateria", random.nextInt(21),"Pizzas");
        Fornecedor fornecedor3 = new Fornecedor("BebidasLighs", random.nextInt(10),"Bebidas");
        Fornecedor fornecedor4 = new Fornecedor("SucosNatural", random.nextInt(10),"Sucos");
        Fornecedor fornecedor5 = new Fornecedor("SobreHoje", random.nextInt(14),"Sobremesas");
        Fornecedor fornecedor6 = new Fornecedor("SobreGelados", random.nextInt(14),"Sobremesas");
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
                    this.setCaixa(getCaixa()-fornecedor1.Demanda(qnt));
                } else {
                    this.setCaixa(getCaixa()-fornecedor2.Demanda(qnt));
                }
                this.setEstoquePizza(this.getEstoquePizza()+qnt);
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
                this.setEstoqueBebida(this.getEstoqueBebida()+qnt);
            } else {
                do {
                    System.out.println("Os fornecedores são: " +
                            "\n1_Nome: " + fornecedor5.getNome() + " com os preços de: " + fornecedor5.getPreco() +
                            "\n2_Nome: " + fornecedor6.getNome() + " com os preços de: " + fornecedor6.getPreco());
                    System.out.println("Escolha entre os fornecedores.");
                    escolha = scanner.nextInt();
                } while (escolha<1||escolha>2);
                do {
                    System.out.println("Agora escolha a quantidade.\nLembrar da quantidade de fundos disponivel no caixa é, atualmente, R$" + getCaixa());
                    qnt = scanner.nextInt();
                } while(qnt*fornecedor5.getPreco()>getCaixa()||qnt*fornecedor6.getPreco()>getCaixa());
                if (escolha == 1){
                    setCaixa(getCaixa()-fornecedor5.Demanda(qnt));
                } else {
                    setCaixa(getCaixa()-fornecedor6.Demanda(qnt));
                }
                this.setEstoqueSobremesa(this.getEstoqueSobremesa()+qnt);
            }
        } else {
            System.out.println("A pizzaria atualmente está sem dinheiro para demandas.");
        }

    }

    public int calcularTempoEntrega() {
        Random random = new Random();
        return 10 + random.nextInt(11);
    }

    public void pagarFuncionario() {
        System.out.println("A pizzaria "+getNome()+" deu bônus aos funcionários");
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
    public int getEstoquePizza() {
        return estoquePizza;
    }
    public void setEstoquePizza(int estoquePizza) {
        this.estoquePizza = estoquePizza;
    }
    public int getEstoqueBebida() {
        return estoqueBebida;
    }
    public void setEstoqueBebida(int estoqueBebida) {
        this.estoqueBebida = estoqueBebida;
    }
    public int getEstoqueSobremesa() {
        return estoqueSobremesa;
    }
    public void setEstoqueSobremesa(int estoqueSobremesa) {
        this.estoqueSobremesa = estoqueSobremesa;
    }
    public int getTaxaEntrega() {
        return taxaEntrega;
    }
    public void setTaxaEntrega(int taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }
}


