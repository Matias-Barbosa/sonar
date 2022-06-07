package br.com.triersistemas.sonar.Model;

import br.com.triersistemas.sonar.Domain.Pessoa;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class FornecedorModel {

    String nome;
    LocalDate aniver;
    String cnpj;
    Integer ID;
    LocalDate Idade = getIdade();
}
