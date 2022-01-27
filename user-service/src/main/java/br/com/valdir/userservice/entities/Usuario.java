package br.com.valdir.userservice.entities;

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
@Entity(name = "TB_USUARIO")
public class Usuario {

    @Include
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String nome;
    private String cpfOuCnpj;
    private String email;
    private String senha;

}
