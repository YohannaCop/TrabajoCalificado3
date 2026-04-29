package org.example;

public class Pedido {
    private int    id;
    private double monto;
    private Cliente cliente;

    public Pedido(int id, double monto, Cliente cliente) {
        this.id      = id;
        this.monto   = monto;
        this.cliente = cliente;
    }

    public int     getId()      { return id;      }
    public double  getMonto()   { return monto;   }
    public Cliente getCliente() { return cliente; }

    @Override
    public String toString() {
        return "Pedido #" + id + " | Monto: S/. " + monto + " | " + cliente;
    }
}