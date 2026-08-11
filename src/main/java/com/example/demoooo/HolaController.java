package com.example.demoooo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {

    @GetMapping("/hola")
    public String hola() {
        return "¡Hola Santiago! Tu servidor Spring Boot está funcionando correctamente 🚀";
    }
}