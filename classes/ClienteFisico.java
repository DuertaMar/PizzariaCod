public class ClienteFisico extends Cliente {
    private int divida;

    public ClienteFisico(String nome, Pizzaria pizzaria) {
        super(nome);
        this.divida = 0;
    }

    public int getDivida() {
        return divida;
    }

    public void setDivida(int divida) {
        this.divida = divida;
    }

    public void receberConta(int valor) {
        this.divida += valor;
        System.out.println("Conta atual: R$" + this.divida);
    }
}
