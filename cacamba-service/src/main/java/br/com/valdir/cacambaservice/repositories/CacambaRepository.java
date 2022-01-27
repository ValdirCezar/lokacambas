package br.com.valdir.cacambaservice.repositories;

import br.com.valdir.cacambaservice.models.Cacamba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CacambaRepository extends JpaRepository<Cacamba, Long> {

}
