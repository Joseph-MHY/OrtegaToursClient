package com.ortega.client.repository;

import com.ortega.client.models.entity.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IPaquete extends JpaRepository<Paquete, Integer> {

    Optional<Paquete> findByNombrePaquete(String nombrePaquete);
}
