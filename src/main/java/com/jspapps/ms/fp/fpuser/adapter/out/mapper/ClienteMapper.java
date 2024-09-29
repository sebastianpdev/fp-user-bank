package com.jspapps.ms.fp.fpuser.adapter.out.mapper;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ClienteEntity;
import com.jspapps.ms.fp.fpuser.model.cliente.Cliente;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteEntity toCliente(Cliente cliente) {
        return ClienteEntity.builder()
                .id(cliente.getId() != null ? cliente.getId() : null)
                .identificationType(cliente.getIdentificationType())
                .identificationNumber(cliente.getIdentificationNumber())
                .nombres(cliente.getNombres())
                .apellidos(cliente.getApellidos())
                .email(cliente.getEmail())
                .edad(cliente.getEdad())
                .birthDate(cliente.getBirthDate())
                .build();
    }

    public DetailClientDTO toDetailCliente(ClienteEntity clienteEntity) {
        return new DetailClientDTO(
                clienteEntity.getId(),
                clienteEntity.getIdentificationType(),
                clienteEntity.getIdentificationNumber(),
                clienteEntity.getNombres(),
                clienteEntity.getApellidos(),
                clienteEntity.getEmail(),
                clienteEntity.getBirthDate(),
                clienteEntity.getDateCreated(),
                clienteEntity.getDateModified()
                );
    }
}
