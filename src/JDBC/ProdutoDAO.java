package JDBC;

import Models.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProdutoDAO {
    Scanner sc = new Scanner(System.in);
    Scanner sca = new Scanner(System.in);
    public void adiciona(Produto produto) {
        try {
            String query = "INSERT INTO produto VALUES (null, '" + produto.getNome() + "', '" + produto.getDescricao() + "', '" + produto.getDataDeGarantia()+ "', '" + produto.getStatusDoProduto()+ "', '" + produto.getPrecoDeCusto() + "', '" + produto.getPrecoDeVenda() + "', '" + produto.getPrecoMinimoDeVenda() + "', '" +produto.getIdFornecedor()+"', '"+produto.getCategoria()+"')";
            ConnectionFactory.alterarBD(query);
            System.out.println("Produto salvo com sucesso.");
        }catch(SQLException e){
            System.err.println("Não foi possível adicionar o produto no Banco de dados");
        }
        long id = idProduto(produto);
        ProdutoNomeDAO produtoNomeDAO = new ProdutoNomeDAO();
        produtoNomeDAO.adiciona(produto, id);
        ProdutoDescricaoDAO produtoDescricaoDAO = new ProdutoDescricaoDAO();
        produtoDescricaoDAO.adiciona(produto, id);
        int opcao = -1;
        while (opcao != 2){
            System.out.println("" +
                    "|Deseja adicionar outro nome ao produto?" +
                    "\n|1 - Sim\n" +
                    "|2 - Não\n");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Digite o nome:");
                    produto.setNome(sca.nextLine());
                    produtoNomeDAO.adiciona(produto,id);
                    break;
                case 2:
                    ConnectionFactory.desconectar();
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
        int opcao2 = -1;
        while (opcao2 != 2){
            System.out.println("" +
                    "|Deseja adicionar outra descrição?" +
                    "\n|1 - Sim\n" +
                    "|2 - Não\n");
            opcao2 = sc.nextInt();
            switch (opcao2){
                case 1:
                    System.out.println("Digite a descrição:");
                    produto.setDescricao(sca.nextLine());
                    produtoDescricaoDAO.adiciona(produto,id);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }

    public void remove(long produto) {
        try{
            String query = "DELETE FROM produto WHERE id_produto = " + produto;
            ConnectionFactory.alterarBD(query);
            System.out.println("Produto salvo com sucesso.");
        }catch (SQLException e){
            System.err.println("Não foi possível remover o produto do Banco de dados");
        }
    }

    public void atualiza(Produto produto) {
        try {
            String query = "UPDATE produto SET id_produto ='"+ produto.getProdutoID()+"', categoria = '" + produto.getCategoria() + "', Fornecedor = '" + produto.getIdFornecedor() + "', Descricao = '" + produto.getDescricao() + "', Nome = '" + produto.getNome() + "', DataDeGarantia = '" + produto.getDataDeGarantia() + "', PrecoMinimoDeVenda = '" + produto.getPrecoMinimoDeVenda() + "', StatusDoPedido = '" + produto.getStatusDoProduto() + "' WHERE id_produto = " + produto.getProdutoID();
            ConnectionFactory.alterarBD(query);
            System.out.println("Produto salvo com sucesso.");
        }catch (SQLException e){
            System.out.println("Não foi possível atualizar a produto especificado");
        }
    }

    public void listar2() {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        ResultSet resultSet = null;
        Statement stm = null;
        connectionFactory.conectar();
        String query = "SELECT * FROM produto";
        ProdutoNomeDAO produtoNomeDAO = new ProdutoNomeDAO();
        ProdutoDescricaoDAO produtoDescricaoDAO = new ProdutoDescricaoDAO();
        stm = connectionFactory.criarStatement();
        try{
            resultSet = stm.executeQuery(query);
            while (resultSet.next()){
                System.out.println("Produto");
                System.out.println(resultSet.getLong("id_produto"));
                System.out.println(resultSet.getString("nome"));
                //produtoNomeDAO.listar2(resultSet.getLong("id_produto"));
                System.out.println(resultSet.getString("descricao"));
                //produtoDescricaoDAO.listar2(resultSet.getLong("id_produto"));
                System.out.println(resultSet.getString("data_garantia"));
                System.out.println(resultSet.getString("status"));
                System.out.println(resultSet.getString("preco_custo"));
                System.out.println(resultSet.getString("preco_venda"));
                System.out.println(resultSet.getString("preco_venda_min"));
                System.out.println("--------------");
            }
        }catch (SQLException e){
            System.out.println("Erro");
        }
    }

    public List<Produto> listar() {
        try {
            Connection bd = ConnectionFactory.getConexao();
            Statement stm = bd.createStatement();
            String query = "SELECT * FROM produto";
            try(ResultSet rs = stm.executeQuery(query)){
                List<Produto> produtos = new ArrayList<Produto>();
                while (rs.next()){
                    Produto produto = new Produto(rs.getInt("ProdutoID"), rs.getString("Nome"), rs.getString("Descricao"), rs.getDate("DataDeGarantia"), rs.getFloat("PrecoMinimoDeVenda"), rs.getString("StatusDoPedido"), rs.getInt("Categoria"), rs.getInt("Fornecedor"), rs.getFloat("PrecoDeCusto"), rs.getFloat("PrecoDeVenda"));
                    produtos.add(produto);
                }
                return produtos;
            }catch (SQLException e1){
                System.err.println("Falha ao tentar encontrar a tabela Produto");
            }
        }catch (SQLException e2){
            System.err.println("Não foi possível buscar os dados do banco");
        }
        return null;
    }
    public long idProduto(Produto produto) {
        long idProduto = 0;
        String query = "SELECT ID_PRODUTO FROM Produto WHERE Nome = '" + produto.getNome() + "' AND Descricao = '"+ produto.getDescricao() + "' AND Data_Garantia = '" + produto.getDataDeGarantia() + "' AND Status = '" + produto.getStatusDoProduto() + "' AND Preco_Custo = '" + produto.getPrecoDeCusto() + "' AND Preco_Venda = '" + produto.getPrecoDeVenda() + "'AND Preco_Venda_Min ='" + produto.getPrecoMinimoDeVenda() +"'AND ID_Fornecedor ='" + produto.getIdFornecedor() + "'AND ID_Categoria ='" + produto.getCategoria() + "' ;";
        ResultSet resultSet = null;
        Statement stm = null;
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.conectar();
        stm = connectionFactory.criarStatement();
        try {
            resultSet = stm.executeQuery(query);
            idProduto = resultSet.getLong("ID_Produto");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return idProduto;
    }

}