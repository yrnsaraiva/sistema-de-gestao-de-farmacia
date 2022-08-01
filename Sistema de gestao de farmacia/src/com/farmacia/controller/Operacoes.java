package com.farmacia.controller;

import com.farmacia.model.Cliente;
import com.farmacia.model.Produto;

import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public interface Operacoes {

    public abstract void listar(Vector v);

    public abstract void actualizarNome(Vector v, int index, String novoNome);

    public abstract void actualizarStock(Vector v, String nomeProduto, int novoStock);

    public abstract void inserir(Vector v, Object obj);

    public abstract void remover(Vector v, int index);

    public abstract void atravesIndiceDevolverObjecto(Vector v, int index);

    public abstract void relatorioDeStock(Vector v);

    public abstract int authUser(Vector<Cliente> clientes, String name);

    public abstract int authProduct(Vector<Produto> produtos, String name);

    public abstract void limparConsole() throws IOException, InterruptedException;

    public abstract void vendaDeDinheiro(String nome, String nomeProduto, Double price, int qnt, double montante, Date dataActual);

    public abstract void atravesNomeDevolverObjecto(Vector v, String name);


}
