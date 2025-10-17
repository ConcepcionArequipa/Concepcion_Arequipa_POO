package parte.tres;

public class CuentaBancaria {
    private double saldo = 0;
    private String titular;

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            this.saldo += monto;
            System.out.println("Deposito exitoso");
        }
        else {
            System.out.println("El deposito debe ser mayor a 0");
        }
    }

    public void retirar(double monto) {
        if (saldo >= monto) {
            this.saldo -= monto;
        }
        else {
            System.out.println("Saldo insuficiente");
        }
    }
}
