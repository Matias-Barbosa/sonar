package br.com.triersistemas.sonar.Domain;

import br.com.triersistemas.sonar.helper.StringUtils;

import java.util.List;
import java.util.UUID;

public class Pedido {

    private String nome;
    private UUID id;
    private List<String> listaPedidos;
    private Cliente cliente;
    private double valor;


    public Pedido() {
        this.id = UUID.randomUUID();
        this.nome = StringUtils.getRandomMedicine();
        this.valor = StringUtils.getValor();
        this.listaPedidos = StringUtils.getRandomListMedicine();
        this.cliente = new Cliente();

    }

    public Pedido(String nome, int valor, UUID id, String cliente, List<String> listaPedidos) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.cliente = new Cliente();
        this.listaPedidos = listaPedidos;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public List<String> getLista() {
        return listaPedidos;
    }

    public Cliente getCliente() {
        return new Cliente();
    }

    public void editar(String nome, int valor, String cliente, UUID id, List<String> listaPedidos) {
    }
}
