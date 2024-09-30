package com.jspapps.ms.fp.fpuser.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BaseServiceResponse<T> {

    private String serviceName;
    private int statusCode;
    private T data;
}
