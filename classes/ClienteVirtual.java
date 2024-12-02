public class ClienteVirtual extends Cliente{
    private String endereco;
    private int tempoEntrega;

    public ClienteVirtual(String nome, Pizzaria pizzaria, String enderecoEntrega) {
        super(nome);
        this.endereco = enderecoEntrega;
        this.tempoEntrega = pizzaria.calcularTempoEntrega();
    }
    public void receberConta(int valor) {
        this.setDivida(this.getDivida()+valor);
        System.out.println("Conta atual: R$" + this.getDivida());
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
}
