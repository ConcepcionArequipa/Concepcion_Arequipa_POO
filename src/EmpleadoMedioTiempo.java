public class EmpleadoMedioTiempo extends Empleado{
    private int horasTrabajadas;

    //Metodo constructor

    public EmpleadoMedioTiempo(int codigo, String nombre, String apellido,String cargo, double sueldoBase, int horasTrabajadas) throws DatoInvalidoException{
        super(codigo, nombre, apellido, cargo, sueldoBase);
        setHorasTrabajadas(horasTrabajadas);
    }

    @Override
    public double calcularSalario(){
        return getSueldoBase() * horasTrabajadas;
    }

    @Override
    public void mostrarInfo(){
        System.out.println("------ Informacion del empleado de medio tiempo ------");
        super.toString();
        System.out.println("Sueldo: "+calcularSalario());
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) throws DatoInvalidoException{
        if(horasTrabajadas < 0){
            throw new DatoInvalidoException("Horas invalidas, no puede ser negativo");

        }
        this.horasTrabajadas = horasTrabajadas;
    }
}
