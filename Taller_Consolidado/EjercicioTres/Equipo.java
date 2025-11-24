package EjercicioTres;

public class Equipo extends Participante{
    private int numeroIntegrantes;
    public Equipo(String nombre, int edad, String deporte, String pais, int numeroIntegrantes) {
        super(nombre, edad, deporte, pais);
        if (numeroIntegrantes <= 0) {
            throw new DatosInvalidosException("El numero de integrantes debe ser mayor que cero.");
        }
        this.numeroIntegrantes = numeroIntegrantes;
    }
    @Override
    public void mostrarTipo(){
        System.out.println("Tipo de participante: Equipo deportivo");
    }

    @Override
    public String toString() {
        return super.toString() +
                "Numero de integrantes: " + numeroIntegrantes + "\n";
    }
}
