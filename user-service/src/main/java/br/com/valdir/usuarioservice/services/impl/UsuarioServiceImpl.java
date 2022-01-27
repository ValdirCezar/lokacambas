package br.com.valdir.usuarioservice.services.impl;

import br.com.valdir.usuarioservice.models.Usuario;
import br.com.valdir.usuarioservice.models.dtos.UsuarioDTO;
import br.com.valdir.usuarioservice.repositories.UsuarioRepository;
import br.com.valdir.usuarioservice.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario find(Long id) {
        return null;
    }

    @Override
    public List<Usuario> findAll(Long id) {
        return null;
    }

    @Override
    public Usuario create(UsuarioDTO objDTO) {
        return null;
    }

    @Override
    public Usuario update(UsuarioDTO objDTO, Long id) {
        return null;
    }
}
