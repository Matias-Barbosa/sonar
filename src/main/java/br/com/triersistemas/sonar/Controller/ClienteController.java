package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.Cliente;
import br.com.triersistemas.sonar.Domain.Produto;
import br.com.triersistemas.sonar.Exceptions.NaoExisteException;
import br.com.triersistemas.sonar.Model.ClienteModel;
import br.com.triersistemas.sonar.Model.ProdutoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Cliente")
public class ClienteController {

    private static final List<Cliente> LISTACLIENTES = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Cliente> consultar() {
        return LISTACLIENTES;
    }

    @PostMapping("/cadastrar-random")
    public List<Cliente> cadastrarRandon() {
        LISTACLIENTES.add(new Cliente());
        return LISTACLIENTES;
    }

    @PostMapping("/cadastrar")
    public List<Cliente> cadastrar(@RequestBody ClienteModel model) {
        LISTACLIENTES.add(new Cliente(model.getNome(), model.getID(), model.getCpf()));
        return LISTACLIENTES;
    }

    @PutMapping("/alterar/{id}")
    public List<Cliente> remover(@PathVariable UUID id, @RequestBody ClienteModel model) {
        var domain = LISTACLIENTES.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getID(), model.getCpf());
        return LISTACLIENTES;
    }

    @DeleteMapping("/remover/{id}")
    public List<Cliente> remover(@PathVariable UUID id) {
        var domain = LISTACLIENTES.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LISTACLIENTES.remove(domain);
        return LISTACLIENTES;
    }
}
