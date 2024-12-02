import java.util.Random;

public class Fornecedor {
    //Atributos
    private String nome;
    private int preco;
    private String tipoProduto;

    //Construtor
    public Fornecedor(String nome, int preco, String tipoProduto) {
        setNome(nome);
        setPreco(preco);
        setTipoProduto(tipoProduto);
    }
    //Métodos
    public int Demanda(int qnt) {
        int valor;
        valor =calcularPreco(qnt);
        System.out.println("O fornecedor analisou o pedido com quantidade de "+qnt+" e o preço ficará no total de R$"+valor+".");
        System.out.println("O fornecedor está enviando as caixas de "+getTipoProduto());
        return valor;
    }
    public int calcularPreco (int qnt) {
        return (getPreco()*qnt);
    }

    //Get e Set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}


