package com.ortega.client.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "transacciones")
public class Transaccione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('transacciones_id_transaccion_seq'::regclass)")
    @Column(name = "id_transaccion", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva idReserva;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_transaccion")
    private Date fechaTransaccion;

    @Column(name = "monto_pagado")
    private Double montoPagado;

    @ColumnDefault("'Pendiente'")
    @Column(name = "estado_pago", length = 10)
    private String estadoPago;

    @Column(name = "tipo_moneda", nullable = false, length = 3)
    private String tipoMoneda;

}