package SegundoEjercicio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDispositivo{

    public static void main(String[] args) {
        // Lista para almacenar los dispositivos (Polimorfismo)
        List<Dispositivo> inventario = new ArrayList<>();
        // Objeto Scanner para la entrada de datos
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n===========================================");
            System.out.println("--- MENÚ DE GESTIÓN DE DISPOSITIVOS ---");
            System.out.println("1. Registrar una nueva laptop");
            System.out.println("2. Registrar un nuevo telefono");
            System.out.println("3. Mostrar todos los dispositivos");
            System.out.println("4. Salir del programa");
            System.out.println("===========================================");
            System.out.print("Seleccione una opción: ");

            // Manejo de excepción para entradas no numericas en la opción
            try {
                // Lee la línea completa y la intenta convertir a entero
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                opcion = -1; // Fuerza una opción inválida
            }

            switch (opcion) {
                case 1:
                    registrarLaptop(inventario, scanner);
                    break;
                case 2:
                    registrarTelefono(inventario, scanner);
                    break;
                case 3:
                    mostrarInventario(inventario);
                    break;
                case 4:
                    System.out.println("\nSaliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida ");
            }
        } while (opcion != 4);

        scanner.close(); // Siempre cerrar el Scanner
    }

    // MÉTODOS AUXILIARES PARA EL REGISTRO

    private static void registrarLaptop(List<Dispositivo> inventario, Scanner scanner) {
        System.out.println("\n---  REGISTRO DE NUEVA LAPTOP ---");
        // El try-catch envuelve toda la lógica de entrada y creación para manejar
        // tanto DatoInvalidoException como NumberFormatException

        try {
            System.out.print("Ingrese la marca de la laptop: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el modelo de la laptop: ");
            String modelo = scanner.nextLine();

            System.out.print("Ingrese el precio de la laptop: $");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese la cantidad de memoria RAM (GB): ");
            int ramGB = Integer.parseInt(scanner.nextLine());

            System.out.print("Ingrese el procesador: ");
            String procesador = scanner.nextLine();

            System.out.print("Ingrese el tamaño de la laptop (pulgadas): ");
            int tamanio = Integer.parseInt(scanner.nextLine());

            // La creación del objeto lanza DatoInvalidoException si marca o precio son inválidos
            Laptop nuevaLaptop = new Laptop(marca, modelo, precio, ramGB, procesador, tamanio);
            inventario.add(nuevaLaptop);

            System.out.println("\nLaptop registrada con éxito: " + marca + " " + modelo);

        } catch (DatoInvalidoException e) {
            // Captura de nuestra excepción personalizada
            System.out.println("\nError de registro: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Captura si el usuario ingresa texto en lugar de números (Precio, RAM, Tamaño)
            System.out.println("\nError de entrada: Asegúrese de ingresar valores numéricos válidos para Precio, RAM y Tamaño.");
        }
    }

    private static void registrarTelefono(List<Dispositivo> inventario, Scanner scanner) {
        System.out.println("\n--- REGISTRO DE UN NUEVO TELEFONO ---");

        try {
            System.out.print("Ingrese la marca del telefono: ");
            String marca = scanner.nextLine();

            System.out.print("Ingrese el modelo del telefono: ");
            String modelo = scanner.nextLine();

            System.out.print("Ingrese el precio del telefono: $");
            double precio = Double.parseDouble(scanner.nextLine());

            System.out.print("Ingrese su sistema operativo: ");
            String sistemaOperativo = scanner.nextLine();

            System.out.print("Ingrese la cantidad de almacenamiento (GB): ");
            double almacenamiento = Double.parseDouble(scanner.nextLine());

            // La creación del objeto lanza DatoInvalidoException
            Telefono nuevoTelefono = new Telefono(marca, modelo, precio, sistemaOperativo, almacenamiento);
            inventario.add(nuevoTelefono);

            System.out.println("\nTeléfono registrado con éxito: " + marca + " " + modelo);

        } catch (DatoInvalidoException e) {
            // Captura de nuestra excepción personalizada
            System.out.println("\nError de registro: " + e.getMessage());
        } catch (NumberFormatException e) {
            // Captura si el usuario ingresa texto en lugar de números (Precio, Almacenamiento)
            System.out.println("\nError de entrada: Asegúrese de ingresar valores numéricos válidos para Precio y Almacenamiento.");
        }
    }

    private static void mostrarInventario(List<Dispositivo> inventario) {
        if (inventario.isEmpty()) {
            System.out.println("No hay dispositivos registrados ");
            return;
        }

        // Iteración para demostrar el POLIMORFISMO
        for (Dispositivo d : inventario) {
            // Se llama al metodo mostrarInfo() correcto
            d.mostrarInfo();
            System.out.println("-------------------------------------------");
        }
    }
}