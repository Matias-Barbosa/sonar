package br.com.triersistemas.sonar.Model;


import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ClienteModel {

    private String nome;
    private LocalDate aniver;
    private String cpf;
    private String email;
}
