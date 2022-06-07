package br.com.triersistemas.sonar.Model;

import lombok.Getter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Getter
public class FarmaceuticoModel {

    private String nome;
    private LocalDate aniver;
    private String cpf;
    private int ID;
}
