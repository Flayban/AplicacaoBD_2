package JDBC;

import Models.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClienteTelefoneDAO {
    public void adiciona(Cliente cliente, long idCliente) {
        try {
            String query = "INSERT INTO telefone_cliente VALUES ('" + idCliente + "', '" + cliente.getTelefone() +"' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Telefone salvo com sucesso");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o Telefone no Banco de dados");
        }
    }

    public void atualiza(Cliente cliente) {
        try {
            String query = "UPDATE armazem SET id_cliente ='"+ cliente.getClienteID() +"', telefone = '" + cliente.getTelefone() + "' WHERE id_cliente = " + cliente.getClienteID() ;
            ConnectionFactory.alterarBD(query);
            System.out.println("telefone atualizado com sucesso");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o telefone especificado");
        }
    }

    public void listar2(long idCliente) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT telefone FROM telefone_cliente WERE ID_cliente = '"+ idCliente+"'";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                //System.out.println("telefone_cliente");
                //System.out.println(resultSet.getLong("ID_cliente"));
                System.out.println(resultSet.getString("telefone"));
                //System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

}
