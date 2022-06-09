package br.com.triersistemas.sonar.Domain;

import br.com.triersistemas.sonar.helper.StringUtils;
import lombok.Getter;

import java.util.UUID;
@Getter
public class ItemProduto {

    private UUID id;

    private String produto;

    private int quantidade;

    private int valor;

    public ItemProduto(final Produto produto,final int quantidade) {
        this.produto = StringUtils.getRandomMedicine();
        this.quantidade = quantidade;
        this.valor = valor;
    }
}
