package JDBC;

import Models.Produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProdutoDescricaoDAO {
    public void adiciona(Produto produto, long id_Produto) {
        try {
            String query = "INSERT INTO produto_descricao VALUES ('" + id_Produto + "', '" + produto.getDescricao() +"' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Descrição salva com sucesso");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar a Descrição no Banco de dados");
        }
    }

    public void atualiza(Produto produto) {
        try {
            String query = "UPDATE produto_descricao SET id_produto ='"+ produto.getProdutoID() +"', descricao = '" + produto.getDescricao() + "' WHERE id_produto = " + produto.getProdutoID();
            ConnectionFactory.alterarBD(query);
            System.out.println("Descrição atualizada com sucesso");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a descrição especificado");
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
                //System.out.println("produto_descricao");
                System.out.println(resultSet.getString("descricao"));
                //System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }
}
