package Operacoes;

import JDBC.*;
import Models.Estoque;

import java.util.Scanner;

public class Remover {
    Scanner sc = new Scanner(System.in);
    public Remover(int opcao){
        switch (opcao){
            case 1:
                ArmazemDAO daoAr = new ArmazemDAO();
                daoAr.listar2();
                System.out.println("Informe o ID do Armazem para ser removido:");
                daoAr.remove(sc.nextLong());
                break;
            case 2:
                CategoriaDAO daoCa =  new CategoriaDAO();
                daoCa.listar2();
                System.out.println("Informe o ID da Categoria para ser removido:");
                daoCa.remove(sc.nextLong());
                break;
            case 3:
                ClienteDAO clienteDAO = new ClienteDAO();
                clienteDAO.listar2();
                System.out.println("Informe o ID do Cliente para ser removido:");
                clienteDAO.remove(sc.nextLong());
                break;
            case 4:
                EstoqueDAO estoqueDAO = new EstoqueDAO();
                estoqueDAO.listar2();
                System.out.println("Informe o ID do Estoque para ser removido:");
                estoqueDAO.remove(sc.nextLong());
                break;
            case 5:
                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                fornecedorDAO.listar2();
                System.out.println("Informe o ID do Fornecedor para ser removido:");
                fornecedorDAO.remove(sc.nextLong());
                break;
            case 6:
                PedidoDAO pedidoDAO = new PedidoDAO();
                pedidoDAO.listar2();
                System.out.println("Informe o ID do Pedido para ser removido:");
                pedidoDAO.remove(sc.nextLong());
                break;
            case 7:
                ProdutoDAO produtoDAO = new ProdutoDAO();
                produtoDAO.listar2();
                System.out.println("Informe o ID do Produto para ser removido:");
                produtoDAO.remove(sc.nextLong());
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
    }
}
