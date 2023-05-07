package Models;

import java.util.Date;

/**
 *Classe que representa um Cliente
 * @author David Lucas Flayban
 */
public class Cliente{
    public long clienteID;
    public String nome;
    public Date dataDeCadastro;
    public String pais;
    public String estado;
    public String cidade;
    public String email, telefone; //multivalorados
    public float limiteDeCredito;

    /**
     * Construtor vazio.
     */
    public Cliente(){}

    /**
     * Construtor sem ID
     * @param nome o Nome
     * @param dataDeCadastro a Data de cadastro
     * @param pais a País
     * @param estado o Estado
     * @param cidade a Cidade
     * @param telefone o Telefone
     * @param email o Email
     * @param limiteDeCredito o Limite_de_Crédito
     */
    public Cliente(String nome, String pais, String estado, String cidade, String email, String telefone, float limiteDeCredito, Date dataDeCadastro){
        this.nome = nome;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.limiteDeCredito = limiteDeCredito;
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     * Construtor com ID
     * @param clienteID o ID_do_Cliente
     * @param nome o Nome
     * @param dataDeCadastro a Data de cadastro
     * @param pais a País
     * @param estado o Estado
     * @param cidade a Cidade
     * @param telefone o Telefone
     * @param email o Email
     * @param limiteDeCredito o Limite_de_Crédito
     */

    public Cliente(long clienteID, String nome, String pais, String estado, String cidade, String email, String telefone, float limiteDeCredito, Date dataDeCadastro){
        this.clienteID = clienteID;
        this.nome = nome;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.limiteDeCredito = limiteDeCredito;
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     * Metodo getClienteID
     * @return ID do cliente desejado
     */
    public long getClienteID() {
        return clienteID;
    }

    /**
     * Metodo setClienteID
     * @param clienteID atribui um valor a vareavel clienteID
     */
    public void setClienteID(long clienteID) {
        this.clienteID = clienteID;
    }

    /**
     * Metodo getNome
     * @return Nome do cliente desejado
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
     * Metodo getDataDeNascimento
     * @return Data de nascimento do cliente desejado
     */
    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    /**
     * Metodo setDataDenascimento
     * @param dataDeCadastro atribui um valor a vareavel dataDeNascimento
     */
    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    /**
     * Metodo getPais
     * @return País do cliente desejado
     */
    public String getPais() {
        return pais;
    }

    /**
     * Metodo setPais
     * @param pais atribui um valor a vareavel pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    /**
     * Metodo getEstado
     * @return Estado do cliente desejado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Metodo setEstado
     * @param estado atribui um valor a vareavel estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Metodo getCidade
     * @return Cidade do cliente desejado
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * Metodo setCidade
     * @param cidade atribui um valor a vareavel cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * Metodo getEmail
     * @return Email do cliente desejado
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo setEmail
     * @param email atribui um valor a vareavel email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo getTelefone
     * @return Telefone do cliente desejado
     */
    public String getTelefone() {
        return telefone;
    }
    /**
     * Metodo setTelefone
     * @param telefone atribui um valor a vareavel telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Metodo getLimitDeCredito
     * @return Limite de Crédito do cliente desejado
     */
    public float getLimiteDeCredito() {
        return limiteDeCredito;
    }
    /**
     * Metodo setLimiteDeCredito
     * @param limiteDeCredito atribui um valor a vareavel limiteDeCredito
     */
    public void setLimiteDeCredito(float limiteDeCredito) {
        this.limiteDeCredito = limiteDeCredito;
    }
}

