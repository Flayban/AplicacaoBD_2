package JDBC;

import Models.Cliente;
import Models.Pedido;
import Models.ProdutoPedido;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static JDBC.ConnectionFactory.conexao;

public class ProdutoPedidoDAO {

    public void adicionar(Pedido pedido, long idPedido) throws SQLException {

        String sql = "INSERT INTO ProdutoPedido(Id_Produto, Id_Pedido, preco_venda_produto, quantidade) " +
                "VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, pedido.getIdProduto());
        stmt.setLong(2, idPedido);
        stmt.setDouble(3, precoVenda(pedido.getIdProduto()));
        stmt.setInt(4, quantidade(idPedido));


        stmt.executeUpdate();
    }

    public void atualizar(Pedido pedido, long idPedido) throws SQLException {

        String sql = "UPDATE ProdutoPedido SET preco_venda = ?, quantidade = ? " +
                "WHERE Id_Produto = ? AND Id_Pedido = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, pedido.getIdProduto());
        stmt.setLong(2, idPedido);
        stmt.setDouble(3, precoVenda(pedido.getIdProduto()));
        stmt.setInt(4, quantidade(idPedido));

        stmt.executeUpdate();
    }

    public void remover(long id_Produto, long id_Pedido) throws SQLException {

        String sql = "DELETE FROM ProdutoPedido WHERE Id_Produto = ? AND Id_Pedido = ?";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setLong(1, id_Produto);
        stmt.setLong(2, id_Pedido);

        stmt.executeUpdate();
    }

    public List<ProdutoPedido> listar() throws SQLException {

        String sql = "SELECT * FROM ProdutoPedido";
        PreparedStatement stm = conexao.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<ProdutoPedido> listaProdutoPedido = new ArrayList<>();

        while (rs.next()) {
            long id_Produto = rs.getLong("produtoID");
            long id_Pedido = rs.getLong("pedidoID");
            double preco_venda_produto = rs.getDouble("preco_venda_produto");
            int quantidade = rs.getInt("quantidade");
            ProdutoPedido produtoPedido = new ProdutoPedido(id_Produto, id_Pedido, preco_venda_produto, quantidade);
            listaProdutoPedido.add(produtoPedido);
        }

        return listaProdutoPedido;
    }

    public float precoVenda(long idProduto){

        float preco = 0;
        String query = "SELECT preco_venda FROM produto WHERE id_produto = '"+idProduto+"' ;";
        ResultSet resultSet = null;
        Statement stm = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.conectar();
        stm = connectionFactory.criarStatement();
        try {
            resultSet = stm.executeQuery(query);
            preco = resultSet.getFloat("preco_venda");
            //System.out.println(preco);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return preco;
    }

    public int quantidade(long idPedido){
        int quantidade = 0;
        String query = "SELECT count(id_pedido) FROM pedido WHERE id_pedido = '"+idPedido+"' ;";
        ResultSet resultSet = null;
        Statement stm = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.conectar();
        stm = connectionFactory.criarStatement();
        try {
            resultSet = stm.executeQuery(query);
            quantidade = resultSet.getInt("count(id_pedido)");
            //System.out.println(preco);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return quantidade;

    }
}