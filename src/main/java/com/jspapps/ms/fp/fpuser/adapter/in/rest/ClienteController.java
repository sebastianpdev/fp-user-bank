package com.jspapps.ms.fp.fpuser.adapter.in.rest;

import com.jspapps.ms.fp.fpuser.application.port.in.CreateClienteUseCase;
import com.jspapps.ms.fp.fpuser.application.port.in.UpdateClienteUseCase;
import com.jspapps.ms.fp.fpuser.model.cliente.CreateClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.UpdateClientDTO;
import com.jspapps.ms.fp.fpuser.model.common.APIServiceOperation;
import com.jspapps.ms.fp.fpuser.model.common.APIServiceStatusCode;
import com.jspapps.ms.fp.fpuser.model.response.BaseServiceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;
    private final UpdateClienteUseCase updateClienteUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseServiceResponse<Void>> crearCliente(@RequestBody CreateClientDTO createClientDTO) {
        createClienteUseCase.crearCliente(createClientDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseServiceResponse.<Void>builder()
                .serviceName(APIServiceOperation.OPERATION_CREATE_CLIENTE).statusCode(APIServiceStatusCode.OK.getStatusCode())
                .build());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseServiceResponse<DetailClientDTO>> actualizarCliente(@RequestBody UpdateClientDTO updateClientDTO) {
        return ResponseEntity.ok(BaseServiceResponse.<DetailClientDTO>builder()
                        .serviceName(APIServiceOperation.OPERATION_UPDATE_CLIENTE).statusCode(APIServiceStatusCode.OK.getStatusCode())
                        .data(updateClienteUseCase.actualizarCliente(updateClientDTO))
                .build());
    }
}
