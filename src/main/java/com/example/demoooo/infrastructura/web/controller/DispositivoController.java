package com.example.demoooo.infrastructura.web.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoooo.aplication.dto.DispositivoDto;
import com.example.demoooo.aplication.service.DispositivoService;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    
    @PostMapping("/guardar")
    public DispositivoDto guardar(@RequestBody DispositivoDto dto) {
        return dispositivoService.guardar(dto);
    }

    
    @PostMapping("/buscar-por-marca")
    public List<DispositivoDto> buscarPorMarca(@RequestBody Map<String, String> payload) {
        String marca = payload.get("marca");
        return dispositivoService.obtenerPorMarca(marca);
    }
}