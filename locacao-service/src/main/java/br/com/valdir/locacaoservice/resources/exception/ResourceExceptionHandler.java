package br.com.valdir.locacaoservice.resources.exception;

import br.com.valdir.locacaoservice.services.exception.ObjectNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(
            ObjectNotFoundException ex, HttpServletRequest request
    ) {
        return ResponseEntity.status(NOT_FOUND).body(
                new StandardError(
                        now(),
                        NOT_FOUND.value(),
                        "Not found",
                        ex.getMessage(),
                        request.getRequestURI()
                )
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validationErrors(
            MethodArgumentNotValidException ex, HttpServletRequest request
    ) {
        ValidationError errors = new ValidationError(
                LocalDateTime.now(), BAD_REQUEST.value(),
                "Validation error",
                "Erro na validação dos campos",
                request.getRequestURI()
        );

        ex.getBindingResult().getFieldErrors().forEach(x -> errors.addError(x.getField(), x.getDefaultMessage()));
        return ResponseEntity.status(BAD_REQUEST).body(errors);
    }

}
