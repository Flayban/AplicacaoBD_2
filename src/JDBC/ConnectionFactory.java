package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *Classe responsavel por fabricar conexões entre o Codigo e o Banco de Dados
 * @author David Lucas Flayban dos Santos Melo
 */
public class ConnectionFactory {
    public static Connection conexao;

    //função para conectar ao banco de dados (ou criar se ele não existir)
    public static void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:src/Projeto_BD.db";
            conexao = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco SQLite estabelecida.");
        } catch (SQLException e1) {
            System.err.println(e1.getMessage());
        } catch (ClassNotFoundException e2){
            System.err.println("Falha ao utilizar o driver");
        }
    }

    public static void desconectar() {
        if (conexao == null)
            return;
        try{
            if (!conexao.isClosed()) {
                conexao.close();
                System.out.println("O banco SQLite foi desconectado!");
            }
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public static Connection getConexao() {
        try{
            if (conexao == null)
                conectar();
            if (conexao.isClosed())
                conectar();
        }catch (SQLException e){
            System.err.println("Não foi possível conectar com o banco de dados");
        }
        return conexao;
    }
    public static void alterarBD(String query) throws SQLException {
        Connection bd = ConnectionFactory.getConexao();
        Statement stm = bd.createStatement();
        stm.executeUpdate(query);
        stm.close();
    }

    public Statement criarStatement(){
        try {
            return this.conexao.createStatement();
        }catch (SQLException e){
            return null;
        }
    }

    public static void initBD(){
        try {
            conexao = getConexao();
            Statement stmAR = conexao.createStatement();
            stmAR.executeUpdate("DROP TABLE IF EXISTS Armazem");
            stmAR.executeUpdate("CREATE TABLE armazem (" + "ArmazemID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "nome TEXT NOT NULL," + "endereco TEXT NOT NULL," + "EstoqueID INTEGER FOREIGN KEY REFERENCES estoque.EstoqueID,");
            stmAR.executeUpdate("INSERT INTO Armazem VALUES (null, 'Armazem Garanhuns', 'Rua dos Guararapes', 1)");
            stmAR.executeUpdate("INSERT INTO Armazem VALUES (null, 'Armazem Caruaru', 'Rua Preta', 2)");
            stmAR.close();
            Statement stmCA = conexao.createStatement();
            stmCA.executeUpdate("DROP TABLE IF EXISTS categoria");
            stmCA.executeUpdate("CREATE TABLE categoria (" + "CategoriaID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "nome TEXT NOT NULL," + "descricao TEXT NOT NULL,");
            stmCA.executeUpdate("INSERT INTO categoria VALUES (null, 'Massa', 'Produtos a base de farinha')");
            stmCA.executeUpdate("INSERT INTO categoria VALUES (null, 'Carne vermelha', 'Tipos variados de carne vermelha')");
            stmCA.close();
            Statement stmCL = conexao.createStatement();
            stmCL.executeUpdate("DROP TABLE IF EXISTS cliente");
            stmCL.executeUpdate("CREATE TABLE cliente (" + "ClienteID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "nome TEXT NOT NULL," + "dataDeNascimento DATE NOT NULL," + "pais TEXT NOT NULL," + "estado TEXT NOT NULL," + "cidade TEXT NOT NULL," + "email TEXT NOT NULL," + "telefone TEXT NOT NULL," + "limiteDeCredito FLOAT NOT NULL,");
            stmCL.executeUpdate("INSERT INTO cliente VALUES (null, 'Ivan', 15/10/2000, 'Brasil', 'Pernambuco', 'Garanhunhs', 'ivan@ivan.com', '87995053333', 500.0)");
            stmCL.executeUpdate("INSERT INTO cliente VALUES (null, 'Kaio', 06/12/1999, 'Brasil', 'Pernambuco', 'Garanhunhs', 'kaio@kaio.com', '87995056666', 500.0)");
            stmCL.close();
            Statement stmES = conexao.createStatement();
            stmES.executeUpdate("DROP TABLE IF EXISTS estoque");
            stmES.executeUpdate("CREATE TABLE estoque (" + "EstoqueID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "ProdutoID INTEGER FOREIGN KEY REFERENCES produto.getProdutoID," + "ArmazemID INTEGER FOREIGN KEY REFERENCES armazem.ArmazemID," + "quantidade INTEGER NOT NULL," + "codigo INTEGER NOT NULL UNIQUE,");
            stmES.executeUpdate("INSERT INTO estoque VALUES (null, 1, 1, 10, 100)");
            stmES.executeUpdate("INSERT INTO estoque VALUES (null, 2, 1, 15, 101)");
            stmES.close();
            Statement stmFO = conexao.createStatement();
            stmFO.executeUpdate("DROP TABLE IF EXISTS fornecedor");
            stmFO.executeUpdate("CREATE TABLE fornecedor (" + "FornecedorID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "nome TEXT NOT NULL," + "cpfCnpj TEXT NOT NULL," + "tipoDeFornecedor TEXT NOT NULL," + "localidade TEXT NOT NULL,");
            stmFO.executeUpdate("INSERT INTO fornecedor VALUES (null, 'Edgard', 15638755601, 'Vitarela', 'Pernambuco')");
            stmFO.executeUpdate("INSERT INTO fornecedor VALUES (null, 'Ewerthon', 17652588426, 'Friboi', 'Pernambuco')");
            stmFO.close();
            Statement stmPE = conexao.createStatement();
            stmPE.executeUpdate("DROP TABLE IF EXISTS pedido");
            stmPE.executeUpdate("CREATE TABLE pedido (" + "PedidoID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "ProdutoID INTEGER NOT NULL FOREIGN KEY REFERENCES produto.ProdutoID," + "ClienteID INTEGER NOT NULL FOREIGN KEY REFERENCES cliente.ClienteID," + "dataDoPedido DATE NOT NULL," + "dataDoPrazoDeEntrega DATE NOT NULL," + "modoDeEncomenda TEXT NOT NULL," + "statusDoPedido TEXT NOT NULL,");
            stmPE.executeUpdate("INSERT INTO pedido VALUES (null, 1, 2, 20/03/2023, 22/03/2023, 'Delivery', 'Entregue')");
            stmPE.executeUpdate("INSERT INTO pedido VALUES (null, 2, 2, 21/03/2023, 23/03/2023, 'Delivery', 'Entregue'");
            stmPE.close();
            Statement stmPRO = conexao.createStatement();
            stmPRO.executeUpdate("DROP TABLE IF EXISTS produto");
            stmPRO.executeUpdate("CREATE TABLE produto (" + "ProdutoID INTEGER NOT NULL UNIQUE PRIMARY KEY AUTOINCREMENT," + "CategoriaID INTEGER NOT NULL FOREIGN KEY REFERENCES categoria.CategoriaID," + "FornecedorID INTEGER NOT NULL FOREIGN KEY REFERENCES fornecedor.FornecedorID," + "descricao TEXT NOT NULL," + "nome TEXT NOT NULL," + "dataDeGarantia DATE NOT NULL," + "precoMinimoDeVenda FLOAT NOT NULL," + "statusDoPedido TEXT NOT NULL");
            stmPRO.executeUpdate("INSERT INTO produto VALUES (null, 1, 1, 'Massa de macarrão pronta', 'Espaguete vitarela', 30/12/2023, 3.50, '87995053333', 'Estoque')");
            stmPRO.executeUpdate("INSERT INTO produto VALUES (null, 2, 2, 'Brasil', 'Picanha bovinha', 'Picanha friboi', 30/04/2023, 50.0, 'Estoque')");
            stmPRO.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
