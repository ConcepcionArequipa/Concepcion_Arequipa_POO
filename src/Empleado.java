public abstract class Empleado {
    private  int codigo;
    private String nombre;
    private String apellido;
    private String cargo;
    private double sueldoBase;

    //Metodo constructor

    public Empleado(int codigo, String nombre, String apellido,String cargo, double sueldoBase) throws DatoInvalidoException{
        setCodigo(codigo);
        setNombre(nombre);
        setApellido(apellido);
        setSueldoBase(sueldoBase);
    }

    //Getters y setters


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws DatoInvalidoException {
        if (codigo < 100 || codigo > 200) {
            throw new DatoInvalidoException("Codigo invalido, debe estar entre 100 a 200");
        }
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws DatoInvalidoException {
        if (nombre==null || nombre.trim().isEmpty()) {
            throw new DatoInvalidoException("Nombre invalido, no puede estar vacio");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) throws DatoInvalidoException {
        if (apellido==null || apellido.trim().isEmpty()) {
            throw new DatoInvalidoException("Apellido invalido, no puede estar vacio");
        }
        this.apellido = apellido;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) throws DatoInvalidoException {
        if (sueldoBase<=0) {
            throw new DatoInvalidoException("Sueldo base invalido, debe ser mayor que 0 ");
        }
        this.sueldoBase = sueldoBase;
    }

    public String getCargo() {
        return cargo;
    }


    public void setCargo(String cargo) throws DatoInvalidoException {
        if (cargo == null || cargo.trim().isEmpty()) {
            throw new DatoInvalidoException("Cargo invalido, no puede estar vacio");
        }
        this.cargo = cargo;
    }

    public abstract double calcularSalario();

    @Override
    public String toString() {

        return "Codigo: "+getCodigo()+", Nombre: "+getNombre()+ ", Apellido: "+getApellido()+", Cargo: "+getCargo()+", Sueldo: "+getSueldoBase();
    }

    public abstract void mostrarInfo();
}
