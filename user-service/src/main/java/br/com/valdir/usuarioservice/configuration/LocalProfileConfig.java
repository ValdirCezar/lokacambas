package br.com.valdir.usuarioservice.configuration;

import br.com.valdir.usuarioservice.models.Usuario;
import br.com.valdir.usuarioservice.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("local")
public class LocalProfileConfig {

    private final UsuarioRepository repository;

    @Bean
    public void startDB() {
        repository.saveAll(List.of(
                new Usuario(null, "Valdir Cezar", "39338690059", "valdir@mail.com", "123")
        ));
    }
}
