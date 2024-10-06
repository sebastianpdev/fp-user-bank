package com.jspapps.ms.fp.fpuser.adapter.out.persistence;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ProductoEntity;
import com.jspapps.ms.fp.fpuser.adapter.out.mapper.ProductoMapper;
import com.jspapps.ms.fp.fpuser.adapter.out.repository.ProductoRepository;
import com.jspapps.ms.fp.fpuser.adapter.util.annotation.PersistenceAdapter;
import com.jspapps.ms.fp.fpuser.application.port.out.IProductoPersistence;
import com.jspapps.ms.fp.fpuser.model.common.ErrorCodeMessage;
import com.jspapps.ms.fp.fpuser.model.exception.BasicException;
import com.jspapps.ms.fp.fpuser.model.producto.Producto;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;

@PersistenceAdapter
@AllArgsConstructor
public class ProductoPersistence implements IProductoPersistence {

    private final ProductoRepository productoRepository;
    private final ProductoMapper productoMapper;

    @Override
    public void crearProducto(Producto producto) {
        try {
            ProductoEntity newProducto = productoMapper.toProducto(producto);
            productoRepository.save(newProducto);
        } catch (DataAccessException ex) {
            throw new BasicException(HttpStatus.INTERNAL_SERVER_ERROR, ErrorCodeMessage.ACCOUNT_DATA_ERROR);
        }
    }
}
