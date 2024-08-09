package com.ortega.client.controller;

import com.ortega.client.models.DTO.ReservaDTO;
import com.ortega.client.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping("/guardar")
    public ResponseEntity<String> saveReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            reservaService.saveReserva(reservaDTO);
            return ResponseEntity.ok("Reserva guardada con exito");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Error al guardar reserva: " + e.getMessage());
        }
    }
}
