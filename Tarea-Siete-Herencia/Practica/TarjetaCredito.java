package Practica;

public class TarjetaCredito {
    //Atributos privados

    private String numeroTarjeta;
    private String fechaExpiracion;  // Formato recomendado: MM/AA
    private String cvv;
    private double limiteCredito;
    private double saldoDisponible;

    // Constructor
    public TarjetaCredito(String numeroTarjeta, String fechaExpiracion, String cvv, double limiteCredito) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiracion = fechaExpiracion;
        this.cvv = cvv;
        this.limiteCredito = limiteCredito;
        this.saldoDisponible = limiteCredito; // Inicio con todo el saldo disponible
    }

    // Getters y Setters
    public String getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(String numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }

    public String getFechaExpiracion() { return fechaExpiracion; }
    public void setFechaExpiracion(String fechaExpiracion) { this.fechaExpiracion = fechaExpiracion; }

    public String getCvv() { return cvv; }
    public void setCvv(String cvv) { this.cvv = cvv; }

    public double getLimiteCredito() { return limiteCredito; }
    public void setLimiteCredito(double limiteCredito) { this.limiteCredito = limiteCredito; }

    public double getSaldoDisponible() { return saldoDisponible; }
    public void setSaldoDisponible(double saldoDisponible) { this.saldoDisponible = saldoDisponible; }

    // Métodos útiles
    public boolean realizarCompra(double monto) {
        if (monto <= saldoDisponible) {
            saldoDisponible -= monto;
            System.out.println("Compra realizada por $" + monto);
            return true;
        } else {
            System.out.println("Fondos insuficientes en la tarjeta.");
            return false;
        }
    }

    public void pagarTarjeta(double monto) {
        if (monto <= 0) {
            System.out.println("El pago debe ser mayor a cero.");
            return;
        }

        saldoDisponible += monto;

        if (saldoDisponible > limiteCredito) {
            saldoDisponible = limiteCredito; // No puede superar el límite
        }

        System.out.println("Pago de $" + monto + " registrado correctamente.");
    }

    public void mostrarDatos() {
        System.out.println("----- TARJETA DE CRÉDITO -----");
        System.out.println("Número: " + numeroTarjeta);
        System.out.println("Expira: " + fechaExpiracion);
        System.out.println("Límite: " + limiteCredito);
        System.out.println("Disponible: " + saldoDisponible);
    }

    @Override
    public String toString() {
        return "Numero de tarjeta de credito: " + numeroTarjeta +
                "\nSaldo disponible: " + saldoDisponible;
    }

}
