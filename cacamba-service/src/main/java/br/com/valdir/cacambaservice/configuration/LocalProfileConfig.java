package br.com.valdir.cacambaservice.configuration;

import br.com.valdir.cacambaservice.models.Cacamba;
import br.com.valdir.cacambaservice.repositories.CacambaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("local")
public class LocalProfileConfig {

    private final CacambaRepository repository;

    @Bean
    public void startDB() {
        repository.saveAll(List.of(
                new Cacamba(null, "Cacamba vermelha", 150.50, true)
        ));
    }

}
