package Models;

import java.util.Date;
/**
 *Classe que representa uma Pedido
 * @author David Lucas Flayban
 */
public class Pedido {
    public long pedidoID;
    public long idProduto;
    public long idCliente;
    public Date dataDoPedido, dataDePrazoDaEntrega;
    public String modoDeEncomenda, statusDoPedido;

    /**
     * Construtor vazio.
     */
    public Pedido(){}

    /**
     * Cosntrutor sem ID
     * @param idProduto o Produto
     * @param idCliente  o Cliente
     * @param dataDoPedido a DataDoPedido
     * @param dataDePrazoDaEntrega a DataDePrazoDeEntrega
     * @param modoDeEncomenda o ModoDeEncomenda
     * @param statusDoPedido o StatusDoPedido
     */
    public Pedido(long idProduto, long idCliente, Date dataDoPedido, Date dataDePrazoDaEntrega, String modoDeEncomenda, String statusDoPedido){
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.dataDoPedido = dataDoPedido;
        this.dataDePrazoDaEntrega = dataDePrazoDaEntrega;
        this.statusDoPedido = statusDoPedido;
        this.modoDeEncomenda = modoDeEncomenda;
    }
    /**
     * Cosntrutor com ID
     * @param pedidoID o PedidoID
     * @param idProduto o Produto
     * @param idCliente  o Cliente
     * @param dataDoPedido a DataDoPedido
     * @param dataDePrazoDaEntrega a DataDePrazoDeEntrega
     * @param modoDeEncomenda o ModoDeEncomenda
     * @param statusDoPedido o StatusDoPedido
     */
    public Pedido(long pedidoID, long idProduto, long idCliente, Date dataDoPedido, Date dataDePrazoDaEntrega, String modoDeEncomenda, String statusDoPedido){
        this.pedidoID = pedidoID;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.dataDoPedido = dataDoPedido;
        this.dataDePrazoDaEntrega = dataDePrazoDaEntrega;
        this.statusDoPedido = statusDoPedido;
        this.modoDeEncomenda = modoDeEncomenda;
    }

    /**
     * Metodo getPedidoID
     * @return pedidoID do pedido desejado
     */
    public long getPedidoID() {
        return pedidoID;
    }
    /**
     * Metodo setPedido
     * @param pedidoID atribui um valor a vareavel pedidoID
     */
    public void setPedidoID(long pedidoID) {
        this.pedidoID = pedidoID;
    }
    /**
     * Metodo getCliente
     * @return cliente do pedido desejado
     */
    public long getIdCliente() {
        return idCliente;
    }
    /**
     * Metodo setCliente
     * @param idCliente atribui um valor a vareavel cliente
     */
    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    /**
     * Metodo getProduto
     * @return produto do pedido desejado
     */
    public long getIdProduto() {
        return idProduto;
    }
    /**
     * Metodo setProduto
     * @param idProduto atribui um valor a vareavel produto
     */
    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }
    /**
     * Metodo getDataDePrazoDaEntrega
     * @return dataDePrazoDaEntrega do pedido desejado
     */
    public Date getDataDePrazoDaEntrega() {
        return dataDePrazoDaEntrega;
    }
    /**
     * Metodo setDataDePrazoDaEntrega
     * @param dataDePrazoDaEntrega atribui um valor a vareavel dataDePrazoDaEntrega
     */
    public void setDataDePrazoDaEntrega(Date dataDePrazoDaEntrega) {
        this.dataDePrazoDaEntrega = dataDePrazoDaEntrega;
    }
    /**
     * Metodo getStatusDoPedido
     * @return statusDoPedido do pedido desejado
     */
    public String getStatusDoPedido() {
        return statusDoPedido;
    }
    /**
     * Metodo setStatusDoPedido
     * @param statusDoPedido atribui um valor a vareavel statusDoPedido
     */
    public void setStatusDoPedido(String statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
    /**
     * Metodo getDataDoPedido
     * @return dataDoPedido do pedido desejado
     */
    public Date getDataDoPedido() {
        return dataDoPedido;
    }
    /**
     * Metodo setDataDoPedido
     * @param dataDoPedido atribui um valor a vareavel dataDoPedido
     */
    public void setDataDoPedido(Date dataDoPedido) {
        this.dataDoPedido = dataDoPedido;
    }
    /**
     * Metodo getModoDeEncomenda
     * @return modoDeEncomenda do pedido desejado
     */
    public String getModoDeEncomenda() {
        return modoDeEncomenda;
    }
    /**
     * Metodo setModoDeEncomenda
     * @param modoDeEncomenda atribui um valor a vareavel modoDeEncomenda
     */
    public void setModoDeEncomenda(String modoDeEncomenda) {
        this.modoDeEncomenda = modoDeEncomenda;
    }
}
