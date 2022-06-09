package br.com.triersistemas.sonar.Model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FornecedorModel {

    private String nome;
    private LocalDate aniver;
    private String cnpj;
}
