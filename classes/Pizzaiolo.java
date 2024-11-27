public class Pizzaiolo extends Funcionario{
    public Pizzaiolo(int salario, String funcao, String nome) {
        super(salario, funcao, nome);
    }

    @Override
    void receberComissao() {
        System.out.println("A comissão do funcionario é considerando a quantidade de pizzas feitas e " +
                "a quantidade de elogios dos clientes para a pizza.");

    }

    @Override
    void trabalhar() {
        System.out.println("O pizzaiolo está fazendo pizzas.");

    }
}


