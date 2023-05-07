package JDBC;

import Models.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoNomeDAO {
    public void adiciona(Produto produto, long idProduto) {
        try {
            String query = "INSERT INTO produto_nome VALUES ('" + idProduto + "', '" + produto.getNome() +"' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Nome salvo com sucesso");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o Nome no Banco de dados");
        }
    }

    public void atualiza(Produto produto) {
        try {
            String query = "UPDATE produto_nome SET id_produto ='"+ produto.getProdutoID() +"', nome = '" + produto.getNome() + "' WHERE id_produto = " + produto.getProdutoID();
            ConnectionFactory.alterarBD(query);
            System.out.println("Nome atualizado com sucesso");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o nome especificado");
        }
    }

    public void listar2(long idProduto) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT descricao FROM produto_descricao WERE ID_produto = '"+ idProduto+"'";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
               // System.out.println("produto_nome");
               // System.out.println(resultSet.getLong("ID_produto"));
                System.out.println(resultSet.getString("nome"));
               // System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }
}