package com.jspapps.ms.fp.fpuser.application.service;

import com.jspapps.ms.fp.fpuser.application.port.in.CreateClienteUseCase;
import com.jspapps.ms.fp.fpuser.application.port.in.FindClienteUseCase;
import com.jspapps.ms.fp.fpuser.application.port.in.UpdateClienteUseCase;
import com.jspapps.ms.fp.fpuser.application.port.out.IClientePersistence;
import com.jspapps.ms.fp.fpuser.model.cliente.Cliente;
import com.jspapps.ms.fp.fpuser.model.cliente.CreateClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.UpdateClientDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@AllArgsConstructor
public class ClienteService implements CreateClienteUseCase, UpdateClienteUseCase, FindClienteUseCase {

    private final IClientePersistence clientePersistence;

    @Override
    public void crearCliente(CreateClientDTO createClientDTO) {
        Cliente newCliente = createClientDTO.toCliente();
        clientePersistence.crearCliente(newCliente);
    }

    @Override
    public DetailClientDTO actualizarCliente(UpdateClientDTO updateClientDTO) {
        Cliente cliente = updateClientDTO.toCliente();
        return clientePersistence.actualizarCliente(cliente);
    }

    @Override
    public boolean existsCliente(Long id) {
        return clientePersistence.existsCliente(id);
    }
}

