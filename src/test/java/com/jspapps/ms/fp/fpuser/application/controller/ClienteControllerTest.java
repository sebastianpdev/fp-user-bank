package com.jspapps.ms.fp.fpuser.application.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jspapps.ms.fp.fpuser.adapter.in.rest.ClienteController;
import com.jspapps.ms.fp.fpuser.application.port.in.CreateClienteUseCase;
import com.jspapps.ms.fp.fpuser.application.port.in.UpdateClienteUseCase;
import com.jspapps.ms.fp.fpuser.model.cliente.CreateClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.DetailClientDTO;
import com.jspapps.ms.fp.fpuser.model.cliente.UpdateClientDTO;
import com.jspapps.ms.fp.fpuser.model.common.APIServiceOperation;
import com.jspapps.ms.fp.fpuser.model.common.APIServiceStatusCode;
import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;

import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.mockito.Mockito.when;

@AutoConfigureMockMvc(addFilters = false)
@MockBean(AuditingEntityListener.class)
@WebMvcTest(ClienteController.class)
class ClienteControllerTest {

    @Autowired private MockMvc mockMvc;
    @MockBean private CreateClienteUseCase createClienteUseCase;
    @MockBean private UpdateClienteUseCase updateClienteUseCase;
    @Autowired private ObjectMapper objectMapper;

    private CreateClientDTO createClientDTO;
    private UpdateClientDTO updateClientDTO;
    private DetailClientDTO detailClientDTO;

    @BeforeEach
    void init() {
        createClientDTO = new CreateClientDTO(IdentificationType.CC, "11111", "Hernan", "Diaz", "hernan.diaz@gmail.com",
                LocalDate.of(1995, 12, 1));

        updateClientDTO = new UpdateClientDTO(33L, IdentificationType.CC, "11111", "Hernan", "Diaz", "hernan.diaz@gmail.com",
                LocalDate.of(1995, 12, 1));

        detailClientDTO = new DetailClientDTO(33L, IdentificationType.CC, "11111", "Hernan", "Diaz", "hernan.diaz@gmail.com",
                LocalDate.of(1995, 12, 1), Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
    }

    @Test
    void crearClienteShouldReturnCreated() throws Exception {
        doNothing().when(createClienteUseCase).crearCliente(createClientDTO);

        String createJson = objectMapper.writeValueAsString(createClientDTO);
        mockMvc.perform(post("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(createJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.serviceName").value(APIServiceOperation.OPERATION_CREATE_CLIENTE))
                .andExpect(jsonPath("$.statusCode").value(APIServiceStatusCode.OK.getStatusCode()));
    }

    @Test
    void actualizarClienteShouldReturnOK() throws Exception {
        when(updateClienteUseCase.actualizarCliente(updateClientDTO)).thenReturn(detailClientDTO);

        String updateJson = objectMapper.writeValueAsString(updateClientDTO);
        mockMvc.perform(put("/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(updateJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.serviceName").value(APIServiceOperation.OPERATION_UPDATE_CLIENTE))
                .andExpect(jsonPath("$.statusCode").value(APIServiceStatusCode.OK.getStatusCode()))
                .andExpect(jsonPath("$.data.id").value(33L))
                .andExpect(jsonPath("$.data.identificationNumber").value(11111));
    }

}
