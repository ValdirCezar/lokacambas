package br.com.valdir.locacaoservice.services;

import br.com.valdir.locacaoservice.models.Locacao;
import br.com.valdir.locacaoservice.models.dtos.LocacaoDTO;

import java.util.List;

public interface LocacaoService {

    Locacao find(Long id);
    List<Locacao> findAll();
    Locacao create(LocacaoDTO objDTO);
    Locacao update(LocacaoDTO objDTO, Long id);
}
