package com.jspapps.ms.fp.fpuser.model.cliente;

import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record DetailClientDTO(
        Long id,
        IdentificationType identificationType,
        String identificationNumber,
        String nombre,
        String apellido,
        String email,
        LocalDate birthDate,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaModificacion
) {
}
