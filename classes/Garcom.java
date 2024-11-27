public class Garcom extends Funcionario{

    public Garcom(int salario, String funcao, String nome) {
        super(salario, funcao, nome);
    }

    @Override
    void receberComissao() {
        System.out.println("Como garçom a comissão extra por cliente é considerada pela quantidade de mesa " +
                "atendidas e se o cliente gostar do atendimento.");

    }

    @Override
    void trabalhar() {
        System.out.println("O garçom está verificando pedidos, entregando pedidos da loja e vendo chamados" +
                " dos clientes.");

    }
}

