package br.com.mystatement.domain.exception;

import br.com.mystatement.domain.dto.ExceptionResponseDto;
import br.com.mystatement.domain.enums.DefaultErrorParametersEnum;
import br.com.mystatement.domain.enums.ExceptionMessageEnum;
import br.com.mystatement.domain.response.ExceptionResponse;
import br.com.mystatement.utils.MessageUtils;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResponseBuilder {

    @Autowired
    private MessageUtils messageUtil;

    @Value("${info.app.name}")
    private String exceptionOrigin;


    public ExceptionResponse getFeignExceptionResponse(FeignException exception) {
        return getFeignExceptionResponseDefault(exception);
    }

    public ExceptionResponse getFeignExceptionResponseDefault(FeignException exception) {
        ExceptionResponseDto errors = getBusinessException(exception);
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .code(errors.getCode() != null ? errors.getCode() : "")
                .message(errors.getMessage() != null ? errors.getMessage()
                        : messageUtil.getMessage(ExceptionMessageEnum.BUSINESS_ERROR))
                .build();
    }

    public ExceptionResponse getBusinessExceptionResponse(BusinessException exception) {
        return ExceptionResponse.builder()
                .timestamp(LocalDateTime.now())
                .message(exception.getMessage() == null ? exception.getCause().getMessage()
                        : messageUtil.getMessage(exception.getReason()))
                .code(String.valueOf(exception.getReturnCode()))
                .build();
    }

    private ExceptionResponseDto getBusinessException(FeignException exception) {
        ObjectMapper objectMapper = new ObjectMapper();
        ExceptionResponseDto exceptionResponseDto;
        try {
            if (exception.content() != null) {
                return objectMapper
                        .readValue(exception.contentUTF8(), new TypeReference<ExceptionResponseDto>() {
                        });
            } else {
                exceptionResponseDto = createDefaultError(exception);
            }
        } catch (Exception ex) {
            exceptionResponseDto = createDefaultError(ex);
        }

        return exceptionResponseDto;
    }

    private ExceptionResponseDto createDefaultError(Exception ex) {
        return ExceptionResponseDto.builder()
                .message((ex.getMessage() == null ? ex.getCause().getMessage() : ex.getMessage()))
                .type(messageUtil.getMessage(DefaultErrorParametersEnum.ERROR_TYPE))
                .exceptionOrigin(exceptionOrigin)
                .build();
    }
}