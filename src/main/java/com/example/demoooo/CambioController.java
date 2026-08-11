package com.example.demoooo;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CambioController {

    private final CambioService cambioService;

    public CambioController(CambioService cambioService) {
        this.cambioService = cambioService;
    }

    @GetMapping("/convertir")
    public Map<String, Object> convertir(@RequestParam double dolares) {
        return cambioService.convertirDolaresABolivianos(dolares);
    }
}