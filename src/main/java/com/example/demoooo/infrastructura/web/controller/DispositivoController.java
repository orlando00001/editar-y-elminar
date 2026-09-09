package com.example.demoooo.infrastructura.web.controller;

import com.example.demoooo.aplication.service.DispositivoService;
import com.example.demoooo.aplication.service.dto.DispositivoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dispositivos")
public class DispositivoController {

    @Autowired
    private DispositivoService dispositivoService;

    @PostMapping
    public ResponseEntity<DispositivoDto> guardar(@RequestBody DispositivoDto dto) {
        return new ResponseEntity<>(dispositivoService.guardar(dto), HttpStatus.CREATED);
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<DispositivoDto>> obtenerPorMarca(@PathVariable String marca) {
        return ResponseEntity.ok(dispositivoService.obtenerPorMarca(marca));
    }

    @GetMapping("/desactivados")
    public ResponseEntity<List<DispositivoDto>> obtenerDesactivados() {
        return ResponseEntity.ok(dispositivoService.obtenerDesactivados());
    }

    @PutMapping("/{id}")
    public ResponseEntity<DispositivoDto> editar(@PathVariable Long id, @RequestBody DispositivoDto dto) {
        return ResponseEntity.ok(dispositivoService.editar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLogico(@PathVariable Long id) {
        dispositivoService.eliminarLogico(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/fisico/{id}")
    public ResponseEntity<Void> eliminarFisico(@PathVariable Long id) {
        dispositivoService.eliminarFisico(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/reactivar/{id}")
    public ResponseEntity<Void> reactivar(@PathVariable Long id) {
        dispositivoService.reactivar(id);
        return ResponseEntity.noContent().build();
    }
}