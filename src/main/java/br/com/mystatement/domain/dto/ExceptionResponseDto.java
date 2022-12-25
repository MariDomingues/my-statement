package br.com.mystatement.domain.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExceptionResponseDto {

    @JsonAlias({"mensagem", "mensagemDeRetorno"})
    private String message;

    private String type;
    private String exceptionOrigin;

    @JsonAlias({"codigoErro", "codigo", "codigoMensagem"})
    private String code;
}