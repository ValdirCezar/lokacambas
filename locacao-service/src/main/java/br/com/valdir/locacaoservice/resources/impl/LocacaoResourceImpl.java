package br.com.valdir.locacaoservice.resources.impl;

import br.com.valdir.locacaoservice.models.dtos.LocacaoDTO;
import br.com.valdir.locacaoservice.resources.LocacaoResource;
import br.com.valdir.locacaoservice.services.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/locacoes")
public class LocacaoResourceImpl implements LocacaoResource {

    private final LocacaoService service;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<LocacaoDTO> find(Long id) {
        return ResponseEntity.ok().body(mapper.map(service.find(id), LocacaoDTO.class));
    }

    @Override
    public ResponseEntity<List<LocacaoDTO>> findAll() {
        return ResponseEntity.ok().body(
                service.findAll().stream().map(obj -> mapper.map(obj, LocacaoDTO.class)).toList()
        );
    }

    @Override
    public ResponseEntity<LocacaoDTO> create(LocacaoDTO objDTO) {
        objDTO = mapper.map(service.create(objDTO), LocacaoDTO.class);
        return ResponseEntity
                .created(fromCurrentRequest().path("/{id}").buildAndExpand(objDTO.getId()).toUri())
                .build();
    }

    @Override
    public ResponseEntity<LocacaoDTO> update(Long id, LocacaoDTO objDTO) {
        return ResponseEntity.ok().body(
                mapper.map(service.update(objDTO, id), LocacaoDTO.class)
        );
    }

}
