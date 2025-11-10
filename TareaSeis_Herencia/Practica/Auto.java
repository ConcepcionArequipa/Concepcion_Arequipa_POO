package Practica;

public class Auto extends Vehiculo{

    //Metodo constructor

    public Auto(String placa, String marca, int anio, String propietario) {
        super(placa, marca, anio, propietario);
    }

    @Override
    public double calcularValorMatricula(double valorVehiculo,double cilindraje){
        double base = valorVehiculo * 0.01; // 1% del valor comercial
        double antiguedad = (2025 - getAnio()) * 5; // descuento por años de uso
        double recargo = cilindraje > 2000 ? 50 : 20; // más cilindraje, más pago

        double total = base + recargo - antiguedad;
        if (total < 20) total = 20; // valor mínimo
        return total;
    }



}
