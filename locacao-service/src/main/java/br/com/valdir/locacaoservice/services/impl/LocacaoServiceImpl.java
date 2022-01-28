package br.com.valdir.locacaoservice.services.impl;

import br.com.valdir.locacaoservice.models.Locacao;
import br.com.valdir.locacaoservice.models.dtos.LocacaoDTO;
import br.com.valdir.locacaoservice.repositories.LocacaoRepository;
import br.com.valdir.locacaoservice.services.LocacaoService;
import br.com.valdir.locacaoservice.services.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@RequiredArgsConstructor
@Service
public class LocacaoServiceImpl implements LocacaoService {

    private final LocacaoRepository repository;
    private final ModelMapper mapper;

    @Override
    public Locacao find(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new ObjectNotFoundException(
                        format("Objeto nao encontrado. ID: %d, Tipo: %s", id, Locacao.class.getSimpleName()))
        );
    }

    @Override
    public List<Locacao> findAll() {
        return repository.findAll();
    }

    @Override
    public Locacao create(LocacaoDTO objDTO) {
        objDTO.setId(null);
        return repository.save(mapper.map(objDTO, Locacao.class));
    }

    @Override
    public Locacao update(LocacaoDTO objDTO, Long id) {
        objDTO.setId(id);
        return repository.save(mapper.map(objDTO, find(id).getClass()));
    }

}
