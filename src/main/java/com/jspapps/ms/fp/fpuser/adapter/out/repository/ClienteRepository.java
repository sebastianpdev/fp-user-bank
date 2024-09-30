package com.jspapps.ms.fp.fpuser.adapter.out.repository;

import com.jspapps.ms.fp.fpuser.adapter.out.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    Optional<ClienteEntity> findById(Long id);
}
