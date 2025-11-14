package Practica;

import java.util.Scanner;

public class SistemaBancario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear objetos de ejemplo
        Cliente cliente = null; // solo un cliente
        Cajero cajero = new Cajero("Cajero de Quito", "1234567890", "Rocafuerte", "0962614590");
        BalconServicios balcon = new BalconServicios("Ana Benavidez", "0987654321", "Calle 2", "0980685079", "balcon1", "abcd");
        JefeAgencia jefe = new JefeAgencia("Carlos Fuentes", "1122334455", "Av.Maldonado", "0970695670","jefe123", "jefe123");

        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Ingresar como cliente");
            System.out.println("3. Ingresar como empleado");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1: // Registrar cliente
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Cédula: ");
                    String cedula = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();

                    cliente = new Cliente(nombre, cedula, direccion, telefono, "Sin cuenta", 0, 0);
                    System.out.println("Cliente registrado correctamente!");
                    break;

                case 2: // Ingresar como cliente
                    if (cliente == null) {
                        System.out.println("No hay ningún cliente registrado.");
                        break;
                    }

                    System.out.print("Ingrese su cédula: ");
                    String cedulaCliente = sc.nextLine();

                    if (cliente.getCedula().equals(cedulaCliente)) {
                        boolean clienteSalir = false;
                        while (!clienteSalir) {
                            System.out.println("\n--- MENÚ CLIENTE ---");
                            System.out.println("1. Ver resumen financiero");
                            System.out.println("2. Solicitar préstamo");
                            System.out.println("3. Ver saldo");
                            System.out.println("4. Salir");
                            System.out.print("Seleccione opción: ");
                            int opCliente = sc.nextInt();
                            sc.nextLine();

                            switch (opCliente) {
                                case 1:
                                    cliente.verResumenFinanciero();
                                    break;
                                case 2:
                                    System.out.print("Monto del préstamo: ");
                                    double monto = sc.nextDouble();
                                    sc.nextLine();
                                    cliente.solicitarPrestamo(monto);
                                    break;
                                case 3:
                                    cliente.consultarSaldo();
                                    break;
                                case 4:
                                    clienteSalir = true;
                                    break;
                                default:
                                    System.out.println("Opción inválida.");
                            }
                        }
                    } else {
                        System.out.println("Cédula incorrecta.");
                    }
                    break;

                case 3: // Ingresar como empleado
                    System.out.print("1. Cajero\n2.Balcon\n3.Jefe de agencia");
                    System.out.print("\nIngrese la opcion: ");
                    int opcionEmpleado= sc.nextInt();
                    sc.nextLine();
                    switch (opcionEmpleado) {
                        case 1: // Cajero
                            System.out.println("Bienvenido al cajero: " + cajero.getNombre());
                            System.out.println("1. Depositar\n2. Retirar\n3. Salir");
                            System.out.print("Ingrese la opción: ");
                            int opcionCajero = sc.nextInt();
                            sc.nextLine(); // Limpiar buffer

                            switch (opcionCajero) {
                                case 1: // Depositar
                                    if (cliente == null) {
                                        System.out.println("No hay ningún cliente registrado.");
                                        break;
                                    }
                                    System.out.print("Ingrese el monto a depositar: ");
                                    double montoDepositar = sc.nextDouble();
                                    sc.nextLine();
                                    cajero.procesarDeposito(cliente, montoDepositar); // Aquí pasas el objeto cliente
                                    break;

                                case 2: // Retirar
                                    if (cliente == null) {
                                        System.out.println("No hay ningún cliente registrado.");
                                        break;
                                    }
                                    System.out.print("Ingrese el monto a retirar: ");
                                    double montoRetirar = sc.nextDouble();
                                    sc.nextLine();
                                    cajero.procesarRetiro(cliente, montoRetirar); // similar al depósito
                                    break;

                                case 3: // Salir
                                    System.out.println("Saliendo del menú Cajero...");
                                    break;

                                default:
                                    System.out.println("Opción inválida.");
                            }
                            break;

                        case 2:
                            System.out.print("Usuario: ");
                            String usuarioBalcon = sc.nextLine();
                            System.out.print("Clave: ");
                            String claveBalcon = sc.nextLine();

                            if (balcon.autenticarEmpleado(usuarioBalcon, claveBalcon)) {
                                System.out.println("Bienvenido al Balcón: " + balcon.getNombre());

                                boolean salirBalcon = false;
                                while (!salirBalcon) {
                                    System.out.println("\n--- MENÚ BALCÓN ---");
                                    System.out.println("1. Registrar nuevo cliente");
                                    System.out.println("2. Actualizar datos de cliente");
                                    System.out.println("3. Salir");
                                    System.out.print("Seleccione opción: ");
                                    int opcionBalcon = sc.nextInt();
                                    sc.nextLine(); // Limpiar buffer

                                    switch (opcionBalcon) {
                                        case 1: // Registrar nuevo cliente
                                            cliente = balcon.registrarNuevoCliente(); // devuelve un cliente con datos por defecto
                                            break;

                                        case 2: // Actualizar datos de cliente
                                            if (cliente == null) {
                                                System.out.println("No hay ningún cliente registrado.");
                                                break;
                                            }
                                            balcon.actualizarDatosCliente(cliente); // actualiza datos existentes
                                            break;

                                        case 3:
                                            salirBalcon = true;
                                            System.out.println("Saliendo del menú Balcón...");
                                            break;

                                        default:
                                            System.out.println("Opción inválida.");
                                    }
                                }

                            } else {
                                System.out.println("Usuario o clave incorrectos.");
                            }
                            break;

                        case 3: // Jefe de Agencia
                            System.out.print("Usuario: ");
                            String usuarioJefe = sc.nextLine();
                            System.out.print("Clave: ");
                            String claveJefe = sc.nextLine();

                            if (jefe.autenticarEmpleado(usuarioJefe, claveJefe)) {
                                System.out.println("Bienvenido Jefe de Agencia: " + jefe.getNombre());
                                boolean jefeSalir = false;

                                while (!jefeSalir) {
                                    System.out.println("\n--- MENÚ JEFE DE AGENCIA ---");
                                    System.out.println("1. Aprobar préstamo");
                                    System.out.println("2. Generar reporte de operaciones");
                                    System.out.println("3. Salir");
                                    System.out.print("Seleccione una opción: ");
                                    int opcionJefe = sc.nextInt();
                                    sc.nextLine(); // Limpiar buffer

                                    switch (opcionJefe) {
                                        case 1: // Aprobar préstamo
                                            if (cliente == null) {
                                                System.out.println("No hay cliente registrado.");
                                                break;
                                            }
                                            System.out.print("Ingrese el monto del préstamo: ");
                                            double montoPrestamo = sc.nextDouble();
                                            sc.nextLine();
                                            jefe.aprobarPrestamo(cliente, montoPrestamo);
                                            break;

                                        case 2: // Generar reporte
                                            jefe.generarReporteOperaciones();
                                            break;

                                        case 3:
                                            jefeSalir = true;
                                            System.out.println("Saliendo del menú Jefe de Agencia...");
                                            break;

                                        default:
                                            System.out.println("Opción inválida.");
                                    }
                                }

                            } else {
                                System.out.println("Usuario o clave incorrectos.");
                            }
                            break;
                        case 4:
                            salir = true;
                            System.out.println("Saliendo del sistema...");
                            break;
                        default:
                            System.out.println("Opción inválida.");
            }
        }

    }
        sc.close();

}
}
