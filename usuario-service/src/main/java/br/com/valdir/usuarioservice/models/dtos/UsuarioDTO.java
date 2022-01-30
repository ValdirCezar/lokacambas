package br.com.valdir.usuarioservice.models.dtos;

import br.com.valdir.usuarioservice.models.enums.PerfilEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "O campo NOME deve ser informado")
    @Size(min = 3, max = 100, message = "O campo NOME deve ter entre 3 e 100 caracteres")
    private String nome;

    @NotEmpty(message = "O campo CPF ou CNPJ deve ser informado")
    private String cpfOuCnpj;

    @NotEmpty(message = "O campo E-MAIL deve ser informado")
    @Email
    private String email;

    @NotEmpty(message = "O campo SENHA deve ser informado")
    private String senha;

    private PerfilEnum perfil = PerfilEnum.CLIENTE;
}
