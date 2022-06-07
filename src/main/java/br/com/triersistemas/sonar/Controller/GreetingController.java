package br.com.triersistemas.sonar.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import br.com.triersistemas.sonar.Model.ContatoModel;
import org.springframework.web.bind.annotation.*;

@RestController("/contato")
public class GreetingController {

    private final static List<ContatoModel> CONTATOS = new ArrayList<>();

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/consultar")
    public List<ContatoModel> consultar() {
    return CONTATOS;
    }

    @PostMapping("/cadastrar")
    public  List<ContatoModel> cadastrar(@RequestBody ContatoModel contato) {
        CONTATOS.add(contato);
        return CONTATOS;
    }

    @DeleteMapping("/alterar/{index}")
    public List<ContatoModel> remover(@PathVariable Integer index, @RequestBody ContatoModel model) {
        var contato= CONTATOS.get(index);
        CONTATOS.remove(contato);
        return CONTATOS;
    }

}
