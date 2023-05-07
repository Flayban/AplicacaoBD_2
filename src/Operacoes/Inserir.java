package Operacoes;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import  JDBC.*;
import  Models.*;

public class Inserir {
        Scanner sc = new Scanner(System.in);
        Scanner sca = new Scanner(System.in);
    public Inserir(int opcao) throws SQLException {

        switch (opcao) {
            case 1: //Funcionando
                System.out.println("Informe os dados do Armazém:\n");
                System.out.println("\nEndereço");
                String enderecoA = sc.nextLine();

                System.out.println("\nCódigo:");
                String codigoA = sc.nextLine();

                Armazem armazem = new Armazem(enderecoA, codigoA);
                ArmazemDAO daoA = new ArmazemDAO();
                daoA.adiciona(armazem);
                break;

            case 2: //Funcionando
                System.out.println("Informe os dados da Categoria:\n");
                System.out.println("\nNome: ");
                String nomeCa = sca.nextLine();

                System.out.println("\nDescrição: ");
                String descricaoCa = sc.nextLine();

                Categoria categoria = new Categoria(nomeCa, descricaoCa);
                CategoriaDAO daoCa = new CategoriaDAO();
                daoCa.adiciona(categoria);
                break;

            case 3: //funcionando
                System.out.println("Informe os dados do Cliente:\n");
                System.out.println("\nNome:");
                String nomeCli = sc.nextLine();

                System.out.println("\nData de Cadastro:");
                String dataNascimentoCli = sc.nextLine();
                DateFormat formatCli = new SimpleDateFormat("d-MM-yyyy");
                Date dateCli = null;
                try {
                    dateCli = formatCli.parse(dataNascimentoCli);
                    System.out.println(dateCli);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\nPais:");
                String paisCli = sc.nextLine();

                System.out.println("\nEstado:");
                String estadoCli = sc.nextLine();

                System.out.println("\nCidade:");
                String cidadeCli = sc.nextLine();

                System.out.println("\nEmail:");
                String emailCli = sc.nextLine();

                System.out.println("\nTelefone:");
                String telefoneCli = sc.nextLine();

                System.out.println("\nLimite de Crédito:");
                float limiteDeCreditoCli = sca.nextFloat();

                Cliente cliente = new Cliente(nomeCli, paisCli, estadoCli, cidadeCli, emailCli, telefoneCli, limiteDeCreditoCli, dateCli);
                ClienteDAO daoCli = new ClienteDAO();

                daoCli.adiciona(cliente);

                break;

            case 4: //Funcionando
                System.out.println("Informe os dados do Estoque:\n");

                System.out.println("\nCodigo:");
                String codigoE = sc.nextLine();

                System.out.println("\nQuantidade:");
                int quantidadeEs = sc.nextInt();

                System.out.println("\nID do armazem:");
                ArmazemDAO daoAE = new ArmazemDAO();
                daoAE.listar2();
                long idArmazem = sc.nextLong();

                System.out.println("\nID do Produto:");
                ProdutoDAO daoPE = new ProdutoDAO();
                daoPE.listar2();
                long idProduto = sc.nextLong();

                EstoqueDAO daoE = new EstoqueDAO();
                Estoque estoque = new Estoque(codigoE, quantidadeEs, idArmazem, idProduto);
                daoE.adiciona(estoque);
                break;

            case 5: // funcionando
                System.out.println("Informe os dados do Fornecedor:\n");
                System.out.println("\nNome: ");
                String nomeF = sc.nextLine();

                System.out.println("\nCPF ou CNPJ: ");
                String cpfCnpjF = sc.nextLine();

                System.out.println("\nTipo de fornecedor: ");
                String tipoDeFornecedorF = sc.nextLine();

                System.out.println("\nLocalidade: ");
                String localidadeF = sc.nextLine();
                Fornecedor fornecedor = new Fornecedor(nomeF,localidadeF,tipoDeFornecedorF,cpfCnpjF);
                FornecedorDAO daoF = new FornecedorDAO();
                daoF.adiciona(fornecedor);
                break;

            case 6: //Funcionando
                System.out.println("Informe os dados do Pedido:\n");

                System.out.println("\nData do pedido: d-MM-yyyy");
                String dataPedidoPe = sc.next();
                DateFormat formatPedidoPe = new SimpleDateFormat("d-MM-yyyy");
                Date datePedidoPe = null;
                try {
                    datePedidoPe = formatPedidoPe.parse(dataPedidoPe);
                    System.out.println(datePedidoPe);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\nData do prazo de entrega: d-MM-yyyy");
                String prazoEntregaPe = sc.next();
                DateFormat formatEntregaPe = new SimpleDateFormat("d-MM-yyyy");
                Date datePrazoEntregaPe = null;
                try {
                    datePrazoEntregaPe  = formatEntregaPe.parse(prazoEntregaPe);
                    System.out.println(datePrazoEntregaPe );
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\nStatus do pedido:");
                String statusPe = sca.nextLine();

                System.out.println("\nModo de Encomenda:");
                String modoEncomendaPe = sca.nextLine();

                System.out.println("\nID do Cliente:");
                ClienteDAO daoCliPe = new ClienteDAO();
                daoCliPe.listar2();
                long idClientePe = sc.nextLong();

                System.out.println("\nID do Produto:");
                ProdutoDAO daoProPe = new ProdutoDAO();
                daoProPe.listar2();
                long idProdutoPe = sc.nextLong();

                Pedido pedido = new Pedido(idProdutoPe,idClientePe,datePedidoPe, datePrazoEntregaPe, modoEncomendaPe, statusPe);
                PedidoDAO daoPe = new PedidoDAO();
                daoPe.adiciona(pedido);
                break;

            case 7: //Funcionando
                System.out.println("Informe os dados do Produto:\n");

                System.out.println("\nNome:");
                String nomePro = sc.nextLine();
                System.out.println("\nDescrição:");
                String descricaoPro = sc.nextLine();

                System.out.println("\nData de garantia: DD-MMMM-AAAA");
                String datagarantiaPro = sc.nextLine();
                DateFormat formatPro = new SimpleDateFormat("d-MM-yyyy");
                Date datePro = null;
                try {
                    datePro = formatPro.parse(datagarantiaPro);
                    System.out.println(datePro);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\nPreço de Custo:");
                float precoDeCustoPro = sc.nextFloat();

                System.out.println("\nPreço de Venda:");
                float precoDeVendaPro = sc.nextFloat();

                System.out.println("\nPreço minimo de venda:");
                float precoMinimoDeVendaPro = sc.nextFloat();

                System.out.println("\nStatus do produto:");
                String statusPro = sca.nextLine();

                System.out.println("\nID do Fornecedor:");
                FornecedorDAO daoFPro = new FornecedorDAO();
                daoFPro.listar2();
                long idFornecedorPro = sc.nextLong();

                System.out.println("\nID da Categoria:");
                CategoriaDAO daoCPro = new CategoriaDAO();
                daoCPro.listar2();
                long idCategoriaPro = sc.nextLong();

                Produto produto = new Produto(nomePro, descricaoPro, datePro , precoMinimoDeVendaPro, statusPro, idCategoriaPro, idFornecedorPro, precoDeVendaPro, precoDeCustoPro);
                ProdutoDAO daoPro = new ProdutoDAO();
                daoPro.adiciona(produto);
                break;

            default:
                System.out.println("Opção invalida");
                break;
        }
    }
}
