package com.farmacia.views;


import com.farmacia.controller.ConectionWithDb;
import com.farmacia.controller.Gerenciador;
import com.farmacia.model.Cliente;
import com.farmacia.model.Produto;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException{

        Gerenciador gerenciador = new Gerenciador();
        ConectionWithDb conection = new ConectionWithDb();
        Vector<Cliente> clientes = new Vector<>();
        Vector<Produto> produtos = new Vector<>();

        try {
            Scanner scan = new Scanner(System.in);


            File file = new File("clientes.txt");
            if (! file.exists()){
                conection.serializationClients(clientes);
            }else {
                clientes = conection.deserializationClients();
            }


            File file2 = new File("produtos.txt");
            if (! file2.exists()){
                conection.serializationProducts(produtos);
            }else {
                produtos = conection.deserializationProducts();
            }


            int choice;

            do {
                System.out.println("+===============================================+");
                System.out.println("|                     MENU                      |");
                System.out.println("+===============================================+");
                System.out.println("1. Clientes" +
                        "\n2. Produtos" +
                        "\n3. Inventarios" +
                        "\n4. Vendas" +
                        "\n5. Relatorios" +
                        "\n6. Exit");
                System.out.print("=> ");

                choice = scan.nextInt();


                switch (choice) {
                    case 1: // client choice

                        clientes = conection.deserializationClients();
                        System.out.println("+===============================================+");
                        System.out.println("|                     MENU                      |");
                        System.out.println("+===============================================+");
                        System.out.println("1. adicionar conta" +
                                "\n2. deletar conta" +
                                "\n3. listar contas");
                        System.out.print("=> ");
                        int a = scan.nextInt();

                        switch (a) {
                            case 1: // add client
                                clientes = conection.deserializationClients();
                                System.out.print("Insira o nome: ");
                                String name = scan.next();

                                System.out.print("insira o ID: ");
                                int id = scan.nextInt();

                                gerenciador.inserir(clientes, new Cliente(id, name));
                                conection.serializationClients(clientes);

                                break;

                            case 2: // delete client
                                clientes = conection.deserializationClients();
                                System.out.print("insira o user ID: ");
                                id = scan.nextInt();

                                gerenciador.remover(clientes, id);
                                conection.serializationClients(clientes);

                                break;

                            case 3: // listar
                                clientes = conection.deserializationClients();
                                gerenciador.listar(clientes);

                                break;

                            default:
                        }
                        break; // client's break


                    case 2: // product choice

                        produtos = conection.deserializationProducts();
                        System.out.println("+===============================================+");
                        System.out.println("|                     MENU                      |");
                        System.out.println("+===============================================+");
                        System.out.println("1. adicionar producto" +
                                "\n2. deletar producto" +
                                "\n3. listar productos" +
                                "\n4. aumentar stock" +
                                "\n5. pesquisar produto");
                        System.out.print("=> ");
                        a = scan.nextInt();

                        switch (a) {
                            case 1: // add product
                                produtos = conection.deserializationProducts();
                                System.out.print("insira o nome: ");
                                String name = scan.next();

                                System.out.print("insira o ID: ");
                                int id = scan.nextInt();

                                System.out.print("insira uma description: ");
                                String infoProduto = scan.next();

                                System.out.print("insira o preco: ");
                                double price = scan.nextDouble();

                                System.out.print("quantidade: ");
                                int qnt = scan.nextInt();

                                gerenciador.inserir(produtos, new Produto(id, name, infoProduto, price, qnt));
                                conection.serializationProducts(produtos);

                                break;

                            case 2: // delete product
                                produtos = conection.deserializationProducts();
                                System.out.print("insira o product ID: ");
                                id = scan.nextInt();

                                gerenciador.remover(produtos, id);
                                conection.serializationProducts(produtos);

                                break;

                            case 3: // listar
                                produtos = conection.deserializationProducts();
                                gerenciador.listar(produtos);

                                break;

                            case 4:
                                produtos = conection.deserializationProducts();

                                System.out.print("inira o nome do producto: ");
                                name = scan.next();

                                System.out.print("quantidade: ");
                                qnt = scan.nextInt();

                                gerenciador.actualizarStock(produtos, name, qnt);

                                conection.serializationProducts(produtos);
                                break;

                            case 5:
                                produtos = conection.deserializationProducts();

                                System.out.print("insira o nome: ");
                                name = scan.next();

                                gerenciador.atravesNomeDevolverObjecto(produtos, name);
                                break;
                            default:
                        }
                        break; // product's break


                    case 3:
                        produtos = conection.deserializationProducts();
                        gerenciador.listar(produtos);
                        break;

                    case 4: // sales
                        clientes = conection.deserializationClients();
                        produtos = conection.deserializationProducts();



                        System.out.print("Insira o nome do cliente: ");
                        String name = scan.next();


                        if (gerenciador.authUser(clientes, name) != -1){
                            int i = gerenciador.authUser(clientes, name);
                            System.out.println("cliente encontrado!");

                            System.out.print("insira o nome do producto: ");
                            String nomeProduto = scan.next();

                            System.out.print("quantidade: ");
                            int qnt = scan.nextInt();

                            if (gerenciador.authProduct(produtos, nomeProduto) != -1){
                                int j = gerenciador.authProduct(produtos, nomeProduto);

                                if (qnt > produtos.get(j).getQuantidade()){
                                    System.out.println("so restam "+produtos.get(j).getQuantidade()+" unidades!");
                                    qnt = produtos.get(j).getQuantidade();
                                    break;
                                }

                                double price = produtos.get(j).getPreco();

                                System.out.println("valor total: "+(price * qnt));

                                System.out.print("insira o montante de pagamento: ");
                                Double pagamento = scan.nextDouble();

                                if (pagamento >= (price * qnt)){
                                    clientes.get(i).setBalance(clientes.get(i).getBalance() + (price * qnt));

                                    produtos.get(j).setQuantidade(produtos.get(j).getQuantidade() - qnt);

                                    produtos.get(j).setDemanda(produtos.get(j).getDemanda() + qnt);

                                    // venda de dinheiro

                                    gerenciador.vendaDeDinheiro(name, nomeProduto, price, qnt, pagamento, new Date());

                                    System.out.println("compra efetuada com sucesso!");

                                    conection.serializationClients(clientes);
                                    conection.serializationProducts(produtos);
                                }else {
                                    System.out.println("valor insuficiente!");
                                }


                            }else {
                                System.out.println("produto nao encontrado!");
                            }

                        }else {
                            System.out.println("cliente nao encontrado!");
                        }

                        break; // sales break


                    case 5: // stock
                        produtos = conection.deserializationProducts();
                        gerenciador.relatorioDeStock(produtos);

                        break;
                    default:


                }//end first switch case



            }while (choice != 6);

        }catch (Exception e){
            System.out.println("opcao invalida!");
        }





    }
}
