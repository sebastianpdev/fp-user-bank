package com.jspapps.ms.fp.fpuser.adapter.out.repository;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
}
