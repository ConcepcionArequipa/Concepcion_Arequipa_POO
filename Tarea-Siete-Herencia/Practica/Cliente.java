package Practica;
//Subclase Cliente
public class Cliente extends Persona {
    private double saldo;
    private String cuenta;
    private TarjetaCredito tarjeta; // TarjetaCredito es una clase
    private double deudaPrestamo; //Deuda del prestamo a solicitar

    //Metodo constructor
    public Cliente(String nombre, String cedula, String direccion, String telefono, String cuenta, double deudaPrestamo,double saldo) {
        super(nombre,cedula,direccion,telefono);
        this.cuenta = cuenta;
        this.tarjeta = null;
        this.deudaPrestamo = 0; //Se inicializa en cero, ya que aun no hay deuda
        this.saldo = 0;

    }
    //Implementar getter y setters


    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public double getDeudaPrestamo() {
        return deudaPrestamo;
    }

    public void setDeudaPrestamo(double deudaPrestamo) {
        this.deudaPrestamo = deudaPrestamo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Metodo heredado

    @Override
    public void mostrarRol(){
        System.out.println("Rol: Cliente");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cedula: " + getCedula());


    }

    public boolean ingresarAlSistema(String cedulaIngresada){
        return getCedula().equals(cedulaIngresada);
    }

    public void registrarCuenta(String cuenta){
        //Aplicar try-catch

        try {
            if (cuenta==null || cuenta.length()==0) {
                throw new Exception("La cuenta no puede estar vacía");
            }
            setCuenta(cuenta);
            System.out.println("Cuenta registrada exitosamente.");
        }
        catch (Exception e) {
            System.out.println("Error al registrar cuenta "+ e.getMessage());
        }
    }

    public void solicitarPrestamo(double monto){
        if(monto<250){
            System.out.println("Prestamo rechazado, el monto debe ser minimo $250");
            return;
        }
        System.out.println("Prestamo aprobado por $"+monto);
        deudaPrestamo+=monto;
    }

    public void agregarTarjetaCredito(TarjetaCredito tarjeta){
        try {
            if (tarjeta==null) {
                throw new IllegalArgumentException("La tarjeta no puede ser nula");
            }
            setTarjeta(tarjeta);
            System.out.println("Tarjeta de crédito agregada correctamente.");
        } catch (Exception e) {
            System.out.println("Error al agregar tarjeta"+ e.getMessage());
        }

    }

    public void verResumenFinanciero(){
        System.out.println("----- RESUMEN FINANCIERO ------");
        System.out.println("Nombre: "+ getNombre());
        System.out.println("Cedula: "+ getCedula());
        System.out.println("Direccion: "+ getDireccion());
        System.out.println("Telefono: "+ getTelefono());
        System.out.println("Cuenta: "+ getCuenta());

        //Mostrar tarjeta de credito
        if(getTarjeta()!=null){
            System.out.println(tarjeta.toString());
        }
        else{
            System.out.println("No hay una tarjeta registrada");
        }

        System.out.println("Deuda del prestamo: "+ getDeudaPrestamo());
    }

    public void depositar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
            return;
        }
        saldo += monto;
        System.out.println("Depósito realizado. Nuevo saldo: $" + saldo);
    }

    public void retirar(double monto) {
        if (monto <= 0) {
            System.out.println("El monto debe ser mayor a 0.");
            return;
        }
        if (monto > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        saldo -= monto;
        System.out.println("Retiro realizado. Nuevo saldo: $" + saldo);
    }

    public void consultarSaldo() {
        System.out.println("Saldo actual: $" + saldo);
    }


}


