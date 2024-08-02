package com.ortega.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "paginasinfo/informacion.html";
    }

    // Página informacion
    @GetMapping("/informacionpromo1")
    public String informacionpromo1() {
        return "paginasinfo/informacionpromo1.html";
    }

    @GetMapping("/informacionpromo2")
    public String informacionpromo2() {
        return "paginasinfo/informacionpromo2.html";
    }
    @GetMapping("/informaciontour1")
    public String informaciontour1() {
        return "paginasinfo/informaciontour1.html";
    }
    @GetMapping("/informaciontour2")
    public String informaciontour2() {
        return "paginasinfo/informaciontour2.html";
    }
    @GetMapping("/informaciontour3")
    public String informaciontour3() {
        return "paginasinfo/informaciontour3.html";
    }
    @GetMapping("/informaciontours4")
    public String informaciontours4() {
        return "paginasinfo/informaciontours4.html";
    }
    @GetMapping("/informaciontour5")
    public String informaciontour5() {
        return "paginasinfo/informaciontour5.html";
    }
    @GetMapping("/informaciontour6")
    public String informaciontour6() {
        return "paginasinfo/informaciontour6.html";
    }

    @GetMapping("/informacionpromo3")
    public String informacionpromo3() {
        return "paginasinfo/informacionpromo3.html";
    }


    // Página informacion
    @GetMapping("/quiensomos")
    public String quiensomos() {
        return "quienessomos.html";
    }

}
