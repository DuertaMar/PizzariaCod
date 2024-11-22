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
        Random random = new Random();
        int produto;
        int valor;
        produto = random.nextInt(1-(qnt+1));

        System.out.println("O fornecedor analisou a demanda e calculou o preço considerando a quantidade no" +
                "estoque");
        valor =calcularPreco(produto);
        System.out.println("O fornecedor possui no estoque "+produto+" o preço ficara no total R$"+valor+".");
        System.out.println("O fornecedor está enviando "+tipoProduto);
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


