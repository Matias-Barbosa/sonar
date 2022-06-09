package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.ItemProduto;
import br.com.triersistemas.sonar.Exception.NaoExisteException;
import br.com.triersistemas.sonar.Model.ItemModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemController {

    public static final List<ItemProduto> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<ItemProduto> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public ItemProduto cadastrar(@RequestBody ItemModel model) {
        var domain = new ItemProduto(model.getProduto(), model.getQuantidade());
        LIST.add(domain);
        return domain;
    }

    @DeleteMapping("/remover/{id}")
    public ItemProduto remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}

