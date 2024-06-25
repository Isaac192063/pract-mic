package com.moto.service.motoservice.repository;

import com.moto.service.motoservice.model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long> {
    List<Moto> findByUsuarioId(int usuarioId);
}
