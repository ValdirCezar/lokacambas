package br.com.valdir.usuarioservice.resources.exception;

import br.com.valdir.usuarioservice.services.exception.ObjectNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(
            ObjectNotFoundException ex, HttpServletRequest request) {
        return ResponseEntity.status(NOT_FOUND).body(
                new StandardError(
                        now(),
                        NOT_FOUND.value(),
                        "Not found exception",
                        ex.getMessage(),
                        request.getRequestURI()
                )
        );
    }

}
