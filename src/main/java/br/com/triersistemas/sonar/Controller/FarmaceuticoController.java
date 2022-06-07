package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.Farmaceutico;
import br.com.triersistemas.sonar.Model.FarmaceuticoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        LIST.add(new Farmaceutico(model.getNome(), model.getAniver(), model.getCpf(), model.getID(), model.getIdade()));
        return LIST;
    }

        @PostMapping("/cadastrar-random")
        public List<Farmaceutico> cadastrarRandon() {
            LIST.add((new Farmaceutico()));
            return LIST;
        }


        @DeleteMapping("/alterar/{index}")
        public List<Farmaceutico> remover (@PathVariable Integer index, @RequestBody FarmaceuticoModel model){
            var contato = LIST.get(index);
            LIST.remove(contato);
            return LIST;
        }

        @DeleteMapping("/remover/{index}")
        public List<Farmaceutico> remover ( @PathVariable int index){
            LIST.remove(index);
            return LIST;
        }

    }
