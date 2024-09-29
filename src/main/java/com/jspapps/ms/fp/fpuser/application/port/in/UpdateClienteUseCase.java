package com.jspapps.ms.fp.fpuser.application.port.in;

import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.UpdateClientDTO;

public interface UpdateClienteUseCase {

    DetailClientDTO actualizarCliente(UpdateClientDTO updateClientDTO);
}
