package br.com.mystatement.domain.exception.handler;

import br.com.mystatement.domain.exception.BusinessException;
import br.com.mystatement.domain.exception.ExceptionResponseBuilder;
import br.com.mystatement.domain.response.ExceptionResponse;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    private ExceptionResponseBuilder responseBuilder;

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ExceptionResponse> handleFeignException(FeignException exception) {
        ExceptionResponse exceptionResponse = responseBuilder.getFeignExceptionResponse(exception);
        log.error(exceptionResponse.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(exceptionResponse);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ExceptionResponse> handleBusinessException(BusinessException exception) {
        ExceptionResponse exceptionResponse = responseBuilder.getBusinessExceptionResponse(exception);
        log.error(exceptionResponse.getMessage(), exception);

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY.value()).body(exceptionResponse);
    }

}