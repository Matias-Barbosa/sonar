package br.com.triersistemas.sonar.Domain;

import br.com.triersistemas.sonar.helper.StringUtils;
import br.com.triersistemas.sonar.Domain.Pessoa;

import java.util.UUID;

public class Produto {
    private String nome;
    private UUID id;
    private double valor;

    public Produto() {
        this.id = UUID.randomUUID();
        this.nome = StringUtils.getRandomMedicine();
        this.valor = StringUtils.getValor();

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

    public Produto(final String nome, final UUID id, final double valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
    }

    public void editar(String nome, UUID id, int valor) {
    }
}
