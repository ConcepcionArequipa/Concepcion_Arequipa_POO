
//La clase es persona

//Creacion de la clase
public class Persona {
    //Atributos
    int cedula;
    String nombre;
    int edad;
    String correo;

    //Metodo constructor

    public Persona(int cedula,String nombre, int edad, String correo) {
        this.cedula = cedula;  //this.parametro=atributo, se hace si los parametros y atributos tiene el mismo nombre
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;

    }

    //Imprimir los atributos del objeto
    // Creamos un metodo llamada impresion
    void impresion(){
        System.out.println("Bienvenido "+nombre+" ,su cedula es: "+cedula+" , tiene "+edad+" y su correo es: "+correo);
    }

    // Creacion del objeto
    public static void main(String[] args){
        //Nombre_clase nombre_objeto= new nombre_m.constructor(parametros del metodo constructor, ya en este caso los atributos)

        Persona objeto1 = new Persona(1750134510,"Concepcion",20,"concepcion.arequipa@gmail.com");

        objeto1.impresion(); //Llamamos al metodo impresion

        //Creacion segundo objeto
        Persona objeto2=new Persona(1711595775,"Camila",24,"camila.arauz@gmail.com");

        //Imprimir con el metodo impresion

        objeto2.impresion();
    }



}
