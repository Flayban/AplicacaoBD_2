package main;
import JDBC.*;
import Operacoes.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        ConnectionFactory conectar = new ConnectionFactory();
        conectar.conectar();


        int opcao = -1;
        while (opcao != 0){
            System.out.println("" +
                    "|Determine qual operação você deseja realizar no banco de dados:\n" +
                    "| 1 - Inserir novo dado\n" +
                    "| 2 - Atualizar dado ja existente\n" +
                    "| 3 - Remover dado\n" +
                    "| 0 - Finalizar codigo\n ");
            opcao = sc.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("" +
                            "|Será inseriodo qual informação?\n" +
                            "| 1 - Armazém\n" +
                            "| 2 - Categoria\n" +
                            "| 3 - Cliente\n" +
                            "| 4 - Estoque\n" +
                            "| 5 - Fornecedor\n" +
                            "| 6 - Pedido\n" +
                            "| 7 - Produto\n");
                  Inserir op1 = new Inserir(sc.nextInt());
                    break;

                case 2:
                    System.out.println("" +
                            "|Será atualizado qual informação?\n" +
                            "| 1 - Armazém\n" +
                            "| 2 - Categoria\n" +
                            "| 3 - Cliente\n" +
                            "| 4 - Estoque\n" +
                            "| 5 - Fornecedor\n" +
                            "| 6 - Pedido\n" +
                            "| 7 - Produto\n");
                    Atualizar op2 = new Atualizar(sc.nextInt());
                    break;

                case 3:
                    System.out.println("" +
                            "|Será removido qual informação?\n" +
                            "| 1 - Armazém\n" +
                            "| 2 - Categoria\n" +
                            "| 3 - Cliente\n" +
                            "| 4 - Estoque\n" +
                            "| 5 - Fornecedor\n" +
                            "| 6 - Pedido\n" +
                            "| 7 - Produto\n");
                    Remover op3 = new Remover(sc.nextInt());
                    break;
                case 0:
                    break;
                default:
                    System.out.println("| Opção invalida |");
                    break;
            }
        }

        conectar.desconectar();
    }

}
