package br.com.valdir.cacambaservice.services.impl;

import br.com.valdir.cacambaservice.models.Cacamba;
import br.com.valdir.cacambaservice.models.dtos.CacambaDTO;
import br.com.valdir.cacambaservice.repositories.CacambaRepository;
import br.com.valdir.cacambaservice.services.CacambaService;
import br.com.valdir.cacambaservice.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class CacambaServiceImpl implements CacambaService {

    private final CacambaRepository repository;
    private final ModelMapper mapper;

    @Override
    public Cacamba find(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(
                        format("Objeto nao encontrado. ID: %d, Tipo: %s", id, Cacamba.class.getSimpleName()))
        );
    }

    @Override
    public List<Cacamba> findAll() {
        return repository.findAll();
    }

    @Override
    public Cacamba create(CacambaDTO objDTO) {
        objDTO.setId(null);
        return repository.save(mapper.map(objDTO, Cacamba.class));
    }

    @Override
    public Cacamba update(CacambaDTO objDTO, Long id) {
        objDTO.setId(id);
        return repository.save(mapper.map(objDTO, find(id).getClass()));
    }

}
