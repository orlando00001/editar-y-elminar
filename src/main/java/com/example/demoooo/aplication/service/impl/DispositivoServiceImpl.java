package com.example.demoooo.aplication.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoooo.aplication.dto.DispositivoDto;
import com.example.demoooo.aplication.service.DispositivoService;
import com.example.demoooo.domain.Dispositivo;
import com.example.demoooo.infrastructura.persistence.DispositivoRepository;

@Service
public class DispositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Override
    public DispositivoDto guardar(DispositivoDto dto) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setNombre(dto.getNombre());
        dispositivo.setMarca(dto.getMarca());
        dispositivo.setTipo(dto.getTipo());
        dispositivo.setPrecio(dto.getPrecio());

        dispositivoRepository.save(dispositivo);
        return dto;
    }

    @Override
    public List<DispositivoDto> obtenerPorMarca(String marca) {
        List<Dispositivo> dispositivos = dispositivoRepository.findByMarcaIgnoreCase(marca);
        List<DispositivoDto> dtos = new ArrayList<>();

        for (Dispositivo d : dispositivos) {
            DispositivoDto dto = new DispositivoDto();
            dto.setId(d.getId());
            dto.setNombre(d.getNombre());
            dto.setMarca(d.getMarca());
            dto.setTipo(d.getTipo());
            dto.setPrecio(d.getPrecio());
            dtos.add(dto);
        }
        return dtos;
    }
}