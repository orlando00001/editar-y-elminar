package com.example.demoooo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class CambioServiceImpl implements CambioService {

    private static final double TIPO_CAMBIO = 10.0; 
    private int totalTransacciones = 0;

    @Override
    public Map<String, Object> convertirDolaresABolivianos(double dolares) {
        totalTransacciones++;
        double totalBolivianos = dolares * TIPO_CAMBIO;

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("montoDolares", dolares);
        respuesta.put("tipoCambioUsado", TIPO_CAMBIO);
        respuesta.put("montoBolivianos", totalBolivianos);
        respuesta.put("totalTransacciones", totalTransacciones);

        return respuesta;
    }
}