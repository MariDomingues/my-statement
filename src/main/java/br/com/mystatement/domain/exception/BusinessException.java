package br.com.mystatement.domain.exception;

import br.com.mystatement.domain.enums.ExceptionMessageEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Class responsible for service layer exception mapping. Deals with HTTP response status codes and
 * business messages.
 */
@Getter
public class BusinessException extends DefaultException {

    private final Integer returnCode;
    private final String messageCode;
    private final String returnMessage;

    public BusinessException(Integer status, ExceptionMessageEnum reason, Integer returnCode,
                             String messageCode, String returnMessage) {
        super(HttpStatus.valueOf(status), reason);
        this.returnCode = returnCode;
        this.messageCode = messageCode;
        this.returnMessage = returnMessage;
    }
}
