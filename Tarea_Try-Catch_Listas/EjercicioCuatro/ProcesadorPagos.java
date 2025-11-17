package EjercicioCuatro;

public class ProcesadorPagos {
    public void procesarPago(double monto) throws PagoInvalidoException {
        if (monto < 0) {
            throw new PagoInvalidoException("El pago no puede ser negativo.");
        }

        if (monto == 0) {
            throw new PagoInvalidoException("El pago no puede ser igual a 0.");
        }

        if (monto > 5000) {
            throw new PagoInvalidoException("El pago no puede ser mayor a $5000.");
        }

        System.out.println("Pago procesado correctamente: $" + monto);
    }
}
