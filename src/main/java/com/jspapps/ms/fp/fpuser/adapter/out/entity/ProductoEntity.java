package com.jspapps.ms.fp.fpuser.adapter.out.entity;

import com.jspapps.ms.fp.fpuser.model.common.AccountState;
import com.jspapps.ms.fp.fpuser.model.common.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "cuenta")
public class ProductoEntity extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column private String numeroCuenta;

    @Enumerated(EnumType.STRING)
    @Column
    private AccountType tipoCuenta;

    @Column(precision = 15, scale = 2)
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    @Column
    private AccountState estado;

    @Column(name = "exenta_gmf")
    private boolean exentaGMF;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;

}
