package com.ortega.client.models.DTO;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReservaDTO {
    String destino;
    String nombres;
    String apellidos;
    String correo;
    String celular;
    String numDocumento;
    LocalDate fechaPartida;
    String tipoViaje;
}
