package com.ortega.client.repository;

import com.ortega.client.models.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IReserva extends JpaRepository<Reserva, Integer> {
}
