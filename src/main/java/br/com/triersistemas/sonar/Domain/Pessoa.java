package br.com.triersistemas.sonar.Domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Pessoa {
    private String nome;
    private LocalDate aniver;

    private UUID ID;

    protected Pessoa() {
        this.aniver = LocalDate.now();
        List<String> nomes = new ArrayList<>();
        nomes.add("Alexson");
        nomes.add("Ana");
        nomes.add("Murilo");
        nomes.add("Matias");
        nomes.add("Vinicius");
        nomes.add("Guilherme");
        nomes.add("João Paulo");
        nomes.add("Julio");
        nomes.add("Gabriel");
        nomes.add("Edward");
        var rd = new SplittableRandom();
        this.nome = nomes.get(rd.nextInt(0, nomes.size()));
        this.ID = UUID.randomUUID();


    }

    protected Pessoa(final String nome, final LocalDate aniver) {
        this.nome = nome;
        this.aniver = aniver;
    }

    public String getNome() {
        return nome;
    }

    public String getAniver() {
        if (Objects.nonNull(this.aniver)) {
            return this.aniver.format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return "";
    }

    public Long getIdade() {
        return Objects.nonNull(this.aniver) ? ChronoUnit.YEARS.between(this.aniver, LocalDate.now()) : 0L;
    }

    public abstract String getDocumento();

    public abstract Boolean documentoValido();

    protected List<Integer> geraDocumento(final int tamanho) {
        var rd = new SplittableRandom();
        List<Integer> digitos = new ArrayList<>();
        for (int i = 0; i < tamanho; i++) {
            digitos.add(rd.nextInt(0, 10));
        }
        return digitos;
    }

    protected int mod11(final List<Integer> digitos, final int... multiplicadores) {
        final AtomicInteger i = new AtomicInteger(0);
        int resto = digitos.stream()
                .reduce(0, (p, e) -> p + e * multiplicadores[i.getAndIncrement()]) % 11;
        return resto > 9 ? 0 : resto;
    }

    protected String extractNumbers(final String documento) {
        if (Objects.nonNull(documento)) {
            return documento.replaceAll("\\D+", "");
        }
        return "";
    }

    protected List<Integer> toListInteger(final String documento) {
        final var digitos = new ArrayList<Integer>();
        for (char item : extractNumbers(documento).toCharArray()) {
            digitos.add(Integer.parseInt(String.valueOf(item)));
        }
        return digitos;
    }

    protected String listToString(final List<Integer> digitos) {
        return digitos.stream()
                .map(Object::toString)
                .reduce("", (p, e) -> p + e);
    }

    public UUID getID() {
        return ID;
    }
}
