//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner entrada = new Scanner(System.in);
    private static ArrayList<Empleado> listaEmpleados = new ArrayList<>();
    private static ArrayList<EmpleadoTiempoCompleto>listaEmpleadosTiempoCompleto = new ArrayList<>();
    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("------ MENU DE EMPLEADOS ----- ");
            System.out.println("1. Registrar empleado tiempo completo\n2.Registrar empleado medio tiempo\n3.Mostrar empleados registrados\n4.Mostrar estadisticas\n5.Salir del programa");
            System.out.print("Ingrese el opcion: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); //Limpiar el buffer
            switch (opcion) {
                case 1:
                    System.out.println("------- Registro de empleados tiempo completo ------");
                    System.out.println("Ingrese el codigo del empleado: ");
                    int codigo = entrada.nextInt();
                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingrese el apellido del empleado: ");
                    String apellido = entrada.nextLine();
                    System.out.println("Ingrese el cargo del empleado: ");
                    double cargo = entrada.nextDouble();
                    System.out.println("Ingrese el sueldo base del empleado: $");
                    double sueldoBase = entrada.nextDouble();
                    System.out.println("Ingrese la cantidad del bono adicional del empleado: $");
            }
        }

        while (opcion != 5);

    }


    //Metodos para la gestion de empleados

    public void registrarEmpleados(Empleado empleado){
        listaEmpleados.add(empleado);
    }


    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println("No existen empleados registrados");
        }
        else {
            //Con for each
            System.out.println("------ Lista de empleados------");
            for (Empleado empleado : listaEmpleados) {
                System.out.println(empleado);
            }
        }
    }

    public void mostrarEstadisticas() {
        System.out.println("------ Estadisticas------");
        if (listaEmpleados.isEmpty()) {
            System.out.println("No existen empleados registrados");
        }
        else {
            mayorSueldo();
            mostrarPromedioSalarial();
        }
    }

    public void mayorSueldo() {
        Empleado empleadoMayorSueldo = null;
        double mayorSueldo = 0; //Para comparar
        for (Empleado empleado : listaEmpleados) {
            if (mayorSueldo< empleado.calcularSalario()){
                mayorSueldo = empleado.calcularSalario();
                empleadoMayorSueldo = empleado;
            }
        }
        System.out.println("El empleado con mayor sueldo es: " +empleadoMayorSueldo.getNombre());
        System.out.println("Sueldo: $"+mayorSueldo);
    }

    public void mostrarPromedioSalarial() {
        double promedioSalarial = 0;
        for (Empleado empleado : listaEmpleados) {
            promedioSalarial += empleado.calcularSalario();
        }
        System.out.println("El promedio salario es: "+promedioSalarial);
    }

}