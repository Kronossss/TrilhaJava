package sistema;

import java.util.ArrayList;

public class PedidoMain {
    public static void main(String[] args) {
        // Exemplo 1: Pedido sem desconto
        Pedido pedido1 = new Pedido(1, "123.456.789-00");
        pedido1.adicionarItem("Produto A", 50.0, 2);
        pedido1.adicionarItem("Produto B", 30.0, 1);

        // Exemplo 2: Pedido com desconto
        Pedido pedido2 = new Pedido(2, "987.654.321-00");
        ArrayList<ItemPedido> novosItens = new ArrayList<>();
        novosItens.add(new ItemPedido("Produto C", 25.0, 3));
        novosItens.add(new ItemPedido("Produto D", 40.0, 2));
        pedido2.adicionarItens(novosItens);

        // Exibir informações dos pedidos
        System.out.println("Informações do Pedido 1 (sem desconto):");
        pedido1.exibirInformacoes();
        System.out.println("Total do Pedido 1: R$" + pedido1.calcularTotal());
        System.out.println();

        System.out.println("Informações do Pedido 2 (com desconto):");
        pedido2.exibirInformacoes();
        double percentualDesconto = 10.0;
        System.out.println("Total do Pedido 2 com " + percentualDesconto + "% de desconto: R$" + pedido2.calcularTotalComDesconto(percentualDesconto));
        System.out.println();

        // Exemplo de pagamento a prazo
        System.out.println("Total do Pedido 2 a prazo (3 prestações, juro de 5%): R$" + pedido2.calcularTotalAPrazo(3, 5.0));
    }
}
