package com.ortega.client.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tipocontrato")
public class Tipocontrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('tipocontrato_id_tipo_contrato_seq'::regclass)")
    @Column(name = "id_tipo_contrato", nullable = false)
    private Integer id;

    @Column(name = "nombre_contrato", nullable = false, length = 30)
    private String nombreContrato;

    @OneToMany(mappedBy = "idTipoContrato")
    private Set<Empleado> empleados = new LinkedHashSet<>();

}