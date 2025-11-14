package Practica;

public class Empleado extends Persona{
    private String usuario;
    private String clave;

    public Empleado(String nombre, String cedula, String direccion, String telefono,String usuario, String clave) {
        super(nombre, cedula, direccion, telefono);
        this.usuario = usuario;
        this.clave = clave;
    }

    //Metodo abstracto

    @Override
    public void mostrarRol(){
        System.out.println("Rol: Empleado");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Cedula: " + getCedula());
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean autenticarEmpleado(String usuario, String clave){
        return usuario != null && clave != null &&
                usuario.equals(this.usuario) && clave.equals(this.clave);
    }


    public void crearCuentaParaCliente(Cliente cliente, String tipo ){
        if(cliente == null ){
            System.out.println("Error: el cliente no existe.");
            return;
        }

        if (tipo == null || tipo.isEmpty()) {
            System.out.println("Tipo de cuenta inválido.");
            return;
        }

        cliente.setCuenta(tipo);
        System.out.println("Cuenta creada para el cliente: " + cliente.getNombre());

    }

    public void modificarDatosCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Cliente inválido");
            return;
        }

        System.out.println("Modificando datos del cliente...");

        // Vuelve a guardar los mismos datos para validar con actualizarDatos
        cliente.actualizarDatos(cliente.getDireccion(), cliente.getTelefono());

        System.out.println("Datos del cliente actualizados correctamente.");
    }



    // Registrar préstamo para el cliente

    public void registrarPrestamo(Cliente cliente, double monto) {
        if (cliente == null) {
            System.out.println("Cliente inválido");
            return;
        }

        cliente.solicitarPrestamo(monto);
    }

    // Cerrar cuenta del cliente
    public void cerrarCuenta(Cliente cliente, Cuenta cuenta) {

        if (cliente == null || cuenta == null) {
            System.out.println("Error: cliente o cuenta invalida.");
            return;
        }

        // Aquí se supone que se cierra la cuenta
        cliente.setCuenta(null);

        System.out.println("Cuenta cerrada exitosamente para el cliente: " + cliente.getNombre());
    }
}
