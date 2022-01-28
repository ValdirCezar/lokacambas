package br.com.valdir.locacaoservice.resources;

import br.com.valdir.locacaoservice.models.dtos.LocacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface LocacaoResource {

    @GetMapping(value = "/{id}")
    ResponseEntity<LocacaoDTO> find(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<LocacaoDTO>> findAll();

    @PostMapping
    ResponseEntity<LocacaoDTO> create(@Valid @RequestBody LocacaoDTO objDTO);

    @PutMapping(value = "/{id}")
    ResponseEntity<LocacaoDTO> update(@PathVariable Long id, @Valid @RequestBody LocacaoDTO objDTO);
}
