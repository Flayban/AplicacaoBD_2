package JDBC;

import Models.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClienteDAO {
    Scanner sc = new Scanner(System.in);

    public void adiciona(Cliente cliente) {
        try {
            String query = "INSERT INTO cliente VALUES (null, '" + cliente.getNome() + "', '" + cliente.getPais() + "', '" + cliente.getEstado() + "', '" + cliente.getCidade() + "', '" + cliente.getLimiteDeCredito() + "', '" + cliente.getDataDeCadastro() + "' )";

            ConnectionFactory.alterarBD(query);

        } catch (SQLException e) {
            System.err.println("Não foi possível adicionar o cliente no Banco de dados");
        }
        long id = idCliente(cliente);
        ClienteEmailDAO clienteEmailDAO = new ClienteEmailDAO();
        clienteEmailDAO.adiciona(cliente,id);
        ClienteTelefoneDAO clienteTelefoneDAO = new ClienteTelefoneDAO();
        clienteTelefoneDAO.adiciona(cliente,id);
        int opcao = -1;
        while (opcao != 2){
            System.out.println("" +
                    "|Deseja adicionar outro Email?" +
                    "\n|1 - Sim\n" +
                    "|2 - Não\n");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite seu Email:");
                    cliente.setEmail(sc.next());
                    clienteEmailDAO.adiciona(cliente,id);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        int opcao2 = -1;
        while (opcao2 != 2){
            System.out.println("" +
                    "|Deseja adicionar outro Telefone?" +
                    "\n|1 - Sim\n" +
                    "|2 - Não\n");
            opcao2 = sc.nextInt();
            switch (opcao2){
                case 1:
                    System.out.println("Digite seu Telefone:");
                    cliente.setTelefone(sc.next());
                    clienteTelefoneDAO.adiciona(cliente,id);
                    break;
                case 2:
                    ConnectionFactory.desconectar();
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }


    public void remove(long cliente) {
        try {
            String query = "DELETE FROM cliente WHERE id_cliente = " + cliente;
            ConnectionFactory.alterarBD(query);
        } catch (SQLException e) {
            System.err.println("Não foi possível remover o cliente do Banco de dados");
        }
    }


    public void atualiza(Cliente cliente) {
        try {
            String query = "UPDATE cliente SET id_cliente ='" + cliente.getClienteID() + "',nome = '" + cliente.getNome() + "', DataDeNascimento = '" + cliente.getDataDeCadastro() + "', Pais = '" + cliente.getPais() + "', Estado = '" + cliente.getEstado() + "', Cidade = '" + cliente.getCidade() + "', LimiteDeCredito = '" + cliente.getLimiteDeCredito() + "' WHERE id_cliente = " + cliente.getClienteID();
            ConnectionFactory.alterarBD(query);
            ClienteTelefoneDAO clienteTelefoneDAO = new ClienteTelefoneDAO();
            ClienteEmailDAO clienteEmailDAO = new ClienteEmailDAO();
            clienteEmailDAO.atualiza(cliente);
            clienteTelefoneDAO.atualiza(cliente);
        } catch (SQLException e) {
            System.out.println("Não foi possível atualizar a cliente especificado");
        }
    }

    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM cliente";
        ClienteEmailDAO clienteEmailDAO = new ClienteEmailDAO();
        ClienteTelefoneDAO clienteTelefoneDAO = new ClienteTelefoneDAO();

        stm = connectionFactory.criarStatement();
        try {
            resultSet = stm.executeQuery(query);
            while (resultSet.next()) {
                System.out.println("Cliente");
                System.out.println(resultSet.getLong("id_cliente"));
                System.out.println(resultSet.getString("Nome:"));
                System.out.println(resultSet.getString("Pais:"));
                System.out.println(resultSet.getString("Estado:"));
                System.out.println(resultSet.getString("Cidade:"));
                System.out.println(resultSet.getString("Limite_Credito:"));
                System.out.println(resultSet.getString("Data_Cadastro:"));
                //clienteEmailDAO.listar2(resultSet.getLong("id_cliente"));
                //clienteTelefoneDAO.listar2(resultSet.getLong("id_cliente"));
                System.out.println("--------------");
            }
        } catch (SQLException e) {
            System.out.println("Erro");
        }
        connectionFactory.desconectar();
    }

    public List<Cliente> busca() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM cliente";
            try (ResultSet rs = stm.executeQuery(query)) {
                List<Cliente> clientes = new ArrayList<Cliente>();
                while (rs.next()) {
                    Cliente cliente = new Cliente(rs.getInt("ClienteID"), rs.getString("Nome"), rs.getString("Pais"), rs.getString("Estado"), rs.getString("Cidade"), rs.getString("Email"), rs.getString("Telefone"), rs.getFloat("LimiteDeCredito"), rs.getDate("DataDeCadastro"));
                    clientes.add(cliente);
                }
                return clientes;
            } catch (SQLException e1) {
                System.err.println("Falha ao tentar encontrar a tabela Cliente");
            }
        } catch (SQLException e2) {
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }

    public long idCliente(Cliente cliente) {
        long idCliente = 0;
        String query = "SELECT ID_Cliente FROM Cliente WHERE Nome = '"+cliente.getNome()+"' AND Pais = '"+cliente.getPais()+"' AND Estado = '"+cliente.getEstado()+"' AND Cidade = '"+cliente.getCidade()+"' AND Limite_Credito = '"+cliente.getLimiteDeCredito()+"' AND Data_Cadastro = '"+cliente.getDataDeCadastro()+"' ;";
        ResultSet resultSet = null;
        Statement stm = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.conectar();
        stm = connectionFactory.criarStatement();
        try {
            resultSet = stm.executeQuery(query);
            idCliente = resultSet.getLong("id_cliente");
            System.out.println(idCliente);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return idCliente;
    }
}