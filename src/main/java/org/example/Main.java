package org.example;

public class Main {
    public static void main(String[] args) {

        Cliente cliente = new Cliente("Yohanna Copacondori", "01769396337");
        Pedido  pedido  = new Pedido(901, 149.90, cliente);

        System.out.println("Pedido registrado: " + pedido);
        System.out.println("Pedido validado correctamente.\n");

        System.out.println("--- Generando factura electrónica ---");
        FacturaService servicio = new BillingAdapter();
        servicio.emitirFactura(pedido.getCliente(), pedido.getMonto());

        System.out.println("\n--- Verificando estado de la factura ---");
        boolean exito = servicio.verificarEstado(pedido.getCliente());

        if (exito) {
            System.out.println("\n✔ Factura generada correctamente.");
            System.out.println("  Cliente : " + pedido.getCliente().getNombre());
            System.out.println("  Monto   : S/. " + pedido.getMonto());
        } else {
            System.out.println("\n✘ Error al generar la factura.");
        }
    }
}