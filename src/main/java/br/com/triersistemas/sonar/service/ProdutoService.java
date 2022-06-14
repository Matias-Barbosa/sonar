package br.com.triersistemas.sonar.service;

import br.com.triersistemas.sonar.Domain.Produto;
import br.com.triersistemas.sonar.Model.ProdutoModel;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {

    List<Produto> consultar();
    Produto consultar(UUID id);
    Produto cadastrar(ProdutoModel model);
    Produto alterar(UUID id, ProdutoModel model);
    Produto remover(UUID id);
}

