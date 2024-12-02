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
        System.out.println("O fornecedor analisou a demanda e calculou o preço considerando a quantidade no" +
                "estoque");
        valor =calcularPreco(qnt);
        System.out.println("O fornecedor analisou o pedido de "+qnt+" e o preço ficara no total R$"+valor+".");
        System.out.println("O fornecedor está enviando as caixas de "+tipoProduto);
        return valor;
    }
    public int calcularPreco (int qnt) {
        int valor = this.preco*qnt;
        return valor;
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


