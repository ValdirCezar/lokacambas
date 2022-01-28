package br.com.valdir.cacambaservice.models.dtos;

import br.com.valdir.cacambaservice.models.enums.TamanhoEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CacambaDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotBlank(message = "O campo NOME deve ser informado")
    private String descricao;
    private Double preco;
    private Boolean disponivel;
    private TamanhoEnum tamanho;
}
