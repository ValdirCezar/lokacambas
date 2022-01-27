package br.com.valdir.usuarioservice.services.impl;

import br.com.valdir.usuarioservice.models.Usuario;
import br.com.valdir.usuarioservice.models.dtos.UsuarioDTO;
import br.com.valdir.usuarioservice.repositories.UsuarioRepository;
import br.com.valdir.usuarioservice.services.UsuarioService;
import br.com.valdir.usuarioservice.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;

    @Override
    public Usuario find(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(
                        format("Objeto nao encontrado. ID: %d, Tipo: %s", id, Usuario.class.getSimpleName()))
        );
    }

    @Override
    public List<Usuario> findAll() {
        return repository.findAll();
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
