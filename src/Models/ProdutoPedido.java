package Models;

public class ProdutoPedido {
    private long produtoID;
    private long pedidoID;
    private double preco_venda_produto;
    private int quantidade;

    public ProdutoPedido(long produtoID,long pedidoID, double preco_venda_produto, int quantidade) {

        this.produtoID = produtoID;
        this.pedidoID = pedidoID;
        this.preco_venda_produto = preco_venda_produto;
        this.quantidade = quantidade;
    }

    public ProdutoPedido() {
    }

    public long getPedidoID() {
        return pedidoID;
    }

    public void setPedidoID(int pedidoID) {
        this.pedidoID = pedidoID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public long getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public double getPreco_venda_produto() {
        return preco_venda_produto;
    }

    public void setPreco_venda_produto(float preco_venda_produto) {
        this.preco_venda_produto = preco_venda_produto;
    }

    @Override
    public String toString() {
        return "Pedido_Produto{" +
                "produtoID =" + produtoID +
                ", pedidoID =" + pedidoID +
                ", preco_venda_produto=" + preco_venda_produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
