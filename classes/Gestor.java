public class Gestor {
    private Pizzaria pizzaria;


    public Gestor(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

    public void fazerDemanda (){
        pizzaria.pedirDemanda();
    }

    public Pizzaria getPizzaria() {
        return pizzaria;
    }

    public void setPizzaria(Pizzaria pizzaria) {
        this.pizzaria = pizzaria;
    }

}
