package br.com.triersistemas.sonar.Model;

import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class PedidoModel {
    private UUID id;
    private String nome;
    private int valor;
    private String cliente;
    private List<String> listaPedidos;
}
