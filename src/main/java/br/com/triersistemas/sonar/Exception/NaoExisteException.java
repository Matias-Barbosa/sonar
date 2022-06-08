package br.com.triersistemas.sonar.Exception;


import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOTFOUND)
public class NaoExisteException extends RuntimeException{
}
