package EjercicioDos;
import java.util.ArrayList;
public class Evento {
    private String nombreEvento;
    private ArrayList<Participante> listaParticipantes;

    public Evento(String nombreEvento) {
        if (nombreEvento == null || nombreEvento.isEmpty())
            throw new DatosInvalidosException("El nombre del evento no puede estar vacío.");

        this.nombreEvento = nombreEvento;
        this.listaParticipantes = new ArrayList<>();
    }

    public void agregarParticipante(Participante p) {
        listaParticipantes.add(p);
    }

    public void mostrarParticipantes() {
        if (listaParticipantes.isEmpty()) {
            System.out.println("No hay participantes registrados en este evento.");
            return;
        }

        System.out.println("\n--- Participantes del evento: " + nombreEvento + " ---");
        for (Participante p : listaParticipantes) {
            p.mostrarTipo(); // POLIMORFISMO
            System.out.println(p);
            System.out.println("-------------------------");
        }
    }

    @Override
    public String toString() {
        return nombreEvento;
    }
}
