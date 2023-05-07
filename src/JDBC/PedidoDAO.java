package JDBC;

import Models.Cliente;
import Models.Pedido;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

    public void adiciona(Pedido pedido) throws SQLException {
        try {
            String query = "INSERT INTO pedido VALUES (null, '" + pedido.getDataDoPedido() + "', '" + pedido.getModoDeEncomenda() + "', '" + pedido.getStatusDoPedido()+ "', '" + pedido.getDataDePrazoDaEntrega()+ "', '" + pedido.getIdCliente() + "', '" + pedido.getIdProduto() + "' )";
            ConnectionFactory.alterarBD(query);
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o pedido no Banco de dados");
        }
        ProdutoPedidoDAO produtoPedidoDAO = new ProdutoPedidoDAO();
        produtoPedidoDAO.adicionar(pedido, idPedido(pedido));
    }


    public void remove(long pedido) {
        try{
            String query = "DELETE FROM pedido WHERE id_pedido = " + pedido;
            ConnectionFactory.alterarBD(query);
        }catch (SQLException e){
            System.err.println("Não foi possível remover o pedido do Banco de dados");
        }
    }


    public void atualiza(Pedido pedido) {
        try {
            String query = "UPDATE pedido SET id_pedido ='"+ pedido.getPedidoID()+"', ID_Produto = '" + pedido.getIdProduto() + "', ID_Cliente = '" + pedido.getIdCliente() + "', Data = '" + pedido.getDataDoPedido() + "', Prazo_Entrega = '" + pedido.getDataDePrazoDaEntrega() + "', Modo_Encomenda = '" + pedido.getModoDeEncomenda() + "', Status = '" + pedido.getStatusDoPedido() + "' WHERE id_pedido = " + pedido.getPedidoID();
            ConnectionFactory.alterarBD(query);
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar  pedido especificado");
        }
    }

    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM pedido";

        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("Pedido");
                System.out.println(resultSet.getLong("id_pedido"));
                System.out.println(resultSet.getString("data"));
                System.out.println(resultSet.getString("Modo_Encomenda"));
                System.out.println(resultSet.getString("Status"));
                System.out.println(resultSet.getString("Prazo_Entrega"));
                System.out.println(resultSet.getString("ID_Cliente"));
                System.out.println(resultSet.getString("ID_Produto"));
                System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

    public List<Pedido> busca() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM pedido";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Pedido> pedidos = new ArrayList<Pedido>();
                while (rs.next()){
                    Pedido pedido = new Pedido(rs.getInt("PedidoID"), rs.getInt("ID_Produto"), rs.getInt("ID_Cliente"), rs.getDate("Data"), rs.getDate("Prazo_Entrega"), rs.getString("Modo_Encomenda"), rs.getString("Status"));
                    pedidos.add(pedido);
                }
                return pedidos;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Pedido");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
    public long idPedido(Pedido pedido) {
        long idPedido = 0;
        String query = "SELECT ID_Pedido FROM pedido WHERE Date = '"+pedido.getDataDoPedido()+"' AND Modo_Encomenda = '"+pedido.getModoDeEncomenda()+"' AND Status = '"+pedido.getStatusDoPedido()+"' AND Prazo_Entrega = '"+pedido.getDataDePrazoDaEntrega()+"' AND ID_Cliente = '"+pedido.getIdCliente()+"' AND ID_Produto = '"+pedido.getIdProduto()+"' ;";
        ResultSet resultSet = null;
        Statement stm = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.conectar();
        stm = connectionFactory.criarStatement();
        try {
            resultSet = stm.executeQuery(query);
            idPedido = resultSet.getLong("id_pedido");
            //System.out.println(idPedido);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return idPedido;
    }
}
