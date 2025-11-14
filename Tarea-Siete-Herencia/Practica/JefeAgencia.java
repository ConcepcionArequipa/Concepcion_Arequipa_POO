package Practica;

public class JefeAgencia extends Empleado{
    public JefeAgencia(String nombre, String cedula, String direccion, String telefono,String usuario, String clave) {
        super(nombre, cedula, direccion, telefono,usuario,clave);
    }

    @Override
    public void mostrarRol(){
        System.out.println("Rol: Jefe de agencia");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cedula: " + getCedula());
    }

    public boolean aprobarPrestamo(Cliente cliente, double monto) {

        if (cliente == null || monto <= 0) {
            System.out.println("Solicitud inválida.");
            return false;
        }
        if (cliente.getDeudaPrestamo() == 0) {
            cliente.setDeudaPrestamo(monto);
            System.out.println("Préstamo de $" + monto + " aprobado para " + cliente.getNombre());
            return true;
        } else {
            System.out.println("Préstamo rechazado. El cliente tiene deuda pendiente.");
            return false;
        }
    }

    public void generarReporteOperaciones() {
        System.out.println("----- REPORTE DE OPERACIONES -----");
        System.out.println("Total de transacciones del día: 800 ");
        System.out.println("Total de préstamos otorgados: 200 ");
        System.out.println("Total de depósitos: 700 ");
        System.out.println("Total de retiros: 1000 ");
        System.out.println("----------------------------------");
    }

    public void evaluarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("Empleado inválido.");
            return;
        }

        System.out.println("Evaluando desempeño del empleado:");
        empleado.mostrarRol();

        // Evaluación simulada

        System.out.println("Resultado de la evaluación: SATISFACTORIO.");
    }
}
