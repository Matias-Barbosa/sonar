package br.com.triersistemas.sonar.Controller;


import br.com.triersistemas.sonar.Domain.Produto;
import br.com.triersistemas.sonar.Exception.NaoExisteException;
import br.com.triersistemas.sonar.Model.ProdutoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    private static final List<Produto> LISTAPRODUTOS = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Produto> consultar() {
        return LISTAPRODUTOS;
    }

    @PostMapping("/cadastrar-random")
    public List<Produto> cadastrarRandon() {
        LISTAPRODUTOS.add(new Produto());
        return LISTAPRODUTOS;
    }

    @PostMapping("/cadastrar")
    public List<Produto> cadastrar(@RequestBody ProdutoModel model) {
        LISTAPRODUTOS.add(new Produto(model.getNome(), model.getId(), model.getValor()));
        return LISTAPRODUTOS;
    }

    @PutMapping("/alterar/{id}")
    public List<Produto> remover(@PathVariable UUID id, @RequestBody ProdutoModel model) {
        var domain = LISTAPRODUTOS.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getId(), model.getValor());
        return LISTAPRODUTOS;
    }

    @DeleteMapping("/remover/{id}")
    public List<Produto> remover(@PathVariable UUID id) {
        var domain = LISTAPRODUTOS.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LISTAPRODUTOS.remove(domain);
        return LISTAPRODUTOS;
    }
}
