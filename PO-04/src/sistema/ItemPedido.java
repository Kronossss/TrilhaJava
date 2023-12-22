package sistema;

public class ItemPedido {
    private String produto;
    private double preco;
    private int quantidade;

    public ItemPedido(String produto, double preco, int quantidade) {
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getProduto() {
        return produto;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularSubtotal() {
        return preco * quantidade;
    }
}
