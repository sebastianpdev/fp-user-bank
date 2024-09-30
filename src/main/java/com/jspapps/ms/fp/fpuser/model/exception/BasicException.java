package com.jspapps.ms.fp.fpuser.model.exception;

import com.jspapps.ms.fp.fpuser.model.common.ErrorCodeMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BasicException extends ServiceInvocationException {

    private static final long serialVersionUID = -21564845555522L;

    private static final String ERROR_MESSAGE = "Code: [%s] Message: %s";
    private final String error;
    private final String message;

    public BasicException(HttpStatus httpStatus, ErrorCodeMessage errorCodeMessage) {
        super(httpStatus.value(), String.format(ERROR_MESSAGE, errorCodeMessage.getCode(), errorCodeMessage.getMessage()));
        this.error = errorCodeMessage.toStringCode();
        this.message = errorCodeMessage.getMessage();
    }

    public BasicException(HttpStatus httpStatus, String message) {
        super(httpStatus.value(), message);
        this.error = "999";
        this.message = message;
    }

}
