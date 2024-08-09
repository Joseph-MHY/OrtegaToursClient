package com.ortega.client.repository;

import com.ortega.client.models.entity.Transaccione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransacciones extends JpaRepository<Transaccione, Integer> {
}
