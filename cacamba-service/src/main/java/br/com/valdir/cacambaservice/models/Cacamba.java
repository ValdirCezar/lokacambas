package br.com.valdir.cacambaservice.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.EqualsAndHashCode.Include;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_CACAMBA")
public class Cacamba {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String descricao;
    private Double preco;
    private Boolean disponivel;
}
