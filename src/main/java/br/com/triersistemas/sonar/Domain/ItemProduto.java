package br.com.triersistemas.sonar.Domain;

import br.com.triersistemas.sonar.helper.StringUtils;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemProduto {

    private UUID id;

    private String produto;

    private int quantidade;

    private BigDecimal valor;

    public ItemProduto(final Produto produto,final int quantidade) {
        this.produto = StringUtils.getRandomMedicine();
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
