package br.com.valdir.locacaoservice.configuration;

import br.com.valdir.locacaoservice.models.Locacao;
import br.com.valdir.locacaoservice.repositories.LocacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Configuration
@Profile("local")
public class LocalProfileConfig {

    private final LocacaoRepository repository;

    @Bean
    public void startDB() {
        repository.saveAll(List.of(
                new Locacao(
                        null,
                        1L,
                        1L,
                        150.00,
                        "Locacao cacamba para entulho",
                        LocalDate.now(),
                        null)
        ));
    }

}
