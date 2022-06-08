package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.Farmaceutico;
import br.com.triersistemas.sonar.Exception.NaoExisteException;
import br.com.triersistemas.sonar.Model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/farmaceutico")
public class FarmaceuticoController {

    private final static List<Farmaceutico> LIST = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Farmaceutico> consultar() {
        return LIST;
    }

    @PostMapping("/cadastrar")
    public List<Farmaceutico> cadastrar(@RequestBody FarmaceuticoModel model) {
        LIST.add(new Farmaceutico(model.getNome(), model.getAniver(), model.getCpf(), model.getID()));
        return LIST;
    }

    @PostMapping("/cadastrar-random")
    public List<Farmaceutico> cadastrarRandon() {
        LIST.add((new Farmaceutico()));
        return LIST;
    }


    @DeleteMapping("/alterar/{id}")
    public List<Farmaceutico> remover(@PathVariable UUID id, @RequestBody FarmaceuticoModel model) {
        var contato = LIST.stream()
                .filter(x -> x.getID().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LIST.remove(contato);
        return LIST;
    }

    @DeleteMapping("/remover/{id}")
    public List<Farmaceutico> remover(@PathVariable UUID id) {
        LIST.remove(index);
        return LIST;
    }

}
