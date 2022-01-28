package br.com.valdir.locacaoservice.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class LocacaoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long idUsuario;
    private Long idCliente;
    private String descricao;
    private Double valor;
    private LocalDate dataEmprestimo;
    private LocalDate dataEntrega;
}
