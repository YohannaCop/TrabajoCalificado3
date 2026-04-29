package org.example;

public class LegacyBillingSystem {

    public void init(String configPath) {
        System.out.println("[LegacyBillingSystem] Inicializando con config: " + configPath);
    }

    public String generateBill(String clientId, int amountInCents) {
        System.out.println("[LegacyBillingSystem] Generando comprobante para clientId="
                + clientId + ", monto=" + amountInCents + " centavos");
        return "BILL-OK-" + clientId;
    }

    public String getBillStatus(String billCode) {
        System.out.println("[LegacyBillingSystem] Consultando estado de: " + billCode);
        return "SUCCESS";
    }
}