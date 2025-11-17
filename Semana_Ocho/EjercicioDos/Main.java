package EjercicioDos;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Olimpiada olimpiada = new Olimpiada("Olimpiadas Internacionales", 2025);

        int opcion = -1;

        while (opcion != 6) {
            System.out.println("\n======= MENÚ PRINCIPAL =======");
            System.out.println("1. Crear evento");
            System.out.println("2. Registrar atleta");
            System.out.println("3. Registrar equipo");
            System.out.println("4. Mostrar eventos");
            System.out.println("5. Mostrar participantes de un evento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            try {

                switch (opcion) {

                    case 1: {
                        System.out.print("Ingrese el nombre del evento: ");
                        String nombreEvento = sc.nextLine();
                        Evento e = new Evento(nombreEvento);
                        olimpiada.agregarEvento(e);
                        System.out.println("Evento creado exitosamente.");
                        break;
                    }

                    case 2: {
                        System.out.print("Nombre del evento donde registrar: ");
                        String nombreEvento = sc.nextLine();
                        Evento e = olimpiada.buscarEvento(nombreEvento);

                        if (e == null) {
                            System.out.println("Evento no encontrado.");
                            break;
                        }

                        System.out.print("Nombre del atleta: ");
                        String nombre = sc.nextLine();
                        System.out.print("Edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Deporte: ");
                        String deporte = sc.nextLine();
                        System.out.print("País: ");
                        String pais = sc.nextLine();
                        System.out.print("Número de dorsal: ");
                        int dorsal = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Categoría: ");
                        String categoria = sc.nextLine();

                        Atleta a = new Atleta(nombre, edad, deporte, pais, dorsal, categoria);
                        e.agregarParticipante(a);

                        System.out.println("Atleta registrado correctamente.");
                        break;
                    }

                    case 3: {
                        System.out.print("Nombre del evento donde registrar: ");
                        String nombreEvento = sc.nextLine();
                        Evento e = olimpiada.buscarEvento(nombreEvento);

                        if (e == null) {
                            System.out.println("Evento no encontrado.");
                            break;
                        }

                        System.out.print("Nombre del equipo: ");
                        String nombre = sc.nextLine();
                        System.out.print("Edad del representante: ");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Deporte: ");
                        String deporte = sc.nextLine();
                        System.out.print("País: ");
                        String pais = sc.nextLine();
                        System.out.print("Número de integrantes: ");
                        int integrantes = sc.nextInt();

                        Equipo eq = new Equipo(nombre, edad, deporte, pais, integrantes);
                        e.agregarParticipante(eq);

                        System.out.println("Equipo registrado correctamente.");
                        break;
                    }

                    case 4:
                        olimpiada.mostrarEventos();
                        break;

                    case 5: {
                        System.out.print("Ingrese el nombre del evento: ");
                        String nombreEvento = sc.nextLine();
                        Evento e = olimpiada.buscarEvento(nombreEvento);

                        if (e == null) {
                            System.out.println("Evento no encontrado.");
                        } else {
                            e.mostrarParticipantes();
                        }
                        break;
                    }

                    case 6:
                        System.out.println("Saliendo...");
                        break;

                    default:
                        System.out.println("Opción inválida.");
                }

            } catch (DatosInvalidosException ex) {
                System.out.println("ERROR: " + ex.getMessage());
            }
        }

        sc.close();
    }
}
