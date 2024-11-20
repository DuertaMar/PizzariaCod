public abstract class Cliente {
    private String nome;
    private int divida;

    public Cliente(String nome) {
        this.nome = nome;
    }
    public abstract void receberConta(int valor);
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDivida() {
        return divida;
    }
    public void setDivida(int divida) {
        this.divida = divida;
    }
}
