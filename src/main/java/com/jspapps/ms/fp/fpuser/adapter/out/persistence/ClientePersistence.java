package com.jspapps.ms.fp.fpuser.adapter.out.persistence;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ClienteEntity;
import com.jspapps.ms.fp.fpuser.adapter.out.mapper.ClienteMapper;
import com.jspapps.ms.fp.fpuser.adapter.out.repository.ClienteRepository;
import com.jspapps.ms.fp.fpuser.adapter.util.annotation.PersistenceAdapter;
import com.jspapps.ms.fp.fpuser.application.port.out.IClientePersistence;
import com.jspapps.ms.fp.fpuser.model.cliente.Cliente;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import com.jspapps.ms.fp.fpuser.model.common.ErrorCodeMessage;
import com.jspapps.ms.fp.fpuser.model.exception.BasicException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

@PersistenceAdapter
@AllArgsConstructor
public class ClientePersistence implements IClientePersistence {

    private final ClienteMapper clienteMapper;
    private final ClienteRepository clienteRepository;

    @Override
    public void crearCliente(Cliente cliente) {
        ClienteEntity newClient = clienteMapper.toCliente(cliente);
        clienteRepository.save(newClient);
    }

    @Override
    public DetailClientDTO actualizarCliente(Cliente cliente) {
        try {
            ClienteEntity clientStored = clienteRepository.findById(cliente.getId()).orElse(null);
            if (clientStored == null) {
                throw new BasicException(HttpStatus.NOT_FOUND, ErrorCodeMessage.USER_NOT_FOUND);
            }

            ClienteEntity clientUpdated = clienteMapper.toCliente(cliente);
            clienteMapper.updateCliente(clientStored, clientUpdated);
            clientStored = clienteRepository.save(clientStored);
            return clienteMapper.toDetailCliente(clientStored);
        } catch (DataAccessException e) {
            throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodeMessage.USER_DATA_ERROR);
        }
    }
}
