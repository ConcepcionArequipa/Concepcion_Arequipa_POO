package EjercicioDos;

public class Telefono extends Dispositivo {
    private String sistemaOperativo;
    private double almacenamiento;

    public Telefono(String marca, String modelo, double precio,String sistemaOperativo, double almacenamiento) throws DatoInvalidoException{
        super(marca,modelo,precio);
        setSistemaOperativo(sistemaOperativo);
        setAlmacenamiento(almacenamiento);
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) throws DatoInvalidoException{
        if (sistemaOperativo == null || sistemaOperativo.trim().isEmpty()) {
            throw new DatoInvalidoException("El sistema operativo no puede estar vacio");
        }
        this.sistemaOperativo = sistemaOperativo;
    }

    public double getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(double almacenamiento) throws DatoInvalidoException{
        if (almacenamiento <= 0) {
            throw new DatoInvalidoException("El almacenamiento no puede ser menor que 0");
        }
        this.almacenamiento = almacenamiento;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Detalles tecnicos sobre el celular");
        System.out.println("Sistema Operativo: " + sistemaOperativo);
        System.out.println("Almacenamiento: " + almacenamiento);
    }
}
