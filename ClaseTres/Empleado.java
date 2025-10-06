import java.util.Scanner;

public class Empleado {
    String nombre;
    String cargo;
    double salario;
    String fecha;

    public Empleado(String nombre, String cargo, double salario, String fecha) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.fecha = fecha;
    }

    void mostrar(){
        System.out.println("Nombre del empleado: "+nombre+", cargo: "+cargo+", salario: "+salario+" y fecha de ingreso a la empresa: "+fecha);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese el cargo del empleado: ");
        String cargo = sc.nextLine();
        System.out.println("Ingrese el salario del empleado: ");
        double salario = sc.nextDouble();
        System.out.println("Ingrese el fecha de ingreso del empleado: ");
        String fecha = sc.nextLine();
        Empleado empleado1 = new Empleado(nombre, cargo, salario, fecha);
        Empleado empleado2 = new Empleado(nombre, cargo, salario, fecha);
        Empleado empleado3 = new Empleado(nombre, cargo, salario, fecha);

        empleado1.mostrar();
        empleado2.mostrar();
        empleado3.mostrar();

    }

    }

