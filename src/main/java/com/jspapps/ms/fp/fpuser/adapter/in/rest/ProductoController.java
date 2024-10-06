package com.jspapps.ms.fp.fpuser.adapter.in.rest;

import com.jspapps.ms.fp.fpuser.application.port.in.CreateProductoUseCase;
import com.jspapps.ms.fp.fpuser.model.common.APIServiceOperation;
import com.jspapps.ms.fp.fpuser.model.common.APIServiceStatusCode;
import com.jspapps.ms.fp.fpuser.model.producto.CreateProductoDTO;
import com.jspapps.ms.fp.fpuser.model.response.BaseServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/producto")
public class ProductoController {

    private final CreateProductoUseCase createProductoUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseServiceResponse<Void>> crearProducto(@RequestBody CreateProductoDTO createProductoDTO) {
        createProductoUseCase.crearProducto(createProductoDTO);
        return ResponseEntity.status(201).body(BaseServiceResponse.<Void>builder()
                .serviceName(APIServiceOperation.OPERATION_CREATE_PRODUCTO).statusCode(APIServiceStatusCode.OK.getStatusCode())
                .build());
    }

}
