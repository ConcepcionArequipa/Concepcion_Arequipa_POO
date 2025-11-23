package EjercicioCuatro;

import java.util.*;

public class Concurso {
    private List<Candidata> listaCandidatas;
    private List<Voto> votos;

    public Concurso() {
        listaCandidatas = new ArrayList<>();
        votos = new ArrayList<>();
    }

    // ---------------------------------------------------------
    //  CRUD DE CANDIDATAS
    // ---------------------------------------------------------
    public void registrarCandidata(Candidata c) {
        listaCandidatas.add(c);
    }

    public boolean eliminarCandidata(int id) {
        return listaCandidatas.removeIf(c -> c.getId() == id);
    }

    public Candidata buscarPorId(int id) {
        for (Candidata c : listaCandidatas)
            if (c.getId() == id) return c;
        return null;
    }

    public List<Candidata> buscarPorNombre(String nombre) {
        List<Candidata> res = new ArrayList<>();
        for (Candidata c : listaCandidatas)
            if (c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                res.add(c);
        return res;
    }

    // ---------------------------------------------------------
    //  FILTROS
    // ---------------------------------------------------------
    public List<Candidata> filtrarPorTipo(String tipo) {
        List<Candidata> res = new ArrayList<>();

        for (Candidata c : listaCandidatas) {
            switch (tipo.toLowerCase()) {
                case "estudiante":
                    if (c instanceof CandidataEstudiante) res.add(c);
                    break;

                case "profesional":
                    if (c instanceof CandidataProfesional) res.add(c);
                    break;

                case "otro":
                    if (!(c instanceof CandidataEstudiante) &&
                            !(c instanceof CandidataProfesional))
                        res.add(c);
                    break;
            }
        }
        return res;
    }

    public List<Candidata> filtrarPorDistrito(String distrito) {
        List<Candidata> res = new ArrayList<>();
        for (Candidata c : listaCandidatas)
            if (c.getDistrito().equalsIgnoreCase(distrito))
                res.add(c);
        return res;
    }

    // ---------------------------------------------------------
    //  VOTACIÓN
    // ---------------------------------------------------------
    public boolean votar(int idCandidata) {
        Candidata c = buscarPorId(idCandidata);
        if (c == null) return false;

        votos.add(new Voto(idCandidata));
        return true;
    }

    public void cargarVotosDeEjemplo() {
        if (listaCandidatas.isEmpty()) return;

        Random r = new Random();
        for (int i = 0; i < 50; i++) {
            int pos = r.nextInt(listaCandidatas.size());
            int id = listaCandidatas.get(pos).getId();
            votos.add(new Voto(id));
        }
    }

    // ---------------------------------------------------------
    //  RESULTADOS
    // ---------------------------------------------------------
    public Map<Integer, Integer> contarVotos() {
        Map<Integer, Integer> conteo = new HashMap<>();

        for (Voto v : votos) {
            conteo.put(v.getIdCandidata(),
                    conteo.getOrDefault(v.getIdCandidata(), 0) + 1);
        }

        return conteo;
    }

    public void mostrarResultados() {
        Map<Integer, Integer> conteo = contarVotos();

        System.out.println("\n===== RESULTADOS =====");
        for (Candidata c : listaCandidatas) {
            int votosC = conteo.getOrDefault(c.getId(), 0);
            System.out.printf("%s — Votos: %d%n", c.toString(), votosC);
        }
    }

    // ---------------------------------------------------------
    //  GANADOR — desempate por puntaje del jurado
    // ---------------------------------------------------------
    public List<Candidata> obtenerGanadoras() {
        Map<Integer, Integer> conteo = contarVotos();

        int maxVotos = -1;
        for (int v : conteo.values())
            if (v > maxVotos)
                maxVotos = v;

        // Lista preliminar con máximas votaciones
        List<Candidata> candidatasMax = new ArrayList<>();
        for (Candidata c : listaCandidatas) {
            int votosC = conteo.getOrDefault(c.getId(), 0);
            if (votosC == maxVotos)
                candidatasMax.add(c);
        }

        // Empate → desempate usando puntaje jurado
        if (candidatasMax.size() > 1) {
            double maxPuntaje = -1;
            for (Candidata c : candidatasMax)
                if (c.getPuntajeJurado() > maxPuntaje)
                    maxPuntaje = c.getPuntajeJurado();

            List<Candidata> finalistas = new ArrayList<>();
            for (Candidata c : candidatasMax)
                if (c.getPuntajeJurado() == maxPuntaje)
                    finalistas.add(c);

            return finalistas;
        }

        return candidatasMax;
    }
}
