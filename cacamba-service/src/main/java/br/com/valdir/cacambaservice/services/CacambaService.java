package br.com.valdir.cacambaservice.services;

import br.com.valdir.cacambaservice.models.Cacamba;
import br.com.valdir.cacambaservice.models.dtos.CacambaDTO;

import java.util.List;

public interface CacambaService {

    Cacamba find(Long id);
    List<Cacamba> findAll();
    Cacamba create(CacambaDTO objDTO);
    Cacamba update(CacambaDTO objDTO, Long id);
}
