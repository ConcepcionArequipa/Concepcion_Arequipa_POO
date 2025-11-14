package Practica;
import java.util.Scanner;
public class BalconServicios extends Empleado {
    Scanner sc = new Scanner(System.in);
    public BalconServicios(String nombre, String cedula, String direccion, String telefono,String usuario, String clave) {
        super(nombre, cedula, direccion, telefono,usuario,clave);
    }

    @Override
    public void mostrarRol(){
        System.out.println("Rol: Balcon de servicios");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cedula: " + getCedula());
    }

    public Cliente registrarNuevoCliente() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = sc.nextLine();

        System.out.print("Ingrese la dirección del cliente: ");
        String direccion = sc.nextLine();

        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = sc.nextLine();

        // Crear el cliente con los datos ingresados
        Cliente nuevo = new Cliente(nombre, cedula, direccion, telefono, "Sin cuenta", 0,0);

        System.out.println("Cliente registrado correctamente: " + nuevo.getNombre());
        return nuevo;
    }

    public void actualizarDatosCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente inválido");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese nueva dirección: ");
        String nuevaDireccion = sc.nextLine();

        System.out.print("Ingrese nuevo teléfono: ");
        String nuevoTelefono = sc.nextLine();

        // Actualizar datos del cliente
        cliente.actualizarDatos(nuevaDireccion, nuevoTelefono);

        System.out.println("Datos del cliente actualizados correctamente.");
    }

}
