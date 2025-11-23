package EjercicioCuatro;


public class CandidataProfesional extends Candidata {
    private String profesion;
    private int aniosExperiencia;

    public CandidataProfesional(int id, String nombre, int edad, String distrito, double puntajeJurado,
                                String profesion, int aniosExperiencia) throws DatoInvalidoException {
        super(id, nombre, edad, distrito, puntajeJurado);
        setProfesion(profesion);
        setAniosExperiencia(aniosExperiencia);  // ahora sí corresponde al parámetro
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) throws DatoInvalidoException {
        if (profesion == null || profesion.trim().isEmpty())
            throw new DatoInvalidoException("Profesión no puede estar vacía.");

        this.profesion = profesion.trim();
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) throws DatoInvalidoException {
        if (aniosExperiencia < 0)
            throw new DatoInvalidoException("Años de experiencia no puede ser negativo.");

        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println(
                toString() + String.format(" — Profesional: %s — %d años exp.", profesion, aniosExperiencia)
        );
    }
}
