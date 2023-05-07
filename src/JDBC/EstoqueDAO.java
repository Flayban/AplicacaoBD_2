package JDBC;

import Models.Estoque;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EstoqueDAO {

    public void adiciona(Estoque estoque) {
        try {
            String query = "INSERT INTO estoque VALUES (null, '" + estoque.getCodigo() + "', '" + estoque.getQuantidade()  + "', '" + estoque.getIdArmazem() + "', '" + estoque.getIdProduto()  + "' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Estoque salvo com sucesso");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o estoque no Banco de dados");
        }
    }

    public void remove(long estoque) {
        try{
            String query = "DELETE FROM estoque WHERE id_estoque = " + estoque;
            ConnectionFactory.alterarBD(query);
            System.out.println("Estoque removido com sucesso");
        }catch (SQLException e){
            System.err.println("Não foi possível remover o estoque do Banco de dados");
        }
    }

    public void atualiza(Estoque estoque) {
        try {
            String query = "UPDATE estoque SET id_estoque ='"+ estoque.getEstoqueID()+"', codigo = '" + estoque.getCodigo() + "', quantidade = '" + estoque.getQuantidade() + "', armazem = '" + estoque.getIdArmazem() + "', produto = '" + estoque.getIdProduto() + "' WHERE id_estoque = " + estoque.getEstoqueID();
            ConnectionFactory.alterarBD(query);
            System.out.println("Estoque atualizado com sucesso");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o estoque especificado");
        }
    }

    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM estoque";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("fornecedor");
                System.out.println(resultSet.getLong("id_estoque"));
                System.out.println(resultSet.getString("codigo"));
                System.out.println(resultSet.getString("quantidade"));
                System.out.println(resultSet.getString("id_armazem"));
                System.out.println(resultSet.getString("id_produto"));
                System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

    public List<Estoque> busca() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM estoque";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Estoque> estoques = new ArrayList<Estoque>();
                while (rs.next()){
                    Estoque estoque = new Estoque(rs.getInt("EstoqueID"), rs.getString("Codigo"), rs.getInt("Quantidade"), rs.getLong("ID_Armazem"), rs.getInt("ID_Produto"));
                    estoques.add(estoque);
                }
                return estoques;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Estoque");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
}
