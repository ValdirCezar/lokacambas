package br.com.valdir.cacambaservice.models.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TamanhoEnum {

    PEQUENA("PEQUENA"),
    MEDIA("MEDIA"),
    GRANDE("GRANDE");

    @Getter
    private String descricao;

    public static TamanhoEnum getPerfilEnum(String descricao) {
        if(descricao == null) return null;

        for (TamanhoEnum x : TamanhoEnum.values()) {
            if (x.getDescricao().equals(descricao)) {
                return x;
            }
        }

        throw new IllegalArgumentException(descricao);
    }
}
