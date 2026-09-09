package com.example.demoooo.aplication.service;

import com.example.demoooo.aplication.service.dto.DispositivoDto;
import java.util.List;

public interface DispositivoService {

    DispositivoDto guardar(DispositivoDto dto);

    List<DispositivoDto> obtenerPorMarca(String marca);

    List<DispositivoDto> obtenerDesactivados();

    DispositivoDto editar(Long id, DispositivoDto dto);

    void eliminarLogico(Long id);

    void eliminarFisico(Long id);

    void reactivar(Long id);
}