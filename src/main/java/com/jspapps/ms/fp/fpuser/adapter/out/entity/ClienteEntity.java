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

    @Column private IdentificationType identificationType;

    @Column private String identificationNumber;

    @Column private String nombres;

    @Column private String apellidos;

    @Column private String email;

    @Column private int edad;

    @Column private LocalDate birthDate;
}
