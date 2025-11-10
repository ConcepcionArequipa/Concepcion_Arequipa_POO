package Practica;

public class Moto extends Vehiculo{

    private double valorMoto;


    //Constructor

    public Moto(String placa, String marca, int anio, String propietario,double valorMoto) {
        super(placa, marca, anio, propietario);
        this.valorMoto = valorMoto;

    }

    @Override
    public double calcularValorMatricula(){
        // 1. Valor base: 1.5% del valor comercial
        double valorBase = valorMoto * 0.015;

        // 2. Descuento por antigüedad (2 por año)
        int aniosUso = 2025 - getAnio();
        double descuento = aniosUso * 2;

        // 3. Calcular total
        double total = valorBase - descuento;

        // 4. Aplicar valor mínimo
        if (total < 50) {
            total = 50;
        }

        return total;

    }
}


