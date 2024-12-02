public class Motoboy extends Funcionario{
    public Motoboy(int salario, String funcao, String nome) {
        super(salario, funcao, nome);
    }

    @Override
    void receberComissao() {
        System.out.println("A comissão extra do funcionário é feito pela quantidade de pedidos entregues" +
                " e se o cliente optar por dar uma gorjeta na entrega.");

    }

    @Override
    void trabalhar() {
        System.out.println("O motoboy está entregando pedidos");

    }

}
