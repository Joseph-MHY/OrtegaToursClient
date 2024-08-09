package com.ortega.client.repository;

import com.ortega.client.models.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstado extends JpaRepository<Estado, Integer> {
}
