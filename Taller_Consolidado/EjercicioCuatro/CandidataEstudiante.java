package EjercicioCuatro;

public class CandidataEstudiante extends Candidata {
    private String universidad;
    private String carrera;


    public CandidataEstudiante(int id, String nombre, int edad, String distrito, double puntajeJurado,
                               String universidad, String carrera) throws DatoInvalidoException {
        super(id, nombre, edad, distrito, puntajeJurado);
        setUniversidad(universidad);
        setCarrera(carrera);
    }


    public String getUniversidad() { return universidad; }
    public void setUniversidad(String universidad) throws DatoInvalidoException {
        if (universidad == null || universidad.trim().isEmpty()) throw new DatoInvalidoException("Universidad no puede estar vacía.");
        this.universidad = universidad.trim();
    }


    public String getCarrera() { return carrera; }
    public void setCarrera(String carrera) throws DatoInvalidoException {
        if (carrera == null || carrera.trim().isEmpty()) throw new DatoInvalidoException("Carrera no puede estar vacía.");
        this.carrera = carrera.trim();
    }


    @Override
    public void mostrarDetalles() {
        System.out.println(super.toString());
        System.out.println("Universidad: " + universidad);
        System.out.println("Carrera: " + carrera);
    }
}
