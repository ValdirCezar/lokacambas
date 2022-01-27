package br.com.valdir.usuarioservice.services.impl;

import br.com.valdir.usuarioservice.models.Usuario;
import br.com.valdir.usuarioservice.models.dtos.UsuarioDTO;
import br.com.valdir.usuarioservice.repositories.UsuarioRepository;
import br.com.valdir.usuarioservice.services.UsuarioService;
import br.com.valdir.usuarioservice.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repository;
    private final ModelMapper mapper;

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
        objDTO.setId(null);
        verifyIfEmailAndCpfOuCnpjAlreadyExists(objDTO);
        return repository.save(mapper.map(objDTO, Usuario.class));
    }

    @Override
    public Usuario update(UsuarioDTO objDTO, Long id) {
        return null;
    }

    public void verifyIfEmailAndCpfOuCnpjAlreadyExists(UsuarioDTO dto) {
        Optional<Usuario> obj = repository.findByCpfOuCnpj(dto.getCpfOuCnpj());
        if (obj.isPresent() && !obj.get().getId().equals(dto.getId())) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }

        obj = repository.findByEmail(dto.getEmail());
        if (obj.isPresent() && !obj.get().getId().equals(dto.getId())) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }

}
