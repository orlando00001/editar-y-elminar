package com.example.demoooo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String accion;
    private Long dispositivoId;
    private String detalle;
    private LocalDateTime fecha;

    public Reporte() {
        this.fecha = LocalDateTime.now();
    }

    public Reporte(String accion, Long dispositivoId, String detalle) {
        this.accion = accion;
        this.dispositivoId = dispositivoId;
        this.detalle = detalle;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public Long getDispositivoId() { return dispositivoId; }
    public void setDispositivoId(Long dispositivoId) { this.dispositivoId = dispositivoId; }

    public String getDetalle() { return detalle; }
    public void setDetalle(String detalle) { this.detalle = detalle; }

    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}