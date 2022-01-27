package br.com.valdir.userservice.services.impl;

import br.com.valdir.userservice.models.Usuario;
import br.com.valdir.userservice.models.dtos.UsuarioDTO;

import java.util.List;

public interface UserService {

    Usuario find(Long id);
    List<Usuario> findAll(Long id);
    Usuario create(UsuarioDTO objDTO);
    Usuario update(UsuarioDTO objDTO, Long id);
}
