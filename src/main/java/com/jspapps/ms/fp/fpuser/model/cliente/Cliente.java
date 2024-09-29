package com.jspapps.ms.fp.fpuser.model.cliente;

import com.jspapps.ms.fp.fpuser.model.common.BusinessRuleConstants;
import com.jspapps.ms.fp.fpuser.model.common.DateUtil;
import com.jspapps.ms.fp.fpuser.model.common.ErrorCodeMessage;
import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;
import com.jspapps.ms.fp.fpuser.model.exception.BasicException;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Getter
@Setter
public class Cliente {

    private Long id;
    private IdentificationType identificationType;
    private String identificationNumber;
    private String nombres;
    private String apellidos;
    private String email;
    private int edad;
    private LocalDate birthDate;
    private boolean tieneProductosVinculados;

    public Cliente(IdentificationType identificationType, String identificationNumber, String nombres, String apellidos, String email, LocalDate birthDate) {
        init(identificationType, identificationNumber, nombres, apellidos, email, birthDate);
    }

    public Cliente(Long id, IdentificationType identificationType, String identificationNumber, String nombres, String apellidos, String email, LocalDate birthDate) {
        init(identificationType, identificationNumber, nombres, apellidos, email, birthDate);
        this.id = id;
    }

    private void init(IdentificationType identificationType, String identificationNumber, String nombres, String apellidos, String email, LocalDate birthDate) {
        validarEdad(birthDate);
        validarEmail(email);

        this.identificationType = identificationType;
        this.identificationNumber = identificationNumber;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.birthDate = birthDate;
        this.tieneProductosVinculados = false;
    }

    private void validarEdad(LocalDate birthDate) {
        int mEdad = DateUtil.getAge(birthDate);
        if (mEdad < BusinessRuleConstants.CLIENTE_EDAD_MINIMA_PERMITIDA) {
            throw new BasicException(HttpStatus.BAD_REQUEST, ErrorCodeMessage.AGE_INVALID);
        }
        this.edad = mEdad;
    }

    private void validarEmail(String email) {
        if (!email.matches(BusinessRuleConstants.CLIENTE_EMAIL_REGEX)) {
            throw new BasicException(HttpStatus.BAD_REQUEST, ErrorCodeMessage.USER_EMAIL_INVALID);
        }
    }

    public void vincularProducto() {
        this.tieneProductosVinculados = true;
    }

    public void desvincularProducto() {
        this.tieneProductosVinculados = false;
    }

}
