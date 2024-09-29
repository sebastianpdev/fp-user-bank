package com.jspapps.ms.fp.fpuser.application.port.in;

import com.jspapps.ms.fp.fpuser.model.cliente.CreateClientDTO;

public interface CreateClienteUseCase {

    void crearCliente(CreateClientDTO createClientDTO);
}
