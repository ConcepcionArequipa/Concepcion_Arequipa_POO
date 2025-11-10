package Practica;

public abstract class Vehiculo {
    //Atributos privados
    private String placa;
    private String marca;
    private int anio;
    private String propietario;

    //Metodo constructor

    public Vehiculo(String placa, String marca, int anio, String propietario) {
        this.placa = placa;
        this.marca = marca;
        this.anio = anio;
        this.propietario = propietario;
    }

    //Aplicar getters

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnio() {
        return anio;
    }

    public String getPropietario() {
        return propietario;
    }

    //Aplicar setters
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public abstract  double calcularValorMatricula();







}
