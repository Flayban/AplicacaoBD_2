package Models;
/**
 *Classe que representa uma Estoque
 * @author David Lucas Flayban
 */
public class Estoque {
    public long estoqueID;
    public long idProduto;
    public long idArmazem;
    public int quantidade;
    public String codigo;

    /**
     * Construtor vazio.
     */
    public Estoque(){}

    /**
     * Construtor sem ID
     * @param idProduto o Produto
     * @param idArmazem o Armazém
     * @param codigo o Codígo
     * @param quantidade a Quantidade
     */
    public Estoque( String codigo , int quantidade, long idArmazem, long idProduto){
        this.idProduto = idProduto;
        this.idArmazem = idArmazem;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }

    /**
     * Construtor com ID
     * @param estoqueID o EstoqueID
     * @param idProduto o Produto
     * @param idArmazem o Armazém
     * @param codigo o Codígo
     * @param quantidade a Quantidade
     */
    public Estoque(long estoqueID, String codigo, int quantidade ,long idArmazem, long idProduto){
        this.estoqueID = estoqueID;
        this.idProduto = idProduto;
        this.idArmazem = idArmazem;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }
    /**
     * Metodo getEstoqueID
     * @return estoqueID do Estoque desejado
     */
    public long getEstoqueID() {
        return estoqueID;
    }
    /**
     * Metodo setEstoqueID
     * @param estoqueID atribui um valor a vareavel estoqueID
     */
    public void setEstoqueID(long estoqueID) {
        this.estoqueID = estoqueID;
    }
    /**
     * Metodo getProduto
     * @return produto do Estoque desejado
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
     * Metodo getArmazem
     * @return armazem do Estoque desejado
     */
    public long getIdArmazem() {
        return idArmazem;
    }
    /**
     * Metodo setArmazem
     * @param idArmazem atribui um valor a vareavel armazem
     */
    public void setIdArmazem(long idArmazem) {
        this.idArmazem = idArmazem;
    }
    /**
     * Metodo getQuantidade
     * @return quantidade do Estoque desejado
     */
    public int getQuantidade() {
        return quantidade;
    }
    /**
     * Metodo setQuantidade
     * @param quantidade atribui um valor a vareavel quantidade
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Metodo getCodigo
     * @return codigo do Estoque desejado
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Metodo setCodigo
     * @param codigo atribui um valor a vareavel codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
