package br.com.valdir.usuarioservice.resources.impl;

import br.com.valdir.usuarioservice.models.dtos.UsuarioDTO;
import br.com.valdir.usuarioservice.resources.UsuarioResource;
import br.com.valdir.usuarioservice.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResourceImpl implements UsuarioResource {

    private final UsuarioService service;
    private final ModelMapper mapper;

    @Override
    public ResponseEntity<UsuarioDTO> find(Long id) {
        return ResponseEntity.ok().body(mapper.map(service.find(id), UsuarioDTO.class));
    }

    @Override
    public ResponseEntity<List<UsuarioDTO>> findAll() {
        return ResponseEntity.ok().body(
                service.findAll().stream().map(obj -> mapper.map(obj, UsuarioDTO.class)).toList()
        );
    }

    @Override
    public ResponseEntity<UsuarioDTO> create(UsuarioDTO objDTO) {
        return null;
    }

    @Override
    public ResponseEntity<UsuarioDTO> create(Long id, UsuarioDTO objDTO) {
        return null;
    }
}
