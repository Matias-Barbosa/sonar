package br.com.triersistemas.sonar.Model;

import lombok.Getter;
import org.apache.tomcat.jni.Local;

import java.time.LocalDate;

@Getter
public class FarmaceuticoModel {

    String nome;
    LocalDate aniver;
    String cpf;
    Integer ID;
}
