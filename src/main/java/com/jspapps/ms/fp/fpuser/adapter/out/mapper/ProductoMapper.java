package com.jspapps.ms.fp.fpuser.adapter.out.mapper;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ClienteEntity;
import com.jspapps.ms.fp.fpuser.adapter.out.entity.ProductoEntity;
import com.jspapps.ms.fp.fpuser.model.producto.Producto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductoMapper {

    public ProductoEntity toProducto(Producto producto) {
        return ProductoEntity.builder()
                .id(producto.getId() != null ? producto.getId() : null)
                .numeroCuenta(producto.getNumeroCuenta())
                .tipoCuenta(producto.getTipoCuenta())
                .saldo(BigDecimal.valueOf(producto.getSaldo()))
                .estado(producto.getEstado())
                .exentaGMF(producto.isExentaGMF())
                .cliente(new ClienteEntity().id(producto.getUsuario()))
                .build();
    }
}
