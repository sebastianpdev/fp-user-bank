package com.jspapps.ms.fp.fpuser.adapter.out.mapper;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ClienteEntity;
import com.jspapps.ms.fp.fpuser.model.cliente.Cliente;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ClienteMapper extends EntityMapper<Cliente, ClienteEntity> {

    ClienteEntity toEntity(Cliente cliente);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateProductoSaved(ClienteEntity clienteUpdated, @MappingTarget ClienteEntity clienteSaved);

    @Mappings({
            @Mapping(source = "nombres", target = "nombre"),
            @Mapping(source = "apellidos", target = "apellido"),
            @Mapping(source = "dateCreated", target = "fechaCreacion"),
            @Mapping(source = "dateModified", target = "fechaModificacion")
    })
    DetailClientDTO toDetailClientDTO(ClienteEntity cliente);

    default ClienteEntity fromId(Long id) {
        if (id == null) {
            return null;
        }

        ClienteEntity cliente = new ClienteEntity();
        cliente.setId(id);
        return cliente;
    }
}
