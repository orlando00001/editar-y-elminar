package com.example.demoooo.infrastructura.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoooo.domain.Dispositivo;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivo, Long> {
    
    
    List<Dispositivo> findByMarcaIgnoreCase(String marca);
}