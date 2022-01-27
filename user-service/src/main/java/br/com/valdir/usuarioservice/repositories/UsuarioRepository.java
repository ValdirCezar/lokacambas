package br.com.valdir.usuarioservice.repositories;

import br.com.valdir.usuarioservice.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpfOuCnpj(String email);

    Optional<Usuario> findByEmail(String email);
}
