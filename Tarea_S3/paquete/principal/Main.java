package paquete.principal;

//Importar la clase Scanner
import java.util.Scanner;

//Importar las clases de otros paquetes
import paquete.artista.Artista;
import paquete.cancion.Cancion;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //Crear objeto
        Artista artistaNuevo= new Artista();
        Cancion cancionNueva= new Cancion();

        while (true){
            System.out.println("--------MENU----------");
            System.out.println("1.Registrar un artista\n2.Registrar una cancion\n3.Aumentar seguidores\n4.Reproducir una cancion\n5.Mostrar informacion general");
            System.out.print("Ingrese la opcion: ");
            int opcion = entrada.nextInt();
            entrada.nextLine();
            //Uso del switch para las opciones
            switch (opcion) {
                case 1:
                    System.out.println("-----Registro del artista------");
                    System.out.print("Ingrese el nombre del artista: ");
                    String nombreNuevo = entrada.nextLine();
                    artistaNuevo.setNombre(nombreNuevo);

                    System.out.print("Ingrese el genero del artista: ");
                    String generoNuevo= entrada.nextLine();
                    artistaNuevo.setGenero(generoNuevo);

                    System.out.print("Ingrese el numero de seguidores: ");
                    int seguidoresNuevo= entrada.nextInt();
                    artistaNuevo.setSeguidores(seguidoresNuevo);
                    break;

                case 2:
                    System.out.println("-----Registro de la cancion------");
                    System.out.print("Ingrese el titulo de la cancion: ");
                    String tituloNuevo = entrada.nextLine();
                    cancionNueva.setTitulo(tituloNuevo);

                    System.out.print("Ingrese el duracion de la cancion: ");
                    double duracionNueva= entrada.nextDouble();
                    cancionNueva.setDuracion(duracionNueva);

                    System.out.print("Ingrese el numero de reproducciones: ");
                    int reproduccionesNueva= entrada.nextInt();
                    cancionNueva.setReproducciones(reproduccionesNueva);
                    break;

                case 3:
                    System.out.println("-----Aumentar seguidores------");
                    System.out.print("Ingrese la cantidad de seguidores que quiere aumentar:");
                    int cantidad= entrada.nextInt();
                    artistaNuevo.ganarSeguidores(cantidad);
                    break;

                case 4:
                    System.out.println("-----Reproducir una cancion------");
                    cancionNueva.reproducir();
                    System.out.println("Se reprodujo la cancion con exito");
                    break;

                case 5:
                    System.out.println("------Informacion General------");
                    artistaNuevo.mostrarPerfil();
                    cancionNueva.mostrarCancion();
                    break;
                default:
                    System.out.print("Opcion no valida");
            }
        }

    }
    }
