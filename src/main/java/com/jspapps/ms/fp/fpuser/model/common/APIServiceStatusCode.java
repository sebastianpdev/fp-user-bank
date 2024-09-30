package com.jspapps.ms.fp.fpuser.model.common;

import lombok.Getter;

@Getter
public enum APIServiceStatusCode {

    OK(0, "Operacion terminada satisfactoriamente");

    private final int statusCode;
    private final String statusDescription;

    APIServiceStatusCode(int statusCode, String statusDescription) {
        this.statusCode = statusCode;
        this.statusDescription = statusDescription;
    }

}
