package com.jspapps.ms.fp.fpuser.model.producto;

import com.jspapps.ms.fp.fpuser.model.common.AccountType;

public record CreateProductoDTO(
        AccountType tipoCuenta,
        double saldo,
        boolean exentaGMF,
        Long usuario
) {

    public Producto toProducto() {
        if (tipoCuenta.equals(AccountType.AHORRO)) {
            return new CuentaAhorro(saldo, exentaGMF, usuario);
        } else {
            return new CuentaCorriente(saldo, exentaGMF, usuario);
        }
    }
}
