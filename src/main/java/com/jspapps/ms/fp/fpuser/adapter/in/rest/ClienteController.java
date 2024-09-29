package com.jspapps.ms.fp.fpuser.adapter.in.rest;

import com.jspapps.ms.fp.fpuser.application.port.in.CreateClienteUseCase;
import com.jspapps.ms.fp.fpuser.model.cliente.CreateClientDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void crearCliente(@RequestBody CreateClientDTO createClientDTO) {
        createClienteUseCase.crearCliente(createClientDTO);
    }
}
