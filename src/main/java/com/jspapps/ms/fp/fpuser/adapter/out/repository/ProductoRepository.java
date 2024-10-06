package com.jspapps.ms.fp.fpuser.adapter.out.repository;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}
