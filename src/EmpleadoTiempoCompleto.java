public class EmpleadoTiempoCompleto extends Empleado {
    private double bonoAdicional;

    //Metodo constructor

    public EmpleadoTiempoCompleto(int codigo, String nombre, String apellido,String cargo, double sueldoBase, double bonoAdicional) throws DatoInvalidoException{
        super(codigo, nombre, apellido,cargo,sueldoBase);
        setBonoAdicional(bonoAdicional);
    }


    @Override
    public double calcularSalario(){
        return getSueldoBase() + bonoAdicional;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("------ Informacion del empleado a tiempo completo ------");
        super.toString();

        System.out.println("Sueldo: "+calcularSalario());
    }

    public double getBonoAdicional() {
        return bonoAdicional;
    }

    public void setBonoAdicional(double bonoAdicional) throws DatoInvalidoException {
        if (bonoAdicional <= 0) {
            throw new DatoInvalidoException("Bono invalido, no puede ser menor que 0");
        }
        this.bonoAdicional = bonoAdicional;
    }


}
