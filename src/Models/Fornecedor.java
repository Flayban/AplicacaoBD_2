package Models;
/**
 *Classe que representa uma Fornecedor
 * @author David Lucas Flayban
 */
public class Fornecedor {
    public long fornecedorID;
    public String nome, cpfCnpj, tipoDeFornecedor, localidade;

    /**
     * Construtor vazio.
     */
    public Fornecedor(){}

    /**
     * Construtor sem ID
     * @param nome o Nome
     * @param cpfCnpj o CPF_ou_CNPJ
     * @param tipoDeFornecedor o Tipo de fornecedor
     * @param localidade a Localidade
     */

    public Fornecedor(String nome, String localidade, String tipoDeFornecedor, String cpfCnpj){
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.localidade = localidade;
        this.tipoDeFornecedor = tipoDeFornecedor;
    }

    /**
     * Construtor com ID
     * @param fornecedorID o ID do Fornecedor
     * @param nome o Nome
     * @param cpfCnpj o CPF_ou_CNPJ
     * @param tipoDeFornecedor o Tipo de fornecedor
     * @param localidade a Localidade
     */
    public Fornecedor(long fornecedorID, String nome,String localidade , String tipoDeFornecedor, String cpfCnpj){
        this.fornecedorID = fornecedorID;
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.localidade = localidade;
        this.tipoDeFornecedor = tipoDeFornecedor;
    }

    /**
     * Metodo getFornecedorID
     * @return ID do fornecedor desejado
     */
    public long getFornecedorID() {
        return fornecedorID;
    }
    /**
     * Metodo setFornecedorID
     * @param fornecedorID atribui um valor a vareavel fornecedorID
     */
    public void setFornecedorID(long fornecedorID) {
        this.fornecedorID = fornecedorID;
    }

    /**
     * Metodo getNome
     * @return nome do fornecedor desejado
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
     * Metodo getCpfCnpj
     * @return cpfCnpj do fornecedor desejado
     */
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    /**
     * Metodo setCpfCnpj
     * @param cpfCnpj atribui um valor a vareavel cpfCnpj
     */
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    /**
     * Metodo getLocalidade
     * @return localidade do fornecedor desejado
     */
    public String getLocalidade() {
        return localidade;
    }
    /**
     * Metodo setLocalidade
     * @param localidade atribui um valor a vareavel localidade
     */
    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    /**
     * Metodo getTipoDeFornecedor
     * @return tipoDeFornecedor do fornecedor desejado
     */
    public String getTipoDeFornecedor() {
        return tipoDeFornecedor;
    }
    /**
     * Metodo setTipoDeFornecedor
     * @param tipoDeFornecedor atribui um valor a vareavel tipoDeFornecedor
     */
    public void setTipoDeFornecedor(String tipoDeFornecedor) {
        this.tipoDeFornecedor = tipoDeFornecedor;
    }
}
