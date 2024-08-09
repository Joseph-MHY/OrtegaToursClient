package com.ortega.client.repository;

import com.ortega.client.models.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICliente extends JpaRepository<Cliente, Integer> {

    Cliente findByNumdocumento(String numdocumento);
    Cliente findByCorreo(String correo);
}
