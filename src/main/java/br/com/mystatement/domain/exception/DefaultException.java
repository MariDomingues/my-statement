package br.com.mystatement.domain.exception;

import br.com.mystatement.domain.enums.ExceptionMessageEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class DefaultException extends RuntimeException {

    private static final long serialVersionUID = -7963947217892566012L;

    private final ExceptionMessageEnum reason;
    private final HttpStatus status;
    private final String reasonText;

    /**
     * @param status the HTTP response status code
     * @param reason the exception message
     * @param cause  the error cause
     */
    public DefaultException(HttpStatus status, ExceptionMessageEnum reason, Throwable cause) {
        super(reason.getMessageKey(), cause);
        this.status = status;
        this.reason = reason;
        this.reasonText = null;
    }

    /**
     * @param status the HTTP response status code
     * @param reason the exception message
     */
    public DefaultException(HttpStatus status, ExceptionMessageEnum reason) {
        super(reason.getMessageKey());
        this.status = status;
        this.reason = reason;
        this.reasonText = null;
    }

    /**
     * @param reason the exception message
     */
    public DefaultException(ExceptionMessageEnum reason) {
        super(reason.getMessageKey());
        this.status = HttpStatus.INTERNAL_SERVER_ERROR;
        this.reason = reason;
        this.reasonText = null;
    }

    public DefaultException(HttpStatus status, String reason, Throwable cause) {
        super(reason, cause);
        this.status = status;
        this.reason = null;
        this.reasonText = reason;
    }
}
