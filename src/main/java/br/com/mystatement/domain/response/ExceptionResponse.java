package br.com.mystatement.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Builder
@ApiModel(description = "Resposta das exceções retornadas pela validações do servidor/aplicação")
public class ExceptionResponse {

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @ApiModelProperty(name = "timestamp", value = "Data/Hora formato[ISO: yyyy-MM-dd'T'HH:mm:ss.SSSZ]", example = "2022-09-26T01:30:00.000-03:00")
    private LocalDateTime timestamp;

    @ApiModelProperty(name = "message", value = "Descrição do erro", example = "CODIGO DE BARRAS INVALIDO")
    private String message;

    @ApiModelProperty(name = "code", value = "Código do erro ", example = "E5500")
    private String code;

}

