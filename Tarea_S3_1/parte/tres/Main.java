package parte.tres;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaUno = new CuentaBancaria();

        //Deposito valido
        cuentaUno.depositar(5000);
        System.out.println("Saldo actual: " + cuentaUno.getSaldo());
        System.out.println("-----------------------------");

        // Retiro valido
        System.out.println("Retiro valido: 500");
        cuentaUno.retirar(500);
        System.out.println("Saldo actual: " + cuentaUno.getSaldo());
        System.out.println("-----------------------------");

        // Retiro mayor al saldo
        System.out.println("Intento de retiro mayor al saldo: 6000");
        cuentaUno.retirar(6000);
        System.out.println("Saldo actual: " + cuentaUno.getSaldo());
        System.out.println("-----------------------------");

        // Deposito invalido
        System.out.println("Intento de deposito invalido: -200");
        cuentaUno.depositar(-200);
        System.out.println("Saldo actual: " + cuentaUno.getSaldo());
        System.out.println("-----------------------------");

    }

}
