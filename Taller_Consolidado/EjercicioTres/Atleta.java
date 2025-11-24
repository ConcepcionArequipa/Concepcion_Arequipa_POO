package EjercicioTres;

public class Atleta extends Participante{

    private int numeroDorsal;
    private String categoria; // Opcional, por ejemplo: "100m planos"
    public Atleta(String nombre, int edad, String deporte, String pais,int numeroDorsal, String categoria) {
        super(nombre, edad, deporte, pais);
        if (numeroDorsal <= 0) {
            throw new DatosInvalidosException("El numero de dorsal debe ser mayor que cero.");
        }
        this.numeroDorsal = numeroDorsal;

        if (categoria == null || categoria.trim().isEmpty()) {
            throw new DatosInvalidosException("La categoría no puede estar vacía.");
        }

        this.categoria = categoria;
    }

    @Override
    public void mostrarTipo(){
        System.out.println("Tipo de participante: Atleta individual");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nNumero de dorsal: " + numeroDorsal+
                "\nCategoría: " + categoria;
    }

    public int getNumeroDorsal() {
        return numeroDorsal;
    }

    public String getCategoria() {
        return categoria;
    }
}
