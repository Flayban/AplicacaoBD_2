package JDBC;

import Models.Fornecedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {

    public void adiciona(Fornecedor fornecedor) {
        try {
            String query = "INSERT INTO fornecedor VALUES (null, '" + fornecedor.getNome() + "', '" + fornecedor.getLocalidade() + "', '" + fornecedor.getTipoDeFornecedor()+ "', '" + fornecedor.getCpfCnpj() + "' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Fornecedor salvo com sucesso.");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o fornecedor no Banco de dados");
        }
    }

    public void remove(long fornecedor) {
        try{
            String query = "DELETE FROM fornecedor WHERE id_fornecedor = " + fornecedor;
            ConnectionFactory.alterarBD(query);
            System.out.println("Fornecedor removido com sucesso.");
        }catch (SQLException e){
            System.err.println("Não foi possível remover o fornecedor do Banco de dados");
        }
    }

    public void atualiza(Fornecedor fornecedor) {
        try {
            String query = "UPDATE fornecedor SET id_fornecedor ='"+ fornecedor.getFornecedorID()+"', nome = '" + fornecedor.getNome() + "', localidade = '" + fornecedor.getLocalidade() + "', Tipo = '" + fornecedor.getTipoDeFornecedor() + "', Documento = '" + fornecedor.getCpfCnpj() + "' WHERE id_fornecedor= " + fornecedor.getFornecedorID();
            ConnectionFactory.alterarBD(query);
            System.out.println("Fornecedor atualizado com sucesso.");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM fornecedor";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("fornecedor");
                System.out.println(resultSet.getLong("id_fornecedor"));
                System.out.println(resultSet.getString("nome"));
                System.out.println(resultSet.getString("localidade"));
                System.out.println(resultSet.getString("Tipo"));
                System.out.println(resultSet.getString("Documento"));
                System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

    public List<Fornecedor> listar() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM fornecedor";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
                while (rs.next()){
                    Fornecedor fornecedor = new Fornecedor(rs.getInt("FornecedorID"), rs.getString("Nome"), rs.getString("CpfCnpj"), rs.getString("TipoDeFornecedor"), rs.getString("Localidade"));
                    fornecedores.add(fornecedor);
                }
                return fornecedores;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Fornecedor");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }


}
