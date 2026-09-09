package com.example.demoooo.infrastructura.persistence;

import com.example.demoooo.domain.Dispositivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {

    List<Dispositivo> findByMarcaIgnoreCaseAndEstadoTrue(String marca);

    List<Dispositivo> findByEstadoTrue();

    // Método para obtener los dispositivos con baja lógica (inactivos)
    List<Dispositivo> findByEstadoFalse();
}