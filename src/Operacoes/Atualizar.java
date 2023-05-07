package Operacoes;

import JDBC.*;
import Models.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Atualizar {
    Scanner sc = new Scanner(System.in);
    Scanner sca = new Scanner(System.in);
    public Atualizar(int opcao){
        switch (opcao) {
            case 1:
                ArmazemDAO daoA = new ArmazemDAO();
                daoA.listar2();
                System.out.println("Informe os dados do Armazém:\n");
                System.out.println("\nID do Armazem:");
                long idArmazem = sc.nextLong();
                System.out.println("\nNome");
                String nomeA = sca.nextLine();

                System.out.println("\nEndereço:");
                String enderecoA = sca.nextLine();

                Armazem armazem = new Armazem(idArmazem, nomeA, enderecoA);

                daoA.atualiza(armazem);
                break;

            case 2:
                CategoriaDAO daoCa = new CategoriaDAO();
                daoCa.listar2();
                System.out.println("Informe os dados da Categoria:\n");
                System.out.println("\nID da Categoria:");
                long idCategora = sc.nextLong();
                System.out.println("\nNome: ");
                String nomeCa = sca.nextLine();

                System.out.println("\nDescrição: ");
                String descricaoCa = sca.nextLine();

                Categoria categoria = new Categoria(idCategora, nomeCa, descricaoCa);

                daoCa.atualiza(categoria);
                break;

            case 3:
                ClienteDAO daoCli = new ClienteDAO();
                daoCli.listar2();
                System.out.println("Informe os dados do Cliente:\n");
                System.out.println("\nID do Cliente");
                long idCliente = sc.nextLong();
                System.out.println("\nNome:");
                String nomeCli = sca.nextLine();

                System.out.println("\nData de Cadastro:");
                String dataNascimentoCli = sca.nextLine();
                DateFormat formatCli = new SimpleDateFormat("dd-MM-yyyy");
                Date dateCli = null;
                try {
                    dateCli = formatCli.parse(dataNascimentoCli);
                    System.out.println(dateCli);
                }
                catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println("\nPais:");
                String paisCli = sca.nextLine();

                System.out.println("\nEstado:");
                String estadoCli = sca.nextLine();

                System.out.println("\nCidade:");
                String cidadeCli = sca.nextLine();

                System.out.println("\nEmail:");
                String emailCli = sca.nextLine();

                System.out.println("\nTelefone:");
                String telefoneCli = sca.nextLine();

                System.out.println("\nLimite de Crédito:");
                float limiteDeCreditoCli = sc.nextFloat();

                Cliente cliente = new Cliente(idCliente,nomeCli, paisCli, estadoCli, cidadeCli, emailCli, telefoneCli, limiteDeCreditoCli, dateCli);

                daoCli.atualiza(cliente);
                break;

            case 4: //Funcionando +ou-
                EstoqueDAO daoE = new EstoqueDAO();
                daoE.listar2();
                System.out.println("Informe os dados do Estoque:\n");
                System.out.println("\nID do Estoque:");
                long idEstoque = sc.nextLong();

                System.out.println("\nCodigo:");
                String codigoE = sca.nextLine();

                System.out.println("\nQuantidade:");
                int quantidadeEs = sca.nextInt();

                System.out.println("\nID do armazem:");
                ArmazemDAO daoAE = new ArmazemDAO();
                daoAE.listar2();
                long idArmazemEs = sc.nextLong();

                System.out.println("\nID do Produto:");
                ProdutoDAO daoPE = new ProdutoDAO();
                daoPE.listar2();
                long idProduto = sc.nextLong();


                Estoque estoque = new Estoque(idEstoque, codigoE ,quantidadeEs, idArmazemEs, idProduto);
                daoE.atualiza(estoque);
                break;

            case 5: // funcionando
                FornecedorDAO daoF = new FornecedorDAO();
                daoF.listar2();
                System.out.println("Informe os dados do Fornecedor:\n");
                System.out.println("\nID do Fornecedor");
                long idFornecedor = sc.nextLong();

                System.out.println("\nNome: ");
                String nomeF = sca.nextLine();

                System.out.println("\nLocalidade: ");
                String localidadeF = sca.nextLine();

                System.out.println("\nTipo de fornecedor: ");
                String tipoDeFornecedorF = sca.nextLine();

                System.out.println("\nCPF ou CNPJ: ");
                String cpfCnpjF = sca.nextLine();

                Fornecedor fornecedor = new Fornecedor(idFornecedor,nomeF,localidadeF,tipoDeFornecedorF,cpfCnpjF);

                daoF.atualiza(fornecedor);
                break;

            case 6: //Funcionando
                PedidoDAO daoPe = new PedidoDAO();
                daoPe.listar2();
                System.out.println("Informe os dados do Pedido:\n");
                System.out.println("\nID do pedido");
                long idPedido = sc.nextLong();
                System.out.println("\nData do pedido: d-MM-yyyy");
                String dataPedidoPe = sca.next();
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
                String prazoEntregaPe = sca.next();
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

                Pedido pedido = new Pedido(idPedido,idProdutoPe,idClientePe,datePedidoPe, datePrazoEntregaPe, modoEncomendaPe, statusPe);

                daoPe.atualiza(pedido);
                break;

            case 7: //Funcionando
                ProdutoDAO daoPro = new ProdutoDAO();
                daoPro.listar2();
                System.out.println("Informe os dados do Produto:\n");
                System.out.println("\nID do Produto:");
                long idProduto1 = sc.nextLong();
                System.out.println("\nNome:");
                String nomePro = sca.nextLine();
                System.out.println("\nDescrição:");
                String descricaoPro = sca.nextLine();

                System.out.println("\nData de garantia: DD-MMMM-AAAA");
                String datagarantiaPro = sca.nextLine();
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
                float precoDeCustoPro = sca.nextFloat();

                System.out.println("\nPreço de Venda:");
                float precoDeVendaPro = sc.nextFloat();

                System.out.println("\nPreço minimo de venda:");
                float precoMinimoDeVendaPro = sca.nextFloat();

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

                Produto produto = new Produto(idProduto1, nomePro, descricaoPro, datePro , precoMinimoDeVendaPro, statusPro, idCategoriaPro, idFornecedorPro, precoDeVendaPro, precoDeCustoPro);

                daoPro.atualiza(produto);
                break;

            default:
                System.out.println("Opção invalida");
                break;
        }
    }
}
