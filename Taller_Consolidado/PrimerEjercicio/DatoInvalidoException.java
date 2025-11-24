package PrimerEjercicio;

//Implementar una excepción personalizada para validar datos incorrectos

public class DatoInvalidoException extends Exception {
    public DatoInvalidoException(String mensaje){
        super(mensaje);
    }

}
