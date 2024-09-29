package com.jspapps.ms.fp.fpuser.model.producto;

import com.jspapps.ms.fp.fpuser.model.common.AccountType;
import com.jspapps.ms.fp.fpuser.model.common.BusinessRuleConstants;
import com.jspapps.ms.fp.fpuser.model.common.Utils;

public class CuentaAhorro extends Producto {

    public CuentaAhorro(double saldo, boolean exentaGMF, Long usuario) {
        super(AccountType.AHORRO, saldo, exentaGMF, usuario);
        if (saldo < BusinessRuleConstants.MIN_SALDO_CUENTA_AHORRO) {
            throw new RuntimeException(BusinessRuleConstants.MIN_SALDO_CUENTA_AHORRO_MESSAGE);
        }
    }

    @Override
    protected String generarNumeroCuenta(AccountType accountType) {
        return "53" + Utils.generarNumeroAleatorio();
    }

    @Override
    protected void validarSaldo(double nuevoSaldo) {
        if (nuevoSaldo < BusinessRuleConstants.MIN_SALDO_CUENTA_AHORRO) {
            throw new RuntimeException(BusinessRuleConstants.MIN_SALDO_CUENTA_AHORRO_MESSAGE);
        }
    }
}
