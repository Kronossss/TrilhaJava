package sistema;

import java.util.ArrayList;

public class Pedido {
    private int numeroPedido;
    private String cpfCliente;
    private ArrayList<ItemPedido> itens;

    public Pedido(int numeroPedido, String cpfCliente) {
        this.numeroPedido = numeroPedido;
        this.cpfCliente = cpfCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(String produto, double preco, int quantidade) {
        ItemPedido item = new ItemPedido(produto, preco, quantidade);
        itens.add(item);
    }

    public void adicionarItens(ArrayList<ItemPedido> novosItens) {
        itens.addAll(novosItens);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public double calcularTotalComDesconto(double percentualDesconto) {
        double totalSemDesconto = calcularTotal();
        double desconto = totalSemDesconto * (percentualDesconto / 100);
        return totalSemDesconto - desconto;
    }

    public double calcularTotalAPrazo(int numeroPrestacoes, double juro) {
        double totalSemJuro = calcularTotal();
        double juroTotal = totalSemJuro * (juro / 100) * numeroPrestacoes;
        return totalSemJuro + juroTotal;
    }

    public void exibirInformacoes() {
        System.out.println("Número do Pedido: " + numeroPedido);
        System.out.println("CPF do Cliente: " + cpfCliente);
        System.out.println("Itens do Pedido:");
        for (ItemPedido item : itens) {
            System.out.println("   Produto: " + item.getProduto() +
                    ", Preço: " + item.getPreco() +
                    ", Quantidade: " + item.getQuantidade() +
                    ", Subtotal: " + item.calcularSubtotal());
        }
    }
}
