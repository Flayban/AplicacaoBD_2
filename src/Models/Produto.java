package Models;

import java.util.Date;

/**
 *Classe que representa uma Produto
 * @author David Lucas Flayban
 */
public class Produto {
    public long produtoID;
    public long idCategoria;
    public long idFornecedor;
    public String descricao, nome; //elementos multivalorados
    public Date dataDeGarantia;
    public float precoMinimoDeVenda;
    public String statusDoProduto;
    public float precoDeCusto, precoDeVenda;

    /**
     * Construtor vazio.
     */
    public Produto(){}

    /**
     * Construtor sem ID
     * @param nome o Nome
     * @param descricao a Descrição
     * @param dataDeGarantia a DataDeGarantia
     * @param precoMinimoDeVenda o PreçoMinimoDeVenda
     * @param statusDoProduto o StatusDoPedido
     * @param precoDeCusto  o PreçoDeCusto
     * @param precoDeVenda o PreçoDeVenda
     */
    public Produto(String nome, String descricao, Date dataDeGarantia, float precoMinimoDeVenda, String statusDoProduto, long idCategoria, long idFornecedor, float precoDeVenda, float precoDeCusto){
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeGarantia = dataDeGarantia;
        this.precoMinimoDeVenda = precoMinimoDeVenda;
        this.statusDoProduto = statusDoProduto;
        this.idCategoria = idCategoria;
        this.idFornecedor = idFornecedor;
        this.precoDeCusto = precoDeCusto;
        this.precoDeVenda = precoDeVenda;
    }
    /**
     * Construtor com ID
     * @param produtoID o ID do Produto
     * @param idCategoria o ID da Categoria
     * @param idFornecedor o ID do Fornecedor
     * @param nome o Nome
     * @param descricao a Descrição
     * @param dataDeGarantia a DataDeGarantia
     * @param precoMinimoDeVenda o PreçoMinimoDeVenda
     * @param statusDoProduto o StatusDoPedido
     * @param precoDeCusto  o PreçoDeCusto
     * @param precoDeVenda o PreçoDeVenda
     */
    public Produto(long produtoID, String nome, String descricao, Date dataDeGarantia, float precoMinimoDeVenda, String statusDoProduto, long idCategoria, long idFornecedor, float precoDeVenda, float precoDeCusto){
        this.produtoID = produtoID;
        this.idCategoria = idCategoria;
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeGarantia = dataDeGarantia;
        this.precoMinimoDeVenda = precoMinimoDeVenda;
        this.statusDoProduto = statusDoProduto;
        this.precoDeCusto = precoDeCusto;
        this.precoDeVenda = precoDeVenda;
    }
    /**
     * Metodo getProdutoID
     * @return produtoID do produto desejado
     */
    public long getProdutoID() {
        return produtoID;
    }
    /**
     * Metodo setProdutoID
     * @param produtoID atribui um valor a vareavel produtoID
     */
    public void setProdutoID(long produtoID) {
        this.produtoID = produtoID;
    }
    /**
     * Metodo getCategoria
     * @return categoria do protudo desejado
     */
    public long getCategoria() {
        return idCategoria;
    }
    /**
     * Metodo setCategoria
     * @param categoria atribui um valor a vareavel categoria
     */
    public void setCategoria(long categoria) {
        this.idCategoria = categoria;
    }
    /**
     * Metodo getFornecedor
     * @return fornecedor do protudo desejado
     */
    public long getIdFornecedor() {
        return idFornecedor;
    }
    /**
     * Metodo setFornecedor
     * @param idFornecedor atribui um valor a vareavel fornecedor
     */
    public void setIdFornecedor(long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }
    /**
     * Metodo getNome
     * @return nome do protudo desejado
     */
    public String getNome() {
        return nome;
    }
    /**
     * Metodo setNome
     * @param nome atribui um valor a vareavel nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    /**
     * Metodo getDescricao
     * @return descricao do protudo desejado
     */
    public String getDescricao() {
        return descricao;
    }
    /**
     * Metodo setDescricao
     * @param descricao atribui um valor a vareavel descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    /**
     * Metodo getDataDegarantia
     * @return dataDeGarantia do protudo desejado
     */
    public Date getDataDeGarantia() {
        return dataDeGarantia;
    }
    /**
     * Metodo setDataDeGarantia
     * @param dataDeGarantia atribui um valor a vareavel dataDeGarantia
     */
    public void setDataDeGarantia(Date dataDeGarantia) {
        this.dataDeGarantia = dataDeGarantia;
    }
    /**
     * Metodo getPrecoMinimoDeVenda
     * @return precoMinimoDeVenda do protudo desejado
     */
    public float getPrecoMinimoDeVenda() {
        return precoMinimoDeVenda;
    }
    /**
     * Metodo setPrecoMinimoDeVenda
     * @param precoMinimoDeVenda atribui um valor a vareavel precoMinimoDeVenda
     */
    public void setPrecoMinimoDeVenda(float precoMinimoDeVenda) {
        this.precoMinimoDeVenda = precoMinimoDeVenda;
    }
    /**
     * Metodo getStatusDoPedido
     * @return statusDoPedido do protudo desejado
     */
    public String getStatusDoProduto() {
        return statusDoProduto;
    }
    /**
     * Metodo setStatusDoPedido
     * @param statusDoProduto atribui um valor a vareavel statusDoPedido
     */
    public void setStatusDoProduto(String statusDoProduto) {
        this.statusDoProduto = statusDoProduto;
    }
    /**
     * Metodo getPrecoDeVenda
     * @return precoDeVenda do protudo desejado
     */
    public float getPrecoDeVenda() {
        return precoDeVenda;
    }
    /**
     * Metodo setPrecoDeVenda
     * @param precoDeVenda atribui um valor a vareavel precoDeVenda
     */
    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }
    /**
     * Metodo getPrecoDeCusto
     * @return precoDeCusto do protudo desejado
     */
    public float getPrecoDeCusto() {
        return precoDeCusto;
    }
    /**
     * Metodo setPrecoDeCusto
     * @param precoDeCusto atribui um valor a vareavel precoDeCusto
     */
    public void setPrecoDeCusto(float precoDeCusto) {
        this.precoDeCusto = precoDeCusto;
    }
}
