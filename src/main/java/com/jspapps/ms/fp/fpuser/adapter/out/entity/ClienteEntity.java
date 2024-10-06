package com.jspapps.ms.fp.fpuser.adapter.out.entity;

import com.jspapps.ms.fp.fpuser.model.common.IdentificationType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cliente")
public class ClienteEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_identificacion")
    private IdentificationType identificationType;

    @Column(name = "identificacion")
    private String identificationNumber;

    @Column private String nombres;

    @Column private String apellidos;

    @Column private String email;

    @Column private int edad;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    public ClienteEntity id(Long id) {
        this.id = id;
        return this;
    }
}
