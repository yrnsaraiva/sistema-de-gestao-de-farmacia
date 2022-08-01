package com.farmacia.model;

import java.io.Serializable;

public class Produto implements Serializable {
    private int id;
    private String name;
    private String infoProducto;
    private double preco;
    private int quantidade;
    private int demanda;

    public Produto(int id, String name, String infoProducto, double preco, int quantidade) {
        this.id = id;
        this.name = name;
        this.infoProducto = infoProducto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.demanda = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPreco() {
        return preco;
    }

    public String getInfoProducto() {
        return infoProducto;
    }

    public void setInfoProducto(String infoProducto) {
        this.infoProducto = infoProducto;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getDemanda() {
        return demanda;
    }

    public void setDemanda(int demanda) {
        this.demanda = demanda;
    }

    @Override
    public String toString() {

        return " ID: "+id+
                "\n produto: "+name+
                "\n descricao: "+infoProducto+
                "\n preco: "+preco+
                "\n quantidade: "+quantidade+
                "\n demanda: "+demanda;
    }
}
