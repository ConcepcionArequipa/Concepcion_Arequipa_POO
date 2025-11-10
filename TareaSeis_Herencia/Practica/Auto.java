package Practica;

public class Auto extends Vehiculo{
    private double valorAuto;
    private double cilindraje;

    //Metodo constructor

    public Auto(String placa, String marca, int anio, String propietario, double valorAuto, double cilindraje) {
        super(placa, marca, anio, propietario);
        this.valorAuto = valorAuto;
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularValorMatricula(){
        double base = valorAuto * 0.01; // 1% del valor comercial
        double antiguedad = (2025 - getAnio()) * 5; // descuento por años de uso
        double recargo = cilindraje > 2000 ? 50 : 20; // más cilindraje, más pago

        double total = base + recargo - antiguedad;
        //Valor minimo de 20
        if (total < 20) {
            total = 20;
        }
        return total;
    }


}
