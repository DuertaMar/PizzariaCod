public class Atendente extends Funcionario{
    public Atendente(int salario, String funcao, String nome) {
        super(salario, funcao, nome);
    }

    @Override
    void receberComissao() {
        System.out.println("A comissão extra da funcionária é considerando aquantidade de pedidos registrados" +
                " e pelo respeito aos clientes");

    }

    @Override
    void trabalhar() {
        System.out.println("A atendente está atendendo pedidos");

    }
}
