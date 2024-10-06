package com.jspapps.ms.fp.fpuser.model.producto;

import com.jspapps.ms.fp.fpuser.model.common.AccountState;
import com.jspapps.ms.fp.fpuser.model.common.AccountType;
import com.jspapps.ms.fp.fpuser.model.common.ErrorCodeMessage;
import com.jspapps.ms.fp.fpuser.model.exception.BasicException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public abstract class Producto {

    private Long id;
    private final String numeroCuenta;
    private final AccountType tipoCuenta;
    private AccountState estado;
    private double saldo;
    private final boolean exentaGMF;
    private final Long usuario;

    public Producto(AccountType accountType, double saldo, boolean exentaGMF, Long usuario) {
        this.tipoCuenta = accountType;
        this.numeroCuenta = generarNumeroCuenta(accountType);
        this.saldo = saldo;
        this.exentaGMF = exentaGMF;
        this.usuario = usuario;
        this.estado = AccountState.ACTIVA;
    }

    protected abstract String generarNumeroCuenta(AccountType accountType);

    public void activarCuenta() {
        this.estado = AccountState.ACTIVA;
    }

    public void inactivarCuenta() {
        this.estado = AccountState.INACTIVA;
    }

    public void cancelarCuenta() {
        if (saldo == 0) {
            this.estado = AccountState.CANCELADA;
        } else {
            throw new BasicException(HttpStatus.BAD_REQUEST, ErrorCodeMessage.ACCOUNT_CANCELED_REQUEST);
        }
    }

    public void actualizarSaldo(double nuevoSaldo) {
        validarSaldo(nuevoSaldo);
        this.saldo = nuevoSaldo;
    }

    protected void validarSaldo(double nuevoSaldo) throws RuntimeException {

    }

}
