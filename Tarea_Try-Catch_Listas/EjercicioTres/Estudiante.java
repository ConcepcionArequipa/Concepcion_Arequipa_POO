package EjercicioTres;

public class Estudiante {

    //atributos privados

    private String nombre;
    private int edad;

    public Estudiante(String nombre, int edad) {
        // Validar nombre vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }

        // Validar edad incorrecta
        if (edad < 0 || edad > 120) {
            throw new IllegalArgumentException("La edad debe estar entre 0 y 120");
        }
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }



}
