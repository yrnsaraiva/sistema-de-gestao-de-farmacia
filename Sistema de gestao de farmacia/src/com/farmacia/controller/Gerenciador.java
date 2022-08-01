package com.farmacia.controller;

import com.farmacia.model.Cliente;
import com.farmacia.model.Produto;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class Gerenciador implements Operacoes  {

    @Override
    public void listar(Vector v) {
        for (int i = 0; i < v.size(); i++){
            System.out.println("==============================================================================");
            System.out.println(v.get(i).toString()+ " ");
            System.out.println("==============================================================================");
        }
    }

    @Override
    public void actualizarNome(Vector v, int index, String novoNome) {
        for (int i = 0; i < v.size(); i++){
            if ( ((Cliente) v.get(i)).getId() == index){
                ((Cliente) v.get(i)).setName(novoNome);
            }else {
                System.out.println("Nao detectei o elemento procurado!");
            }
        }
    }

    @Override
    public void actualizarStock(Vector v, String nomeProduto, int novoStock) {
        for (int i = 0; i < v.size(); i++){
            if ( (((Produto) v.get(i)).getName()).equalsIgnoreCase(nomeProduto)){
                ((Produto) v.get(i)).setQuantidade(((Produto) v.get(i)).getQuantidade() + novoStock);
            }
        }
    }

    @Override
    public void inserir(Vector v, Object obj) {
        v.addElement(obj);
    }

    @Override
    public void remover(Vector v, int index) {
        for(int i = 0; i < v.size(); i++) {
            try {
                if( ((Cliente) v.get(i)).getId() == index) {
                    v.remove(v.get(i));
                }
            }catch (Exception e){
                if( ((Produto) v.get(i)).getId() == index) {
                    v.remove(v.get(i));
                }
            }

        }

    }

    @Override
    public void atravesIndiceDevolverObjecto(Vector v, int index) {
        for(int i = 0; i < v.size(); i++) {
            try {
                if( ((Cliente) v.get(i)).getId() == index) {
                    System.out.println("========================================");
                    System.out.println(v.get(i));
                    System.out.println("========================================");
                }
            }catch (Exception e){
                if( ((Produto) v.get(i)).getId() == index) {
                    System.out.println("========================================");
                    System.out.println(v.get(i));
                    System.out.println("========================================");
                }
            }

        }
    }

    @Override
    public void relatorioDeStock(Vector v) {
        for (int i = 0; i < v.size(); i++){
            if ( ((Produto) v.get(i)).getQuantidade() < 5){
                System.out.println(((Produto) v.get(i)).getName() +": "+((Produto) v.get(i)).getQuantidade());
                System.out.println("Solicitar reposicao de stock!");
                System.out.println(" ");
            }else {
                System.out.println(((Produto) v.get(i)).getName() +": "+((Produto) v.get(i)).getQuantidade());
            }
        }

    }

    @Override
    public int authUser(Vector<Cliente> clientes, String name) {
        for (int i = 0; i < clientes.size(); i++){
            if ((clientes.get(i).getName()).contains(name)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int authProduct(Vector<Produto> produtos, String name) {
        for (int i = 0; i < produtos.size(); i++){
            if ((produtos.get(i).getName()).contains(name)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public void limparConsole() throws IOException, InterruptedException {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");

    }

    @Override
    public void vendaDeDinheiro(String nome, String nomeProduto, Double price, int qnt, double montante, Date dataActual) {

        System.out.println("=================================================================");
        System.out.println("Farmacia" +
                "\nNUIT: XXXXXXXXXX" +
                "\nBairro central" +
                "\nTel. 878750526");

        System.out.println("");
        System.out.println("Nome: "+nome);
        System.out.println("NUIT: " +
                "\nMorada: ");

        System.out.println("");
        System.out.println("Venda a Dinheiro" +
                "\n"+dataActual);

        System.out.println("produto: "+nomeProduto);
        System.out.println("quantidade: "+qnt);
        System.out.println("preco: "+price);
        System.out.println("Total: "+(price * qnt));
        System.out.println("");
        System.out.println("Pagamento: "+montante);
        System.out.println("Troco: "+(montante - (price * qnt)));
        System.out.println("IVA: ");
        System.out.println("=================================================================");
    }

    @Override
    public void atravesNomeDevolverObjecto(Vector v, String name) {
        for(int i = 0; i < v.size(); i++) {
            try {
                if(((Cliente) v.get(i)).getName().equals(name)) {
                    System.out.println("========================================");
                    System.out.println(v.get(i));
                    System.out.println("========================================");
                }
            }catch (Exception e){
                if(((Produto) v.get(i)).getName().equals(name)) {
                    System.out.println("========================================");
                    System.out.println(v.get(i));
                    System.out.println("========================================");
                }
            }

        }
    }


}
