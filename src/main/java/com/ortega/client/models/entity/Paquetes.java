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
@Table(name = "paquetes")
public class Paquetes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('paquetes_id_paquete_seq'::regclass)")
    @Column(name = "id_paquete", nullable = false)
    private Integer id;

    @Column(name = "nombre_paquete", nullable = false, length = 60)
    private String nombrePaquete;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria_paquete", nullable = false)
    private CategoriaPaquete idCategoriaPaquete;

    @Column(name = "costo_base")
    private Double costoBase;

    @Column(name = "costo_fijo")
    private Double costoFijo;

    @Column(name = "descripcion_paquete", nullable = false, length = Integer.MAX_VALUE)
    private String descripcionPaquete;

    @Column(name = "urlimagen", length = Integer.MAX_VALUE)
    private String urlimagen;

    @OneToMany(mappedBy = "idPaquete")
    private Set<Reservas> reservas = new LinkedHashSet<>();

}