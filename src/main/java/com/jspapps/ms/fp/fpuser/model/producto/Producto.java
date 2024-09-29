package com.jspapps.ms.fp.fpuser.model.producto;

import com.jspapps.ms.fp.fpuser.model.common.AccountState;
import com.jspapps.ms.fp.fpuser.model.common.AccountType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class Producto {

    private final String numeroCuenta;
    private final AccountType tipoCuenta;
    private AccountState estado;
    private double saldo;
    private final boolean exentaGMF;
    private final LocalDateTime fechaCreacion;
    private LocalDateTime fechaModificacion;
    private final Long usuario;

    public Producto(AccountType accountType, double saldo, boolean exentaGMF, Long usuario) {
        this.tipoCuenta = accountType;
        this.numeroCuenta = generarNumeroCuenta(accountType);
        this.saldo = saldo;
        this.exentaGMF = exentaGMF;
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = this.fechaCreacion;
        this.usuario = usuario;
        this.estado = AccountState.ACTIVA;
    }

    protected abstract String generarNumeroCuenta(AccountType accountType);

    public void activarCuenta() {
        this.estado = AccountState.ACTIVA;
        actualizarFechaModificacion();
    }

    public void inactivarCuenta() {
        this.estado = AccountState.INACTIVA;
        actualizarFechaModificacion();
    }

    public void cancelarCuenta() {
        if (saldo == 0) {
            this.estado = AccountState.CANCELADA;
            actualizarFechaModificacion();
        } else {
            throw new RuntimeException("No se puede cancelar la cuenta. El saldo debe ser 0.");
        }
    }

    public void actualizarSaldo(double nuevoSaldo) {
        validarSaldo(nuevoSaldo);
        this.saldo = nuevoSaldo;
        actualizarFechaModificacion();
    }

    protected void actualizarFechaModificacion() {
        this.fechaModificacion = LocalDateTime.now();
    }

    protected void validarSaldo(double nuevoSaldo) throws RuntimeException {

    }

}
