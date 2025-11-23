package EjercicioCuatro;

import java.time.LocalDateTime;


public class Voto {
    private static int contador = 1;
    private int idVoto;
    private int idCandidata;
    private LocalDateTime fechaHora;


    public Voto(int idCandidata) {
        this.idVoto = contador++;
        this.idCandidata = idCandidata;
        this.fechaHora = LocalDateTime.now();
    }


    public int getIdVoto() { return idVoto; }
    public int getIdCandidata() { return idCandidata; }
    public LocalDateTime getFechaHora() { return fechaHora; }
}

