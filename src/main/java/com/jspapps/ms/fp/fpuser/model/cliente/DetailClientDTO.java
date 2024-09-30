package com.jspapps.ms.fp.fpuser.model.cliente;

import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;

import java.sql.Timestamp;
import java.time.LocalDate;

public record DetailClientDTO(
        Long id,
        IdentificationType identificationType,
        String identificationNumber,
        String nombre,
        String apellido,
        String email,
        LocalDate birthDate,
        Timestamp fechaCreacion,
        Timestamp fechaModificacion
) {
}
