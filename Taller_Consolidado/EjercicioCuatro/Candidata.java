package EjercicioCuatro;

public abstract class Candidata {
    protected int id;
    protected String nombre;
    protected int edad;
    protected String distrito;
    protected double puntajeJurado;


    public Candidata(int id, String nombre, int edad, String distrito, double puntajeJurado) throws DatoInvalidoException {
        setId(id);
        setNombre(nombre);
        setEdad(edad);
        setDistrito(distrito);
        setPuntajeJurado(puntajeJurado);
    }


    public int getId() { return id; }
    public void setId(int id) throws DatoInvalidoException {
        if (id <= 0) throw new DatoInvalidoException("ID debe ser mayor que cero.");
        this.id = id;
    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) throws DatoInvalidoException {
        if (nombre == null || nombre.trim().isEmpty()) throw new DatoInvalidoException("Nombre no puede estar vacío.");
        this.nombre = nombre.trim();
    }


    public int getEdad() { return edad; }
    public void setEdad(int edad) throws DatoInvalidoException {
        if (edad < 16) throw new DatoInvalidoException("Edad debe ser >= 16.");
        this.edad = edad;
    }


    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) throws DatoInvalidoException {
        if (distrito == null || distrito.trim().isEmpty()) throw new DatoInvalidoException("Distrito no puede estar vacío.");
        this.distrito = distrito.trim();
    }


    public double getPuntajeJurado() { return puntajeJurado; }
    public void setPuntajeJurado(double puntajeJurado) throws DatoInvalidoException {
        if (puntajeJurado < 0 || puntajeJurado > 100) throw new DatoInvalidoException("Puntaje jurado debe estar entre 0 y 100.");
        this.puntajeJurado = puntajeJurado;
    }


    public abstract void mostrarDetalles();


    @Override
    public String toString() {
        return String.format("[%d] %s — %d años — %s — Puntaje jurado: %.2f", id, nombre, edad, distrito, puntajeJurado);
    }
}
