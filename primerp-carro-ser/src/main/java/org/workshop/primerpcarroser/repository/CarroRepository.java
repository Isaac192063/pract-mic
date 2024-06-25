package org.workshop.primerpcarroser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.workshop.primerpcarroser.model.Carro;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {
    List<Carro> findCarroByUsuarioId(int usuarioId);
}
