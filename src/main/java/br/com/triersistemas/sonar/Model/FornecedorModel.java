package br.com.triersistemas.sonar.Model;

import br.com.triersistemas.sonar.Domain.Pessoa;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FornecedorModel {

    private String nome;
    private LocalDate aniver;
    private String cnpj;
    private int ID;
}
