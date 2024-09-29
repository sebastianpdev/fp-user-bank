package com.jspapps.ms.fp.fpuser.model.producto;

import com.jspapps.ms.fp.fpuser.model.common.AccountType;
import com.jspapps.ms.fp.fpuser.model.common.Utils;

public class CuentaCorriente extends Producto {

    public CuentaCorriente(double saldo, boolean exentaGMF, Long usuario) {
        super(AccountType.CORRIENTE, saldo, exentaGMF, usuario);
    }

    @Override
    protected String generarNumeroCuenta(AccountType accountType) {
        return "33" + Utils.generarNumeroAleatorio();
    }
}
