package br.com.triersistemas.sonar.Domain;

import java.util.UUID;

public class Cliente extends PessoaFisica{

    private String nome;
    private UUID id;
    private String cpf;

    public Cliente() {
        this.id = UUID.randomUUID();
        this.cpf = cpf;
        this.nome = nome;

    }

    public Cliente(String nome, UUID id, String cpf) {
        this.nome = nome;
        this.id = id;
        this.cpf = cpf;
    }

    public void editar(String nome, UUID id, String cpf) {
    }

    public UUID getId() {
    return id;
    }
}
