public class Teste {
    public static void main(String[] args) {
        Funcionario funcionario1 = new Motoboy(20,"Dar grau", "Vitin");
        Funcionario funcionario2 = new Atendente(20,"Xingar Cliente", "Anaaa");
        Funcionario funcionario3 = new Garcom(20,"Derrubar prato", "Kilen");
        Funcionario funcionario4 = new Pizzaiolo(20,"Jogar pizzas", "Zegraca");
        Cliente clientefisico = new ClienteFisico("CLovis", new Pizzaria());
        Cliente clientevirtual = new ClienteVirtual("Globis", new Pizzaria(), "Rua das Valas");
        Fornecedor forenedo = new Fornecedor("Precubom",45678,"Ar");
        Pedido pedido12= new Pedido("ISsoaipae", new ClienteFisico("hablau", new Pizzaria()), 23,12);
        Entrega engrga;
        Pizzaria pizzaria = new Pizzaria();


    }
}
