package Models;

/**
 *Classe que representa uma Categoria
 * @author David Lucas Flayban
 */

public class Categoria {
    public long categoriaID;
    public String nome;
    public String descricao;

    /**
     * Construtor vazio.
     */
    public Categoria(){};

    /**
     * Construtor sem ID
     * @param nome o Nome
     * @param descricao a Descrição
     */
    public Categoria(String nome, String descricao){
        this.nome = nome;
        this.descricao = descricao;
    }
    /**
     * Construtor com ID
     * @param categoriaID o ID_de_categoria
     * @param nome o Nome
     * @param descricao a Descrição
     */
    public Categoria(long categoriaID, String nome, String descricao){
        this.categoriaID = categoriaID;
        this.nome = nome;
        this.descricao = descricao;
    }
    /**
     * Metodo getCategoriaID
     * @return ID da categoria desejado
     */
    public long getCategoriaID() {
        return categoriaID;
    }

    /**
     * Metodo setCategoriaID
     * @param categoriaID atribui um valor a vareavel categoriaID
     */
    public void setCategoriaID(long categoriaID) {
        this.categoriaID = categoriaID;
    }
    /**
     * Metodo getNome
     * @return nome da categoria desejado
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
     * Metodo getDscricao
     * @return descricao da categoria desejado
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
}
