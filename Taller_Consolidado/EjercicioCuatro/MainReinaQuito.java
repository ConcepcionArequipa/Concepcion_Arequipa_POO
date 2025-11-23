package EjercicioCuatro;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class MainReinaQuito {
    private static Scanner sc = new Scanner(System.in);
    private static Concurso concurso = new Concurso();
    private static int siguienteId = 1;

    public static void main(String[] args) {
        System.out.println("=== Sistema Concurso: Reina de Quito (consola) ===");
        cargarDatosDePrueba();
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            String opcion = sc.nextLine().trim();
            try {
                switch (opcion) {
                    case "1": registrarCandidata(); break;
                    case "2": listarTodas(); break;
                    case "3": buscarPorNombreOId(); break;
                    case "4": filtrarPorTipoODistrito(); break;
                    case "5": menuVotos(); break;
                    case "6": mostrarResultadosYGanador(); break;
                    case "7": editarOEliminar(); break;
                    case "0": salir = true; break;
                    default: System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (DatoInvalidoException ex) {
                System.out.println("Error de validación: " + ex.getMessage());
            } catch (NumberFormatException ex) {
                System.out.println("Entrada numérica inválida.");
            } catch (Exception ex) {
                System.out.println("Error inesperado: " + ex.getMessage());
            }
        }
        System.out.println("Saliendo. ¡Hasta luego!");
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú ---");
        System.out.println("1. Registrar candidata");
        System.out.println("2. Listar todas");
        System.out.println("3. Buscar por nombre / id");
        System.out.println("4. Filtrar por tipo / distrito");
        System.out.println("5. Simular voto / registrar voto manual");
        System.out.println("6. Mostrar resultados y ganador");
        System.out.println("7. Editar / Eliminar candidata");
        System.out.println("0. Salir");
        System.out.print("Elige una opción: ");
    }

    // 1. Registrar candidata (solo Estudiante o Profesional)
    private static void registrarCandidata() throws DatoInvalidoException {
        System.out.println("\n--- Registrar nueva candidata ---");
        System.out.print("Tipo (1 = Estudiante, 2 = Profesional): ");
        String tipo = sc.nextLine().trim();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Edad: ");
        int edad = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Distrito: ");
        String distrito = sc.nextLine();
        System.out.print("Puntaje jurado (0-100): ");
        double puntaje = Double.parseDouble(sc.nextLine().trim());

        if (tipo.equals("1")) {
            System.out.print("Universidad: ");
            String universidad = sc.nextLine();
            System.out.print("Carrera: ");
            String carrera = sc.nextLine();
            CandidataEstudiante ce = new CandidataEstudiante(siguienteId++, nombre, edad, distrito, puntaje, universidad, carrera);
            concurso.registrarCandidata(ce);
            System.out.println("Candidata estudiante registrada: " + ce);
        } else if (tipo.equals("2")) {
            System.out.print("Profesión: ");
            String profesion = sc.nextLine();
            System.out.print("Años de experiencia: ");
            int anios = Integer.parseInt(sc.nextLine().trim());
            CandidataProfesional cp = new CandidataProfesional(siguienteId++, nombre, edad, distrito, puntaje, profesion, anios);
            concurso.registrarCandidata(cp);
            System.out.println("Candidata profesional registrada: " + cp);
        } else {
            System.out.println("Tipo inválido. Solo 1 (Estudiante) o 2 (Profesional).");
        }
    }

    // 2. Listar todas (usamos buscarPorNombre con cadena vacía para devolver todas)
    private static void listarTodas() {
        System.out.println("\n--- Listado de candidatas ---");
        List<Candidata> todas = concurso.buscarPorNombre("");
        if (todas.isEmpty()) {
            System.out.println("No hay candidatas registradas.");
            return;
        }
        for (Candidata c : todas) c.mostrarDetalles();
    }

    // 3. Buscar por nombre o id
    private static void buscarPorNombreOId() {
        System.out.print("Buscar por (1 = id, 2 = nombre): ");
        String op = sc.nextLine().trim();
        if (op.equals("1")) {
            System.out.print("Id: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Candidata c = concurso.buscarPorId(id);
            if (c == null) System.out.println("No encontrada.");
            else c.mostrarDetalles();
        } else {
            System.out.print("Nombre (o parte): ");
            String nombre = sc.nextLine();
            List<Candidata> res = concurso.buscarPorNombre(nombre);
            if (res.isEmpty()) System.out.println("No se encontraron candidatas con ese nombre.");
            else res.forEach(Candidata::mostrarDetalles);
        }
    }

    // 4. Filtrar por tipo o distrito
    private static void filtrarPorTipoODistrito() {
        System.out.print("Filtrar por (1 = tipo, 2 = distrito): ");
        String op = sc.nextLine().trim();
        if (op.equals("1")) {
            System.out.print("Tipo (estudiante / profesional): ");
            String tipo = sc.nextLine().trim().toLowerCase();
            List<Candidata> res;
            if (tipo.equals("estudiante")) res = concurso.filtrarPorTipo("estudiante");
            else if (tipo.equals("profesional")) res = concurso.filtrarPorTipo("profesional");
            else {
                System.out.println("Tipo no reconocido.");
                return;
            }
            if (res.isEmpty()) System.out.println("No hay candidatas de ese tipo.");
            else res.forEach(Candidata::mostrarDetalles);
        } else {
            System.out.print("Distrito: ");
            String distrito = sc.nextLine();
            List<Candidata> res = concurso.filtrarPorDistrito(distrito);
            if (res.isEmpty()) System.out.println("No hay candidatas en ese distrito.");
            else res.forEach(Candidata::mostrarDetalles);
        }
    }

    // 5. Menú de votos: manual o importar/simular
    private static void menuVotos() {
        System.out.println("\n--- Votación ---");
        System.out.println("1. Votar manual (ingresar id)");
        System.out.println("2. Importar/simular 50 votos de muestra");
        System.out.print("Elige: ");
        String op = sc.nextLine().trim();
        if (op.equals("1")) {
            votarManual();
        } else if (op.equals("2")) {
            concurso.cargarVotosDeEjemplo();
            System.out.println("Se importaron votos de muestra.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    private static void votarManual() {
        System.out.print("Id candidata: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        boolean ok = concurso.votar(id);
        if (ok) System.out.println("Voto registrado para id " + id);
        else System.out.println("No existe candidata con id " + id);
    }

    // 6. Mostrar resultados y ganadora(s)
    private static void mostrarResultadosYGanador() {
        System.out.println();
        concurso.mostrarResultados(); // imprime el ranking (si lo implementaste)
        List<Candidata> ganadoras = concurso.obtenerGanadoras();
        if (ganadoras.isEmpty()) {
            System.out.println("\nNo hay ganador (sin votos).");
            return;
        }
        if (ganadoras.size() == 1) {
            System.out.println("\nGanadora:");
            ganadoras.get(0).mostrarDetalles();
        } else {
            System.out.println("\nEmpate entre las siguientes candidatas (desempate por puntaje jurado):");
            for (Candidata c : ganadoras) c.mostrarDetalles();
        }
    }

    // 7. Editar o eliminar candidata
    private static void editarOEliminar() throws DatoInvalidoException {
        System.out.print("Editar (1) o Eliminar (2): ");
        String op = sc.nextLine().trim();
        if (op.equals("1")) {
            System.out.print("Id a editar: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            Candidata c = concurso.buscarPorId(id);
            if (c == null) { System.out.println("No encontrada."); return; }
            System.out.print("Nuevo nombre (enter para mantener: " + c.getNombre() + "): ");
            String nombre = sc.nextLine();
            if (!nombre.trim().isEmpty()) c.setNombre(nombre);
            System.out.print("Nueva edad (enter para mantener: " + c.getEdad() + "): ");
            String edadS = sc.nextLine();
            if (!edadS.trim().isEmpty()) c.setEdad(Integer.parseInt(edadS.trim()));
            System.out.print("Nuevo distrito (enter para mantener: " + c.getDistrito() + "): ");
            String dist = sc.nextLine();
            if (!dist.trim().isEmpty()) c.setDistrito(dist);
            System.out.print("Nuevo puntaje jurado (enter para mantener: " + c.getPuntajeJurado() + "): ");
            String puntS = sc.nextLine();
            if (!puntS.trim().isEmpty()) c.setPuntajeJurado(Double.parseDouble(puntS.trim()));

            // campos específicos
            if (c instanceof CandidataEstudiante) {
                CandidataEstudiante ce = (CandidataEstudiante) c;
                System.out.print("Nueva universidad (enter para mantener: " + ce.getUniversidad() + "): ");
                String u = sc.nextLine(); if (!u.trim().isEmpty()) ce.setUniversidad(u);
                System.out.print("Nueva carrera (enter para mantener: " + ce.getCarrera() + "): ");
                String ca = sc.nextLine(); if (!ca.trim().isEmpty()) ce.setCarrera(ca);
            } else if (c instanceof CandidataProfesional) {
                CandidataProfesional cp = (CandidataProfesional) c;
                System.out.print("Nueva profesión (enter para mantener: " + cp.getProfesion() + "): ");
                String p = sc.nextLine(); if (!p.trim().isEmpty()) cp.setProfesion(p);
                System.out.print("Nuevos años exp (enter para mantener: " + cp.getAniosExperiencia() + "): ");
                String a = sc.nextLine(); if (!a.trim().isEmpty()) cp.setAniosExperiencia(Integer.parseInt(a.trim()));
            }

            System.out.println("Candidata actualizada.");
        } else if (op.equals("2")) {
            System.out.print("Id a eliminar: ");
            int id = Integer.parseInt(sc.nextLine().trim());
            boolean ok = concurso.eliminarCandidata(id);
            System.out.println(ok ? "Eliminada." : "No encontrada.");
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // Carga de datos de prueba (mínimo 5 candidatas recomendado)
    private static void cargarDatosDePrueba() {
        try {
            concurso.registrarCandidata(new CandidataEstudiante(siguienteId++, "María Gómez", 19, "Centro", 87.5, "UDD", "Arquitectura"));
            concurso.registrarCandidata(new CandidataProfesional(siguienteId++, "Lucía Pérez", 26, "La Floresta", 90.0, "Abogada", 4));
            concurso.registrarCandidata(new CandidataEstudiante(siguienteId++, "Ana Torres", 22, "Sur", 78.0, "UPS", "Turismo"));
            concurso.registrarCandidata(new CandidataProfesional(siguienteId++, "Sofía Ruiz", 28, "Norte", 92.3, "Ingeniera", 6));
            concurso.registrarCandidata(new CandidataProfesional(siguienteId++, "Carolina Díaz", 24, "Centro", 88.0, "Médica", 2));

            // Opcional: algunos votos de ejemplo
            concurso.cargarVotosDeEjemplo();
            System.out.println("Se cargaron candidatas de prueba y votos de ejemplo.");
        } catch (DatoInvalidoException ex) {
            System.out.println("Error en datos de prueba: " + ex.getMessage());
        }
    }
}
