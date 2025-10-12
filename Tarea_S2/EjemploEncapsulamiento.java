//Ejemplo de encapsulamiento

public class EjemploEncapsulamiento {
    // Clase interna Persona
    static class Persona {
        private String nombre; // atributo encapsulado

        // Setter: permite asignar un valor
        public void setNombre(String n) {
            nombre = n;
        }

        // Getter: permite obtener el valor
        public String getNombre() {
            return nombre;
        }
    }

    // Metodo principal
    public static void main(String[] args) {
        Persona p = new Persona();   // crear objeto
        p.setNombre("Carlos");       // asignar valor
        System.out.println(p.getNombre()); // mostrar valor
    }
}


