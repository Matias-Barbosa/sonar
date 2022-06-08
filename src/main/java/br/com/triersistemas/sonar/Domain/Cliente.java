package br.com.triersistemas.sonar.Domain;

import br.com.triersistemas.sonar.helper.StringUtils;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente extends Pessoa{

    private String nome;
    private UUID id;
    private String cpf;

    public Cliente() {
        this.id = UUID.randomUUID();
        this.cpf = cpf;
        this.nome = nome;

    }

    @Override
    public String getDocumento() {
        return cpf;
    }

    @Override
    public Boolean getDocumentoValido() {
        return null;
    }
}
