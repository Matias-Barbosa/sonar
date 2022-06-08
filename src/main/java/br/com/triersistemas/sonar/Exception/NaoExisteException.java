package br.com.triersistemas.sonar.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NaoExisteException extends RuntimeException {
    public NaoExisteException() {
        super("O registro não existe");
    }
}
