package Practica;

public class Camion extends Vehiculo {
    private double valorCamion;
    private double capacidadToneladas;

    public Camion(String placa, String marca, int anio, String propietario, double valorCamion, double capacidadToneladas) {
        super(placa, marca, anio, propietario);
        this.valorCamion=valorCamion;
        this.capacidadToneladas = capacidadToneladas;
    }

    @Override
    public double calcularValorMatricula(){
        // 1. Valor base: 2% del valor comercial
        double valorBase = valorCamion * 0.02;

        // 2. Descuento por antigüedad
        double descuento = (2025 - getAnio()) * 1.5;

        // 3. Recargo por capacidad
        double recargo = (capacidadToneladas > 5) ? 100 : 50;

        // 4. Calcular total
        double total = valorBase - descuento + recargo;

        // 5. Aplicar valor mínimo
        if (total < 50) {
            total = 50;
        }

        return total;
    }


}
