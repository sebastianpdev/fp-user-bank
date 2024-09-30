package com.jspapps.ms.fp.fpuser.application.service;

import com.jspapps.ms.fp.fpuser.application.port.out.IClientePersistence;
import com.jspapps.ms.fp.fpuser.model.cliente.Cliente;
import com.jspapps.ms.fp.fpuser.model.cliente.CreateClientDTO;
import com.jspapps.ms.fp.fpuser.model.common.ErrorCodeMessage;
import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;
import com.jspapps.ms.fp.fpuser.model.exception.BasicException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private IClientePersistence clientePersistence;

    private CreateClientDTO mockCreateClienteDTO() {
        return new CreateClientDTO(
                IdentificationType.CC, "11111", "Hernan", "Diaz",
                "hernan.diaz@gmail.com", LocalDate.of(1995, 12, 1));
    }

    private CreateClientDTO mockCreateClienteMenorDTO() {
        return new CreateClientDTO(
                IdentificationType.CC, "11111", "Hernan", "Diaz",
                "hernan.diaz@gmail.com", LocalDate.of(2020, 12, 1));
    }

    @Test
    void givenCreateClienteCommand_createClienteSuccessfully() {
        doNothing().when(clientePersistence).crearCliente(any(Cliente.class));
        clienteService.crearCliente(mockCreateClienteDTO());
        verify(clientePersistence, times(1)).crearCliente(any(Cliente.class));
    }

    @Test
    void givenCreateClienteCommand_createClienteFailureWith() {
        BasicException edadException = assertThrows(BasicException.class, () -> {
            lenient().doNothing().when(clientePersistence).crearCliente(any(Cliente.class));
            clienteService.crearCliente(mockCreateClienteMenorDTO());
        });

        assertEquals(ErrorCodeMessage.AGE_INVALID.toStringCode(), edadException.getError());
    }




}
