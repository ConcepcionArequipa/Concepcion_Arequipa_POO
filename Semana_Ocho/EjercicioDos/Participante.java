package EjercicioDos;

public abstract class Participante {
    protected String nombre;
    protected int edad;
    protected String deporte;
    protected String pais;

    public Participante(String nombre, int edad, String deporte, String pais) {

        if (edad <= 0) {
            throw new DatosInvalidosException("La edad debe ser mayor que cero.");
        }
        if (nombre == null || nombre.trim().isEmpty())
            throw new DatosInvalidosException("El nombre no puede estar vacío.");

        if (edad <= 0)
            throw new DatosInvalidosException("La edad debe ser mayor a cero.");

        if (deporte == null || deporte.trim().isEmpty())
            throw new DatosInvalidosException("El deporte no puede estar vacío.");

        if (pais == null || pais.trim().isEmpty())
            throw new DatosInvalidosException("El país no puede estar vacío.");

        this.nombre = nombre;
        this.edad = edad;
        this.deporte = deporte;
        this.pais = pais;
    }
    // Metodo abstracto que cada hijo debe implementar
    public abstract void mostrarTipo();

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nPaís: " + pais+
                "\nDeporte: " + deporte;
    }
}
