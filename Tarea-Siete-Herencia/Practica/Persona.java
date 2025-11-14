package Practica;

//Crear una clase abstracta Persona

public abstract class Persona {
    //Atributos privados
    protected String nombre;
    protected String cedula;
    protected String direccion; //Las subclases pueden acceder a ellos directamente
    protected String telefono;

    //Metodo constructor
    public Persona(String nombre, String cedula, String direccion, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Implementacion de getters y setters con validacion

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        if (direccion != null && !direccion.isEmpty()) {
            this.direccion = direccion;
        } else {
            System.out.println("La dirección no puede estar vacía");
        }
    }


    public void setTelefono(String telefono) {
        if (telefono != null && telefono.length()!=0 && telefono.matches("\\d{7,10}")) {
            this.telefono = telefono;
        }
        else {
            System.out.println("Telefono invalido");
        }
    }

    //Metodo abtracto, solo puede estar en clases abstractas

    public abstract void mostrarRol();

    public void actualizarDatos(String direccion, String telefono){
        //Implementamos el try-catch
        //Evita que el programa finalice si ocurre estos errores
        try {
            if (direccion==null || direccion.length()==0) {
                //Da un mensaje si ocurre este error
                throw new IllegalArgumentException("La direccion no puede estar vacia");
            }
            if (telefono==null || telefono.length()== 0 ) {
                throw new IllegalArgumentException("El telefono no puede estar vacio");
            }
            if (!telefono.matches("\\d{7,10}")) {
                throw new IllegalArgumentException("El teléfono debe ser un número de 7 a 10 dígitos");
            }
            setDireccion(direccion);
            setTelefono(telefono);
        }
        catch (Exception e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());

        }

    }



}
