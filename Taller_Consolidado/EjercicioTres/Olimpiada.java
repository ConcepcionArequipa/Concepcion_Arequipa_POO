package EjercicioTres;
import java.util.ArrayList;
public class Olimpiada {
    private String nombre;
    private int año;
    private ArrayList<Evento> eventos;

    public Olimpiada(String nombre, int año) {
        this.nombre = nombre;
        this.año = año;
        this.eventos = new ArrayList<>();
    }

    public void agregarEvento(Evento e) {
        eventos.add(e);
    }

    public Evento buscarEvento(String nombre) {
        for (Evento e : eventos) {
            if (e.toString().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }

    public void mostrarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("No hay eventos registrados.");
            return;
        }

        System.out.println("\n--- Eventos en la Olimpiada ---");
        for (Evento e : eventos) {
            System.out.println("- " + e);
        }
    }

}
