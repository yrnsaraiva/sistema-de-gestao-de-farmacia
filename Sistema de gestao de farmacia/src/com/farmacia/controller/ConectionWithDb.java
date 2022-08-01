package com.farmacia.controller;


import com.farmacia.model.Cliente;
import com.farmacia.model.Produto;

import java.io.*;
import java.util.Vector;

public class ConectionWithDb {

    public void serializationClients(Vector<Cliente> v) throws IOException {
        File file = new File("clientes.txt");
        if (! file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(v);

        objectOutput.flush();
        fileOutput.flush();

        objectOutput.close();
        fileOutput.close();

    }

    public Vector<Cliente> deserializationClients() throws IOException, ClassNotFoundException {

        File file = new File("clientes.txt");
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);

        Object clientes = objectInput.readObject();

        objectInput.close();
        fileInput.close();

        return (Vector<Cliente>)  clientes;
    }

    public void serializationProducts(Vector<Produto> v) throws IOException {
        File file = new File("produtos.txt");
        if (! file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutput = new FileOutputStream(file);
        ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
        objectOutput.writeObject(v);

        objectOutput.flush();
        fileOutput.flush();

        objectOutput.close();
        fileOutput.close();

    }

    public Vector<Produto> deserializationProducts() throws IOException, ClassNotFoundException {

        File file = new File("produtos.txt");
        FileInputStream fileInput = new FileInputStream(file);
        ObjectInputStream objectInput = new ObjectInputStream(fileInput);

        Object produtos = objectInput.readObject();

        objectInput.close();
        fileInput.close();

        return (Vector<Produto>) produtos;
    }

}
