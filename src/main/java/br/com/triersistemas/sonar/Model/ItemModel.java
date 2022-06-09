package br.com.triersistemas.sonar.Model;

import br.com.triersistemas.sonar.Domain.Produto;
import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class ItemModel {

    private Produto produto;
    private int quantidade;
    private BigDecimal valor;
}
