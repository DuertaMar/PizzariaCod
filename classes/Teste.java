public class Teste {
    public static void main(String[] args) {
        Funcionario motoboy= new Motoboy(20,"Dar grau", "Vitin");
        Funcionario atendente = new Atendente(20,"Xingar Cliente", "Anaaa");
        Funcionario garcom = new Garcom(20,"Derrubar prato", "Kilen");
        Funcionario pizzaiolo = new Pizzaiolo(20,"Jogar pizzas", "Zegraca");
        Cliente clientefisico = new ClienteFisico("CLovis", new Pizzaria());
        ///Com cliente clientevirtual = new Cliente... ele não permite isntancair os métodos do cliente virtual
        ClienteVirtual clientevirtual = new ClienteVirtual("Globis", new Pizzaria(), "Rua das Valas");
        Fornecedor forenedo = new Fornecedor("Precubom",10,"Ar");
        Pedido pedido12= new Pedido("ISsoaipae", new ClienteFisico("hablau", new Pizzaria()), 20,10);
        Entrega engrga;
        Pizzaria pizzaria = new Pizzaria();
        System.out.println("No Cliente virtual, dunada ele da a taxa de entrega, por no construtor" +
                ", ele ir para o método calcular, que manda um sout. melhor enviar ou guardar no set.");



        System.out.println("\n\nFuncionários");
        motoboy.trabalhar();
        motoboy.verInformacoes();
        motoboy.receberComissao();

        System.out.println("\n\nClientes");
        System.out.println(clientefisico.getDivida());
        clientefisico.setDivida(20);
        clientefisico.receberConta(50);

        System.out.println(clientevirtual.getDivida());
        clientevirtual.setDivida(20);
        clientevirtual.receberConta(30);
        //Aqui ele vai mandar o 10 no sout pelo mesmo motivo de existir um sout no método receber conta.
        clientevirtual.setTempoEntrega(10);
        System.out.println(clientevirtual.getEndereco());

        System.out.println("\n\nFornecedor");
        forenedo.Demanda(10);
        System.out.println("\n\nPedido");
        System.out.println("Aqui talvez falte um método de ver informações pedido");
        System.out.println(pedido12.calcularPreco());

        System.out.println("\n\nPizzaria");
        pizzaria.pagarFuncionario();
        pizzaria.atenderCliente();
        // Atender cliente precisa de uma verificação na hora de receber o tipo de cliente
        // Por algum caraios a conta começa com R$ 10 provavelmente por ser o valor da "distancia....", isto no virtual.
        //É possivel pedir "0 itens"
        //Caso o cliente não quera pagar o programa "Para".
        // Em teoria depois do pagamento deveria mostrar os pedidos feitos não e o total?
        pizzaria.pagarFuncionario();
        pizzaria.calcularTempoEntrega();


        pizzaria.setCaixa(500);
        pizzaria.pedirDemanda();
        //As pizzas, bebidas e sucos vão ficar como variaveis ou não? me veio a duvida neste método


        //System.out.println("\n este método exibir menu estava como private provavelmente por causa do método apresentar menu");
        //pizzaria.exibirMenu();
        //System.out.println("\n este método apresentar menu estava como privado por causa do atender Cliente");
        //pizzaria.apresentarMenu(clientefisico);
        //System.out.println("\neste método estava como privado por causa do apresentar menu ");
        //pizzaria.receberPagamento(clientefisico);
        //Aqui está precisando de um verificador de pagamento, está um pouco estranho este 1



    }
}
