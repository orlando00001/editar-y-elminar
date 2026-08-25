package com.example.demoooo.aplication.service;

import java.util.List;

import com.example.demoooo.aplication.dto.DispositivoDto;

public interface DispositivoService {
    DispositivoDto guardar(DispositivoDto dto);
    List<DispositivoDto> obtenerPorMarca(String marca);
}