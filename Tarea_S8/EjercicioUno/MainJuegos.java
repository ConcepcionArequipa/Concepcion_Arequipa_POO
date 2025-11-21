package EjercicioUno;
import java.util.ArrayList;
import java.util.Scanner;
public class MainJuegos {
    //Crear el array list
    private static ArrayList<Juego> juegos=new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        //Crear una instancia de MainJuegos porque los métodos no son estáticos.
        MainJuegos sistema=new MainJuegos();
        int opcion=0;

        do {
            System.out.println("\n----- SISTEMA DE JUEGOS -----");
            System.out.println("1. Registrar juego de Mario Bros");
            System.out.println("2. Registrar juego de Carrera de Vehículos");
            System.out.println("3. Mostrar todos los juegos");
            System.out.println("4. Buscar un juego por nombre");
            System.out.println("5. Filtrar por tipo de juego");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opcion: ");

            try {
                opcion=sc.nextInt();
            }
            catch (Exception e) {
                System.out.println("Ingrese una opcion valida");
                sc.nextLine();
                continue;
            }
            switch (opcion) {
                case 1:
                    sistema.registrarMarioBros();
                    break;
                case 2:
                    sistema.registrarCarreraVehiculos();
                    break;
                case 3:
                    sistema.mostrarJuegos();
                    break;
                case 4:
                    sistema.buscarJuego();
                    break;
                case 5:
                    sistema.filtrarPorTipo();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema....");
                    break;
                default:
                    System.out.println("Opcion no valida");

            }

        } while (opcion != 6);
    }

    public void registrarMarioBros(){
        sc.nextLine();
        System.out.println("\n--- Registro de juego de Mario Bros    ----");
        try {
            //Pedir los datos generales
            System.out.print("Ingrese el nombre del juego: ");
            String nombre1=sc.nextLine();
            validarTexto(nombre1,"El nombre del juego no puede estar vacio");
            System.out.print("Ingrese el precio del juego: $");
            double precio1=sc.nextDouble();
            validarPrecio(precio1);

            System.out.print("Ingrese año de lanzamiento del juego: ");
            int anio1=sc.nextInt();
            validarAnioLanzamiento(anio1);

            sc.nextLine();
            System.out.print("Ingrese el personaje principal del juego: ");
            String personajePrincipal=sc.nextLine();
            validarTexto(personajePrincipal,"El personaje principal no puede estar vacio");

            System.out.print("Ingrese el numero de mundos del juego: ");
            int numeroMundos=sc.nextInt();
            validarNumeroMundos(numeroMundos);

            System.out.print("Ingrese el numero de niveles del juego: ");
            int numeroNiveles=sc.nextInt();
            validarNumeroNiveles(numeroNiveles);
            //Agregar los atributos a la lista pero especificamente a la clase MarioBros

            juegos.add(new MarioBros(nombre1,precio1,anio1,personajePrincipal,numeroMundos,numeroNiveles));
        }
        catch (DatoInvalidoException e) {
            System.out.println("Error: " + e.getMessage());}
        catch (Exception e) {
            System.out.println("Entrada inválida. Debe ingresar valores correctos.");
            sc.nextLine();
        }
    }

    public void registrarCarreraVehiculos(){
        try {
            sc.nextLine();
            //Pedir los datos generales
            System.out.print("Ingrese el nombre del juego: ");
            String nombre2=sc.nextLine();
            validarTexto(nombre2,"El nombre del juego no puede estar vacio");

            System.out.print("Ingrese el precio del juego: $");
            double precio2=sc.nextDouble();
            validarPrecio(precio2);

            System.out.print("Ingrese año de lanzamiento del juego: ");
            int anio2=sc.nextInt();
            validarAnioLanzamiento(anio2);

            sc.nextLine();

            System.out.print("Ingrese el tipo de vehiculo del juego: ");
            String tipoVehiculo=sc.nextLine();
            validarTexto(tipoVehiculo,"El tipo de vehiculo no puede estar vacio");

            System.out.print("Ingrese el color del vehiculo: ");
            String colorVehiculo=sc.nextLine();
            validarTexto(colorVehiculo,"El color de vehiculo no puede estar vacio");

            System.out.print("Ingrese el numero de circuitos de la carrera: ");
            int numeroCircuitos=sc.nextInt();
            validarCircuitos(numeroCircuitos);


            System.out.print("Ingrese el numero de vueltas de la carrera: ");
            int numeroVueltas=sc.nextInt();
            validarVueltas(numeroVueltas);


            juegos.add(new CarreraVehiculos(nombre2,precio2,anio2,tipoVehiculo,colorVehiculo,numeroCircuitos,numeroVueltas));
        }
        catch (DatoInvalidoException e) {
        System.out.println("Error: " + e.getMessage());}
        catch (Exception e) {
        System.out.println("Entrada inválida. Debe ingresar valores correctos.");
        sc.nextLine();
    }
    }

    public void mostrarJuegos(){
        if (juegos.isEmpty()){
            System.out.println("No hay juegos registrados");
            return;
        }
        for (Juego juego : juegos){
            juego.mostrarDetallesJuego();
        }
    }

    public void buscarJuego(){

        System.out.println("Ingrese el nombre del juego: ");
        sc.nextLine();
        String nombreBuscado=sc.nextLine();

        boolean encontrado=false;
        for (Juego juego : juegos){
            if (juego.getNombre().equalsIgnoreCase(nombreBuscado)){
                juego.mostrarDetallesJuego(); //Polimorfismo
                encontrado=true; //Si se encontro
            }
        }
        if (!encontrado){
            System.out.println("No se encontro el juego");
        }
    }

    public void filtrarPorTipo() {
        System.out.println("1. Mario Bros");
        System.out.println("2. Carreras");
        System.out.print("Elija tipo: ");
        int tipo = sc.nextInt();

        boolean encontrado = false;
        for (Juego juego : juegos) {
            if (tipo == 1 && juego instanceof MarioBros) {
                juego.mostrarDetallesJuego();
                encontrado = true;
            }
            if (tipo == 2 && juego instanceof CarreraVehiculos) {
                juego.mostrarDetallesJuego();
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay juegos de ese tipo.");
        }
    }

    //Metodos de validacion
    public static void validarTexto(String texto,String mensajeError) throws DatoInvalidoException {
        if (texto == null || texto.trim().isEmpty()) {
            throw new DatoInvalidoException(mensajeError);
        }
    }

    public static void validarPrecio(double precio) throws DatoInvalidoException {
        if (precio<=0){
            throw new DatoInvalidoException("El precio no puede ser negativo o cero");
        }

    }

    public static void validarAnioLanzamiento(int anioLanzamiento) throws DatoInvalidoException {
        if (anioLanzamiento < 1950 || anioLanzamiento> 2025) {
            throw new DatoInvalidoException("El año de lanzamiento es inválido.");
        }
    }

    public static void validarNumeroMundos(int numeroMundos) throws DatoInvalidoException {
        if (numeroMundos<0 || numeroMundos > 8){
            throw new DatoInvalidoException("El número de mundos debe estar entre 0 y 8 ");
        }
    }

    public static void validarNumeroNiveles(int numeroNiveles) throws DatoInvalidoException {
        if (numeroNiveles<0 || numeroNiveles> 32){
            throw new DatoInvalidoException("El numero de niveles debe estr entre 0 y 32 ");
        }
    }

    public static void validarCircuitos(int cantidadCircuitos) throws DatoInvalidoException {
        if (cantidadCircuitos<0 || cantidadCircuitos > 20){
            throw new DatoInvalidoException("El cantidad de circuitos debe estar entre 0 y 20");
        }
    }

    public static void validarVueltas(int numeroVueltas) throws DatoInvalidoException {
        if (numeroVueltas<0 || numeroVueltas > 10){
            throw new DatoInvalidoException("El numero de vueltas debe estar entre 0 y 10");
        }
    }

}



