package br.com.valdir.cacambaservice.resources;

import br.com.valdir.cacambaservice.models.dtos.CacambaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface CacambaResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<CacambaDTO> find(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<CacambaDTO>> findAll();

    @PostMapping
    ResponseEntity<CacambaDTO> create(@Valid @RequestBody CacambaDTO objDTO);

    @PutMapping(value = "/{id}")
    ResponseEntity<CacambaDTO> update(@PathVariable Long id, @Valid @RequestBody CacambaDTO objDTO);
}
