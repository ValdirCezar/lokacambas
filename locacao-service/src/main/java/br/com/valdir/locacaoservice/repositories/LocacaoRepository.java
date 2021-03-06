package br.com.valdir.locacaoservice.repositories;

import br.com.valdir.locacaoservice.models.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

}
