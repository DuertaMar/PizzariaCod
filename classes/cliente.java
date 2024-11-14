public class cliente {
    //Atributos
    private String nome;
    private int id;
    private String endereco;
    //Generator
    public cliente(String endereco, int id, String nome) {
        this.endereco = endereco;
        this.id = id;
        this.nome = nome;
    }
    //Metodos
    public void fazerPedido(){};
    public void cancelarPedido(){};
    public String feedback(){};



























    //Getter e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
