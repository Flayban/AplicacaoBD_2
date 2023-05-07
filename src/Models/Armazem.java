package Models;
/**
 *Classe que representa uma Armazem
 * @author David Lucas Flayban
 */
public class Armazem {
    public long armazemID;
    public String endereco, codigo;

    /**
     * Construtor vazio.
     */
    public Armazem(){}

    /**
     * Construtor sem ID
     * @param endereco o Endereço
     * @param codigo  o Nome
     */
    public Armazem(String endereco, String codigo){

        this.endereco = endereco;
        this.codigo = codigo;
    }
    /**
     * Construtor com ID
     * @param armazemID o ArmazémID
     * @param endereco o Endereço
     * @param codigo  o Codigo
     */
    public Armazem(long armazemID,String endereco, String codigo){
        this.armazemID = armazemID;
        this.endereco = endereco;
        this.codigo = codigo;
    }
    /**
     * Metodo getArmazemID
     * @return armazemID do Armazem desejado
     */
    public long getArmazemID() {
        return armazemID;
    }
    /**
     * Metodo setArmazemID
     * @param armazemID atribui um valor a vareavel armazemID
     */
    public void setArmazemID(long armazemID) {
        this.armazemID = armazemID;
    }

    /**
     * Metodo getNome
     * @return nome do Armazem desejado
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Metodo setNome
     * @param codigo atribui um valor a vareavel nome
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Metodo getEndereco
     * @return endereco do Armazem desejado
     */
    public String getEndereco() {
        return endereco;
    }
    /**
     * Metodo setEndereco
     * @param endereco atribui um valor a vareavel endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
