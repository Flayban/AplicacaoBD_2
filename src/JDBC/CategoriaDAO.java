package JDBC;

import Models.Categoria;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void adiciona(Categoria categoria) {
        try {
            String query = "INSERT INTO categoria VALUES (null, '" + categoria.getNome() + "', '" + categoria.getDescricao() + "' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Categoria salva com sucesso.");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar a categoria no Banco de dados");
        }
    }

    public void remove(long idCategoria) {
        try{
            String query = "DELETE FROM categoria WHERE id_categoria = " + idCategoria;
            ConnectionFactory.alterarBD(query);
            System.out.println("Categoria removida com sucesso.");
        }catch (SQLException e){
            System.err.println("Não foi possível remover a categoria do Banco de dados");
        }
    }

    public void atualiza(Categoria categoria) {
        try {
            String query = "UPDATE categoria SET id_categoria ='"+ categoria.getCategoriaID()+"', nome = '" + categoria.getNome() + "', descricao = '" + categoria.getDescricao() + "' WHERE id_categoria = " + categoria.getCategoriaID();
            ConnectionFactory.alterarBD(query);
            System.out.println("Categoria atualizada com sucesso.");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a categoria especificado");
        }
    }
    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM categoria";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("Categorias");
                System.out.println(resultSet.getLong("id_categoria"));
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("descricao"));
                System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

    public List<Categoria> listar() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM categoria";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Categoria> categorias = new ArrayList<Categoria>();
                while (rs.next()){
                    Categoria categoria = new Categoria(rs.getInt("CategoriaID"), rs.getString("Nome"), rs.getString("Descricao"));
                    categorias.add(categoria);
                }
                return categorias;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Categoria");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
}
