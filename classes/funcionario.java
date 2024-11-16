abstract class  funcionario {
    //Atributos
    private int salario;
    private String funcao;
    private String nome;


    //Contrutor
    public funcionario(int salario, String funcao, String nome) {
        setSalario(salario);
        setFuncao(funcao);
        setNome(nome);
    }
    //Método

    abstract void receberComissao();
    abstract void trabalhar ();

    public void verInformações (){
        System.out.println("O nome do funcionário da pizzaria é "+getNome()
                +", a sua função na pizzaria é "+getFuncao()+" possuindo como salário R$"+getSalario()+".");
    }

    //Get e Set
    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
