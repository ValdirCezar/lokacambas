package br.com.valdir.usuarioservice.services;

import br.com.valdir.usuarioservice.models.Usuario;
import br.com.valdir.usuarioservice.models.dtos.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

    Usuario find(Long id);
    List<Usuario> findAll(Long id);
    Usuario create(UsuarioDTO objDTO);
    Usuario update(UsuarioDTO objDTO, Long id);
}
