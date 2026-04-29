package org.example;

public class BillingAdapter implements FacturaService {

    private LegacyBillingSystem legacy;
    private String ultimoBillCode = null;

    public BillingAdapter() {
        this.legacy = new LegacyBillingSystem();
        this.legacy.init("legacy/config.xml");
    }

    @Override
    public void emitirFactura(Cliente cliente, double monto) {
        String clientId      = cliente.getRuc();
        int amountInCents    = (int) (monto * 100);

        System.out.println("\n[BillingAdapter] Adaptando llamada a sistema legado...");
        System.out.println("  Cliente moderno : " + cliente.getNombre());
        System.out.println("  → clientId      : " + clientId);
        System.out.println("  Monto (S/.)     : " + monto);
        System.out.println("  → amountInCents : " + amountInCents);

        ultimoBillCode = legacy.generateBill(clientId, amountInCents);
        System.out.println("[BillingAdapter] Comprobante generado: " + ultimoBillCode);
    }

    @Override
    public boolean verificarEstado(Cliente cliente) {
        if (ultimoBillCode == null) {
            System.out.println("[BillingAdapter] No hay comprobante generado aún.");
            return false;
        }
        String status = legacy.getBillStatus(ultimoBillCode);
        return "SUCCESS".equalsIgnoreCase(status);
    }
}