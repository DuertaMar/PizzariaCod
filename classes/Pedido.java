public class Pedido {
    private  String item;
    private  Cliente cliente;
    private  int valorUnitario;
    private  int quantidade;

    public Pedido(String item, Cliente cliente, int valorUnitario, int quantidade) {
        this.item = item;
        this.cliente = cliente;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int calcularPreco() {
        return this.getValorUnitario()*this.getQuantidade();
    }
}