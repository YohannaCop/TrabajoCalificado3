package org.example;

public interface FacturaService {
    void emitirFactura(Cliente cliente, double monto);
    boolean verificarEstado(Cliente cliente);
}