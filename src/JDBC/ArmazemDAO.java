package JDBC;

import Models.Armazem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ArmazemDAO {

    public void adiciona(Armazem armazem) {
        try {
            String query = "INSERT INTO armazem VALUES (null, '" + armazem.getEndereco() + "', '" + armazem.getCodigo() + "' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Armazém salvo com sucesso");
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    public void remove(long idArmazem) {
        try{
            String query = "DELETE FROM armazem WHERE id_armazem = " + idArmazem;
            ConnectionFactory.alterarBD(query);
            System.out.println("Armazém removido com sucesso");
        }catch (SQLException e){
            System.err.println("Não foi possível remover o armazém do Banco de dados");
        }
    }

    public void atualiza(Armazem armazem) {
        try {
            String query = "UPDATE armazem SET id_armazem ='"+ armazem.getArmazemID() +"', endereco = '" + armazem.getEndereco() + "', codigo = '" + armazem.getCodigo()  + "' WHERE id_armazem = " + armazem.armazemID;
            ConnectionFactory.alterarBD(query);
            System.out.println("Armazém atualizado com sucesso");
        }catch (SQLException e){
            System.err.println("Não foi possível atualizar o armazém especificado");
        }
    }

    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM armazem";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("Armazem");
                System.out.println(resultSet.getLong("ID_Armazem"));
                System.out.println(resultSet.getString("Endereco"));
                System.out.println(resultSet.getString("Codigo"));
                System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

    public List<Armazem> busca() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM armazem";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Armazem> armazems = new ArrayList<Armazem>();
                while (rs.next()){
                    Armazem armazem = new Armazem(rs.getInt("ArmazemID"), rs.getString("Endereco"), rs.getString("Codigo"));
                    armazems.add(armazem);
                }
                return armazems;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Armazém");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
}
