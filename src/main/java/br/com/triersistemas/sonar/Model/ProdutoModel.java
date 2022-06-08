package br.com.triersistemas.sonar.Model;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ProdutoModel {
    private UUID id;
    private String nome;
    private int valor;
}
