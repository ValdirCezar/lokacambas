package br.com.valdir.usuarioservice.resources;

import br.com.valdir.usuarioservice.models.dtos.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface UsuarioResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<UsuarioDTO> find(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<UsuarioDTO>> findAll();

    @PostMapping
    ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO objDTO);

    @PutMapping(value = "/{id}")
    ResponseEntity<UsuarioDTO> create(@PathVariable Long id, @Valid @RequestBody UsuarioDTO objDTO);
}
