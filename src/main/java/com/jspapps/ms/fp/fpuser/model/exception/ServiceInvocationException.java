package com.jspapps.ms.fp.fpuser.model.exception;

import lombok.Getter;

@Getter
public class ServiceInvocationException extends RuntimeException {

    private final int httpStatusCode;

    private final String body;

    public ServiceInvocationException(int httpStatusCode, String body) {
        this.httpStatusCode = httpStatusCode;
        this.body = body;
    }

}
