public class ClienteFisico extends Cliente {
    public ClienteFisico(String nome, Pizzaria pizzaria) {
        super(nome);
        this.setDivida(0);
    }

    public void receberConta(int valor) {
        this.setDivida(this.getDivida()+valor);
        System.out.println("Conta atual: R$" + this.getDivida());
    }

}
