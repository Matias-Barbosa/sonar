package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.Cliente;
import br.com.triersistemas.sonar.Domain.Produto;
import br.com.triersistemas.sonar.Exception.NaoExisteException;
import br.com.triersistemas.sonar.Model.ClienteModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    public static final List<Cliente> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Cliente> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public Cliente cadastrar(@RequestBody ClienteModel model) {
        var domain = new Cliente(model.getNome(), model.getAniver(), model.getCpf(), model.getEmail());
        LIST.add(domain);
        return domain;
    }

    @PutMapping("/alterar/{id}")
    public Cliente remover(@PathVariable UUID id, @RequestBody ClienteModel model) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getAniver(), model.getCpf(), model.getEmail());
        return domain;
    }

    @DeleteMapping("/remover/{id}")
    public Cliente remover(@PathVariable UUID id) {
        var domain = LIST.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(domain);
        return domain;
    }
}
