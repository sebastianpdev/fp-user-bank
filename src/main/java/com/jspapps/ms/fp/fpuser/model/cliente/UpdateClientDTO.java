package com.jspapps.ms.fp.fpuser.model.cliente;

import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;

import java.time.LocalDate;

public record UpdateClientDTO(
        Long id,
        IdentificationType identificationType,
        String identificationNumber,
        String nombre,
        String apellido,
        String email,
        LocalDate birthDate
) {

    public Cliente toCliente() {
        return new Cliente(id, identificationType, identificationNumber, nombre, apellido, email, birthDate);
    }
}
