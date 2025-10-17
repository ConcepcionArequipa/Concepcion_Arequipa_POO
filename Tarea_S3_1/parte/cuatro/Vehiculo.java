package parte.cuatro;

public class Vehiculo {
    public String marca;
    private String modelo;
    private double velocidadMaxima;
    private int codigoSeguridad;
    private String color;

    //Metodo constructor

    public Vehiculo() {
        velocidadMaxima = 5000;
    }

    public void setModelo(String modelo) {
        if (modelo.length() != 0) {
            this.modelo = modelo;
        }
        else {
            System.out.println("Modelo invalido, no debe estar vacio");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        if (codigoSeguridad <= 0) {
            System.out.println("Codigo de seguridad invalido");
        }
        else {
            this.codigoSeguridad = codigoSeguridad;
        }
    }

    public void setColor(String color) {
        if (color.equals("rojo") || color.equals("azul") || color.equals("blanco")) {
            this.color = color;
        }
        else {
            System.out.println("Color invalido");
        }
    }

    public String getColor() {
        return color;
    }
}
