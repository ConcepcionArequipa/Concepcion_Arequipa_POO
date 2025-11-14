package Practica;

public class Cajero extends Persona {
    public Cajero(String nombre, String cedula, String direccion, String telefono) {
        super(nombre, cedula, direccion, telefono);
    }

    @Override
    public void mostrarRol(){
        System.out.println("Rol: Cajero");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cedula: " + getCedula());
    }
    // Procesar retiro
    public void procesarRetiro(Cliente cliente, double monto) {
        if (cliente == null) {
            System.out.println("Cliente inválido.");
            return;
        }

        if (monto <= 0) {
            System.out.println("Monto de retiro inválido.");
            return;
        }

        cliente.retirar(monto);
    }

    // Consultar saldo
    public void consultarSaldo(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente inválido.");
            return;
        }

        System.out.println("Saldo actual del cliente " + cliente.getNombre() + ": " + cliente.getSaldo());
    }

    // Procesar depósito
    public void procesarDeposito(Cliente cliente, double monto) {
        if (cliente == null) {
            System.out.println("Cliente inválido.");
            return;
        }

        if (monto <= 0) {
            System.out.println("Monto de depósito inválido.");
            return;
        }

        cliente.depositar(monto);
    }
}
