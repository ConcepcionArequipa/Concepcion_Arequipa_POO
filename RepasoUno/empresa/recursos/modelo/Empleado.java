package empresa.recursos.modelo;

public class Empleado {
    private String nombreCompleto;
    private String cedula;
    private double salarioMensual;
    private int aniosAntiguedad;
    private boolean esGerente;

    // Constructor
    public Empleado(String nombreCompleto, String cedula, double salarioMensual, int aniosAntiguedad, boolean esGerente) {
        setNombreCompleto(nombreCompleto);
        setCedula(cedula);
        setSalarioMensual(salarioMensual);
        setAniosAntiguedad(aniosAntiguedad);
        setEsGerente(esGerente);
    }

    // Getters
    public String getNombreCompleto() { return nombreCompleto; }
    public String getCedula() { return cedula; }
    public double getSalarioMensual() { return salarioMensual; }
    public int getAniosAntiguedad() { return aniosAntiguedad; }
    public boolean isEsGerente() { return esGerente; }

    // Setters con validaciones
    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
            System.out.println("El nombre no puede estar vacío o ser nulo");
        } else {
            this.nombreCompleto = nombreCompleto;
        }
    }

    public void setCedula(String cedula) {
        if (cedula != null && cedula.matches("\\d{10}")) {
            this.cedula = cedula;
        } else {
            System.out.println("Cédula inválida (debe tener 10 dígitos)");
        }
    }

    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual >= 500) {
            this.salarioMensual = salarioMensual;
        } else {
            System.out.println("Salario menor a 500$");
        }
    }

    public void setAniosAntiguedad(int aniosAntiguedad) {
        if (aniosAntiguedad >= 0) {
            this.aniosAntiguedad = aniosAntiguedad;
        } else {
            System.out.println("Los años de antigüedad no pueden ser menores a cero");
        }
    }

    public void setEsGerente(boolean esGerente) {
        this.esGerente = esGerente;
    }

    // Verifica si puede recibir bonificación
    public boolean puedeRecibirBonificacion() {
        return salarioMensual < 3000 || aniosAntiguedad >= 5;
    }

    // Genera resultado de bonificación
    public void generarResultado() {
        if (puedeRecibirBonificacion()) {
            System.out.println("Bonificación aprobada");
            System.out.println("Bonificación mensual: " + calcularBonificacion());
        } else {
            System.out.println("Bonificación rechazada\n-----Motivos------");
            if (salarioMensual >= 3000) {
                System.out.println("El salario mensual no puede ser mayor o igual a 3000$");
            }
            if (aniosAntiguedad < 5) {
                System.out.println("Debe tener como mínimo 5 años de antigüedad");
            }
        }
    }

    // Calcula bonificación básica
    public double calcularBonificacion() {
        return salarioMensual * 0.10;
    }

    // Calcula bonificación con extra
    public double calcularBonificacion(double extra) {
        return calcularBonificacion() + extra;
    }

    // Muestra datos del empleado
    @Override
    public String toString() {
        return "Nombre: " + getNombreCompleto() +
                "\nCédula: " + getCedula() +
                "\nSalario mensual: " + getSalarioMensual() +
                "\nAños de antigüedad: " + getAniosAntiguedad() +
                "\nEs gerente: " + isEsGerente();
    }

    // Muestra reglas de bonificación
    public static void mostrarReglasBonificacion() {
        System.out.println("-----Criterios de bonificación-----");
        System.out.println("Tener un salario mensual menor a 3000$ o tener mínimo 5 años de antigüedad");
    }
}

