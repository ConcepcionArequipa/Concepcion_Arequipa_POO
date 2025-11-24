package SegundoEjercicio;

public class Laptop extends Dispositivo{
    private int ram;
    private String procesador;
    private int tamanio;
    public Laptop(String marca, String modelo, double precio, int ram, String procesador, int tamanio) throws DatoInvalidoException{
        super(marca, modelo, precio);
        setRam(ram);
        setProcesador(procesador);
        setTamanio(tamanio);
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) throws DatoInvalidoException{
        if(ram<=0){
            throw new DatoInvalidoException("El tamaño de la RAM no puede ser menor que cero");
        }
        this.ram = ram;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) throws DatoInvalidoException{
        if (procesador == null || procesador.trim().isEmpty()) {
            throw new DatoInvalidoException("El procesador no puede estar vacio");
        }
        this.procesador = procesador;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) throws DatoInvalidoException{

        if (tamanio <= 0) {
            throw new DatoInvalidoException("El tamaño no puede ser menor que 0");
        }
        this.tamanio = tamanio;
    }

    @Override
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("Detalles tecnicos sobre la laptop" );
        System.out.println("Ram: " + getRam() + " GB ");
        System.out.println("Procesador: " + getProcesador());
        System.out.println("Tamaño: " + getTamanio()+ " pulgadas ");
    }
}
