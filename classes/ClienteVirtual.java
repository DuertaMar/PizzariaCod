public class ClienteVirtual extends Cliente{
    private String endereco;
    private int tempoEntrega;
    private int divida;

    public ClienteVirtual(String nome, Pizzaria pizzaria, String enderecoEntrega) {
        super(nome);
        this.endereco = enderecoEntrega;
        this.tempoEntrega = pizzaria.calcularTempoEntrega();
    }
    public void receberConta(int valor) {
        this.divida += valor;
        System.out.println("Conta atual: R$" + this.divida);
    }
    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    public int getTempoEntrega() {
        return tempoEntrega;
    }
    public void setTempoEntrega(int tempoEntrega) {
        this.tempoEntrega = tempoEntrega;
    }
    public int getDivida() {
        return divida;
    }
    public void setDivida(int divida) {
        this.divida = divida;
    }
}
