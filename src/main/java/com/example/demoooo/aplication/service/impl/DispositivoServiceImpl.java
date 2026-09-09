package com.example.demoooo.aplication.service.impl;

import com.example.demoooo.aplication.service.DispositivoService;
import com.example.demoooo.aplication.service.dto.DispositivoDto;
import com.example.demoooo.domain.Dispositivo;
import com.example.demoooo.domain.Reporte;
import com.example.demoooo.infrastructura.persistence.DispositivoRepository;
import com.example.demoooo.infrastructura.persistence.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispositivoServiceImpl implements DispositivoService {

    @Autowired
    private DispositivoRepository dispositivoRepository;

    @Autowired
    private ReporteRepository reporteRepository;

    @Override
    public DispositivoDto guardar(DispositivoDto dto) {
        Dispositivo dispositivo = new Dispositivo();
        dispositivo.setNombre(dto.getNombre());
        dispositivo.setMarca(dto.getMarca());
        dispositivo.setTipo(dto.getTipo());
        dispositivo.setPrecio(dto.getPrecio());
        dispositivo.setEstado(true);

        Dispositivo guardado = dispositivoRepository.save(dispositivo);
        dto.setId(guardado.getId());

        reporteRepository.save(new Reporte("CREAR", guardado.getId(), "Dispositivo creado: " + guardado.getNombre()));

        return dto;
    }

    @Override
    public List<DispositivoDto> obtenerPorMarca(String marca) {
        List<Dispositivo> dispositivos = dispositivoRepository.findByMarcaIgnoreCaseAndEstadoTrue(marca);
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

    @Override
    public List<DispositivoDto> obtenerDesactivados() {
        List<Dispositivo> desactivados = dispositivoRepository.findByEstadoFalse();
        List<DispositivoDto> dtos = new ArrayList<>();

        for (Dispositivo d : desactivados) {
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

    @Override
    public DispositivoDto editar(Long id, DispositivoDto dto) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado con ID: " + id));

        dispositivo.setNombre(dto.getNombre());
        dispositivo.setMarca(dto.getMarca());
        dispositivo.setTipo(dto.getTipo());
        dispositivo.setPrecio(dto.getPrecio());

        Dispositivo actualizado = dispositivoRepository.save(dispositivo);
        dto.setId(actualizado.getId());

        reporteRepository.save(new Reporte("EDITAR", id, "Dispositivo editado con nuevos datos."));

        return dto;
    }

    @Override
    public void eliminarLogico(Long id) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado con ID: " + id));

        dispositivo.setEstado(false);
        dispositivoRepository.save(dispositivo);

        reporteRepository.save(new Reporte("ELIMINAR_LOGICO", id, "Dispositivo marcado como inactivo."));
    }

    @Override
    public void eliminarFisico(Long id) {
        dispositivoRepository.deleteById(id);
        reporteRepository.save(new Reporte("ELIMINAR_FISICO", id, "Dispositivo eliminado permanentemente de la BD."));
    }

    @Override
    public void reactivar(Long id) {
        Dispositivo dispositivo = dispositivoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dispositivo no encontrado con ID: " + id));

        dispositivo.setEstado(true);
        dispositivoRepository.save(dispositivo);

        reporteRepository.save(new Reporte("REACTIVAR", id, "Dispositivo reactivado a estado activo."));
    }
}