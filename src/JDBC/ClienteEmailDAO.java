package JDBC;

import Models.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteEmailDAO {
    public void adiciona(Cliente cliente, long idCliente) {
        try {
            String query = "INSERT INTO email_cliente VALUES ('" + idCliente + "', '" + cliente.getEmail() +"' )";
            ConnectionFactory.alterarBD(query);
            System.out.println("Email salvo com sucesso");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o Telefone no Banco de dados");
        }
    }

    public void atualiza(Cliente cliente) {
        try {
            String query = "UPDATE armazem SET id_cliente ='"+ cliente.getClienteID() +"', email = '" + cliente.getEmail() + "' WHERE id_cliente = " + cliente.getClienteID() ;
            ConnectionFactory.alterarBD(query);
            System.out.println("Email atualizado com sucesso");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar o email especificado");
        }
    }

    public void listar2(long idCliente) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT email FROM email_cliente WERE ID_cliente = '"+ idCliente+"'";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                //System.out.println("email_cliente");
                //System.out.println(resultSet.getLong("ID_cliente"));
                System.out.println(resultSet.getString("email"));
                //System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }
}
