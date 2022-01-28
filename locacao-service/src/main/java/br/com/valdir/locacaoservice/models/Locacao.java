package br.com.valdir.locacaoservice.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;
import static lombok.EqualsAndHashCode.Include;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "TB_LOCACAO")
public class Locacao {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private Long idUsuario;
    private Long idCliente;
    private Double valor;
    private String descricao;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;
}
