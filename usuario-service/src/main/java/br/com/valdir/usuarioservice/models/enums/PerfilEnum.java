package br.com.valdir.usuarioservice.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum PerfilEnum {

    ADMIN("ADMIN"),
    OPERADOR("OPERADOR"),
    CLIENTE("CLIENTE");

    @Getter
    private String descricao;

    public static PerfilEnum getPerfilEnum(String descricao) {
        if(descricao == null) return null;

        for (PerfilEnum x : PerfilEnum.values()) {
            if (x.getDescricao().equals(descricao)) {
                return x;
            }
        }

        throw new IllegalArgumentException(descricao);
    }
}
