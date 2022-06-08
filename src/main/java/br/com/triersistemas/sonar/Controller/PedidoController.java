package br.com.triersistemas.sonar.Controller;

import br.com.triersistemas.sonar.Domain.Pedido;
import br.com.triersistemas.sonar.Exceptions.NaoExisteException;
import br.com.triersistemas.sonar.Model.PedidoModel;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/Pedido")
public class PedidoController {

    private static final List<Pedido> LISTAPEDIDOS = new ArrayList<>();

    @GetMapping("/consultar")
    public List<Pedido> consultar() {
        return LISTAPEDIDOS;
    }

    @PostMapping("/cadastrar-random")
    public List<Pedido> cadastrarRandon() {
        LISTAPEDIDOS.add(new Pedido());
        return LISTAPEDIDOS;
    }

    @PostMapping("/cadastrar")
    public List<Pedido> cadastrar(@RequestBody PedidoModel model) {
        LISTAPEDIDOS.add(new Pedido(model.getNome(), model.getValor(), model.getId(), model.getCliente(), model.getListaPedidos()));
        return LISTAPEDIDOS;
    }

    @PutMapping("/alterar/{id}")
    public List<Pedido> remover(@PathVariable UUID id, @RequestBody PedidoModel model) {
        var domain = LISTAPEDIDOS.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        domain.editar(model.getNome(), model.getValor(), model.getCliente(), model.getId(), model.getListaPedidos());
        return LISTAPEDIDOS;
    }

    @DeleteMapping("/remover/{id}")
    public List<Pedido> remover(@PathVariable UUID id) {
        var domain = LISTAPEDIDOS.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElseThrow(NaoExisteException::new);
        LISTAPEDIDOS.remove(domain);
        return LISTAPEDIDOS;
    }
}
