package com.ortega.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class PageController {

    // Página inicial
    @GetMapping("/principal")
    public String pagprincipal() {
        return "principal.html";
    }

    // Página personalizacion
    @GetMapping("/personalisacion")
    public String personalicion() {
        return "personalisacion.html";
    }

    // Página promociones
    @GetMapping("/promociones")
    public String promociones() {
        return "promociones.html";
    }
    // Página informacion
    @GetMapping("/informacion")
    public String informacion() {
        return "informacion.html";
    }
    // Página informacion
    @GetMapping("/quiensomos")
    public String quiensomos() {
        return "quienessomos.html";
    }
}
