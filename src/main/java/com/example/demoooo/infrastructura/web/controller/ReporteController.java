package com.example.demoooo.infrastructura.web.controller;

import com.example.demoooo.domain.Reporte;
import com.example.demoooo.infrastructura.persistence.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteRepository reporteRepository;

    @GetMapping
    public ResponseEntity<List<Reporte>> obtenerReportes() {
        return ResponseEntity.ok(reporteRepository.findAll());
    }
}