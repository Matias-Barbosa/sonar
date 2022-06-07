package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.Fornecedor;
import br.com.triersistemas.sonar.Model.FornecedorModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    private final static List<Fornecedor> LISTA = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Fornecedor> consultar() {
        return LISTA;
    }

    @PostMapping("/cadastrar")
    public List<Fornecedor> cadastrar(@RequestBody FornecedorModel model) {
        LISTA.add(new Fornecedor(model.getNome(), model.getAniver(), model.getCnpj(), model.getID()));
        return LISTA;
    }

    @PostMapping("/cadastrar-random")
    public List<Fornecedor> cadastrarRandon() {
        LISTA.add((new Fornecedor()));
        return LISTA;
    }

    @DeleteMapping("/alterar/{index}")
    public List<Fornecedor> remover(@PathVariable Integer index, @RequestBody FornecedorModel model) {
        var contato= LISTA.get(index);
        LISTA.remove(contato);
        return LISTA;
    }

    @DeleteMapping("/remover/{index}")
    public List<Fornecedor> remover(@PathVariable int index) {
        LISTA.remove(index);
        return LISTA;
    }

}
