package ec.gob.beca.modelo;

public class SolicitanteBeca {
    // ===== Atributos =====
    private String nombreCompleto;
    private String cedula;
    private double promedio;
    private double ingresosFamiliares;
    private boolean tieneRecomendacion;

    // ===== Constructor =====
    public SolicitanteBeca(String nombreCompleto, String cedula, double promedio,double ingresosFamiliares, boolean tieneRecomendacion) {
        this.setNombreCompleto(nombreCompleto);
        this.setCedula(cedula);
        this.setPromedio(promedio);
        this.setIngresosFamiliares(ingresosFamiliares);
        this.setTieneRecomendacion(tieneRecomendacion);
    }

    // ===== Getters y Setters =====
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        if (cedula != null && cedula.length() == 10) {
            this.cedula = cedula;
        } else {
            System.out.println("Error: la cédula debe tener 10 dígitos.");
            this.cedula = "0000000000";
        }
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        if (promedio >= 0.0 && promedio <= 10.0) {
            this.promedio = promedio;
        } else {
            System.out.println("Error: el promedio debe estar entre 0 y 10.");
            this.promedio = 0.0;
        }
    }

    public double getIngresosFamiliares() {
        return ingresosFamiliares;
    }

    public void setIngresosFamiliares(double ingresosFamiliares) {
        if (ingresosFamiliares >= 0) {
            this.ingresosFamiliares = ingresosFamiliares;
        } else {
            System.out.println("Error: los ingresos no pueden ser negativos.");
            this.ingresosFamiliares = 0;
        }
    }

    public boolean isTieneRecomendacion() {
        return tieneRecomendacion;
    }

    public void setTieneRecomendacion(boolean tieneRecomendacion) {
        this.tieneRecomendacion = tieneRecomendacion;
    }

    // ===== Métodos =====

    // Retorna true si cumple requisitos
    public boolean becaAprobada() {
        return promedio >= 8.5 && ingresosFamiliares < 1000 && tieneRecomendacion;
    }

    // Imprime el resultado de la beca con motivos
    public void generarResultado() {
        if (becaAprobada()) {
            System.out.println("Resultado: Beca aprobada.");
        } else {
            System.out.println("Resultado: Beca rechazada.");
            if (promedio < 8.5)
                System.out.println("Motivo: Promedio insuficiente.");
            if (ingresosFamiliares >= 1000)
                System.out.println("Motivo: Ingresos familiares altos.");
            if (!tieneRecomendacion)
                System.out.println("Motivo: Falta recomendación.");
        }
    }

    // Muestra todos los datos del solicitante
    @Override
    public String toString() {
        return "Datos del solicitante:\n" +
                "Nombre: " + nombreCompleto + "\n" +
                "Cédula: " + cedula + "\n" +
                "Promedio: " + promedio + "\n" +
                "Ingresos familiares: " + ingresosFamiliares + "\n" +
                "Tiene recomendación: " + tieneRecomendacion;
    }

    // Método estático que imprime las reglas de la beca
    public static void mostrarReglasBeca() {
        System.out.println("=== Reglas de la Beca ===");
        System.out.println("- Promedio mínimo: 8.5");
        System.out.println("- Ingresos familiares menores a 1000");
        System.out.println("- Debe tener recomendación institucional");
    }

    // ===== Sobrecarga de métodos =====
    public int calcularHorasEstudio() {
        return 20; // horas base recomendadas
    }

    public int calcularHorasEstudio(int extra) {
        return 20 + extra; // horas base + extra
    }
}

