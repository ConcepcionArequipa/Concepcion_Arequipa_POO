package parte.cuatro;

public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculoUno = new Vehiculo();

        //Acceso directo a atributo público
        vehiculoUno.marca = "Toyota";
        System.out.println("Marca (pública): " + vehiculoUno.marca);

        // Intento de lectura de codigoSeguridad (debe dar error)
        // Esto da error porque es private
        // System.out.println(vehiculoUno.codigoSeguridad);

        // Asignar modelo
        vehiculoUno.setModelo("Mercedes");
        System.out.println("Modelo: " + vehiculoUno.getModelo());

        // Mostrar la velocidad maxima
        System.out.println("Velocidad máxima: " + vehiculoUno.getVelocidadMaxima());

        //Asignar codigoSeguridad (solo escritura)
        vehiculoUno.setCodigoSeguridad(12345);
        System.out.println("Codigo de seguridad asignado");

        // Intentar poner color no valido
        vehiculoUno.setColor("verde");

        // Asignar color válido
        vehiculoUno.setColor("rojo");
        System.out.println("Color: " + vehiculoUno.getColor());
    }

}
