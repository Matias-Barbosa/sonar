package br.com.triersistemas.sonar.repository;

import br.com.triersistemas.sonar.Domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepository {
    List<Produto> consultar();
    Optional<Produto> consultar(UUID id);
    void cadastrar(Produto produto);
    void remover(Produto produto);
}

