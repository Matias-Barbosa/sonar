package br.com.triersistemas.sonar.Model;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FornecedorModel {

    String nome;
    LocalDate aniver;
    String cnpj;
    Integer ID;
    LocalDate idade;
}
