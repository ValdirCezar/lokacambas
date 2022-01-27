package br.com.valdir.cacambaservice.resources.impl;

import br.com.valdir.cacambaservice.models.dtos.CacambaDTO;
import br.com.valdir.cacambaservice.resources.CacambaResource;
import br.com.valdir.cacambaservice.services.CacambaService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/cacambas")
public class CacambaResourceImpl implements CacambaResource {

    private final CacambaService service;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<CacambaDTO> find(Long id) {
        return ResponseEntity.ok().body(mapper.map(service.find(id), CacambaDTO.class));
    }

    @Override
    public ResponseEntity<List<CacambaDTO>> findAll() {
        return ResponseEntity.ok().body(
                service.findAll().stream().map(obj -> mapper.map(obj, CacambaDTO.class)).toList()
        );
    }

    @Override
    public ResponseEntity<CacambaDTO> create(CacambaDTO objDTO) {
        objDTO = mapper.map(service.create(objDTO), CacambaDTO.class);
        return ResponseEntity
                .created(fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri())
                .build();
    }

    @Override
    public ResponseEntity<CacambaDTO> update(Long id, CacambaDTO objDTO) {
        return ResponseEntity.ok().body(
                mapper.map(service.update(objDTO, id), CacambaDTO.class)
        );
    }

}
