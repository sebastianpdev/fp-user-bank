package com.jspapps.ms.fp.fpuser.adapter.out.mapper;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ProductoEntity;
import com.jspapps.ms.fp.fpuser.model.producto.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {})
public interface ProductMapper {

    @Mapping(source = "usuario", target = "cliente.id")
    ProductoEntity toEntity(Producto producto);

    default ProductoEntity fromId(Long id) {
        if (id == null) {
            return null;
        }

        ProductoEntity producto = new ProductoEntity();
        producto.setId(id);
        return producto;
    }
}
