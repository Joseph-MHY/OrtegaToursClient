package com.ortega.client.service;

import com.ortega.client.models.DTO.ReservaDTO;
import com.ortega.client.models.entity.*;
import com.ortega.client.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

@Service
public class ReservaService {

    private IReserva ireserva;
    private IEstado iEstado;
    private ITransacciones iTransacciones;
    private ICliente iCliente;
    private IPaquete iPaquete;

    @Autowired
    public ReservaService(IReserva ireserva, IEstado iEstado, ITransacciones iTransacciones, ICliente iCliente, IPaquete iPaquete) {
        this.ireserva = ireserva;
        this.iEstado = iEstado;
        this.iTransacciones = iTransacciones;
        this.iCliente = iCliente;
        this.iPaquete = iPaquete;
    }

    @Transactional
    public void saveReserva(ReservaDTO reservaDTO) {

        Estado estado = iEstado.findById(1).orElse(null);

        Date fechaPartida = Date.from(reservaDTO.getFechaPartida().atStartOfDay(ZoneId.systemDefault()).toInstant());

        Date fechaRegistro = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());

        Paquete optionalPaquetes = iPaquete.findByNombrePaquete(reservaDTO.getDestino())
                .orElseThrow(() -> new EntityNotFoundException("Paquete no encontrado"));

        Cliente cliente = new Cliente();
        cliente.setNombres(reservaDTO.getNombres());
        cliente.setApellidos(reservaDTO.getApellidos());
        cliente.setCorreo(reservaDTO.getCorreo());
        cliente.setCelular(reservaDTO.getCelular());
        cliente.setNumdocumento(reservaDTO.getNumDocumento());
        cliente = iCliente.save(cliente);


        Reserva reservas = new Reserva();
        reservas.setIdCliente(cliente);
        reservas.setIdPaquete(optionalPaquetes);
        reservas.setTipoViaje(reservaDTO.getTipoViaje());
        reservas.setFechaPartida(fechaPartida);
        reservas.setFechaRegistro(fechaRegistro);
        reservas.setIdEstado(estado);

        ireserva.save(reservas);

        Transaccione transacciones = new Transaccione();
        transacciones.setIdReserva(reservas);
        transacciones.setFechaTransaccion(null);
        transacciones.setMontoPagado(0.0);
        transacciones.setEstadoPago("Pendiente");
        transacciones.setTipoMoneda("PEN");

        iTransacciones.save(transacciones);
    }
}
