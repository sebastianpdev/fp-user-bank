package com.jspapps.ms.fp.fpuser.application.port.out;

import com.jspapps.ms.fp.fpuser.model.cliente.Cliente;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;

public interface IClientePersistence {

    void crearCliente(Cliente cliente);
    DetailClientDTO actualizarCliente(Cliente cliente);
    DetailClientDTO findCliente(Long id);
    boolean existsCliente(Long id);
}
