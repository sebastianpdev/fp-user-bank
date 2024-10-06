package com.jspapps.ms.fp.fpuser.application.service;

import com.jspapps.ms.fp.fpuser.adapter.out.persistence.ProductoPersistence;
import com.jspapps.ms.fp.fpuser.application.port.in.CreateProductoUseCase;
import com.jspapps.ms.fp.fpuser.application.port.in.FindClienteUseCase;
import com.jspapps.ms.fp.fpuser.model.producto.CreateProductoDTO;
import com.jspapps.ms.fp.fpuser.model.producto.Producto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Transactional
@Service
public class CreateProductoService implements CreateProductoUseCase {

    private final ProductoPersistence productoPersistence;
    private final FindClienteUseCase findClienteUseCase;

    @Override
    public void crearProducto(CreateProductoDTO createProductoDTO) {
        Producto newProducto = createProductoDTO.toProducto();
        findClienteUseCase.existsCliente(newProducto.getUsuario());
        productoPersistence.crearProducto(newProducto);
    }
}
