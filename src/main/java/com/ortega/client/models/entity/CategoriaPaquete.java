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
@Table(name = "categoria_paquete")
public class CategoriaPaquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('categoria_paquete_id_categoria_paquete_seq'::regclass)")
    @Column(name = "id_categoria_paquete", nullable = false)
    private Integer id;

    @Column(name = "nombre_categoria", nullable = false, length = 40)
    private String nombreCategoria;

    @OneToMany(mappedBy = "idCategoriaPaquete")
    private Set<Paquete> paquetes = new LinkedHashSet<>();

}