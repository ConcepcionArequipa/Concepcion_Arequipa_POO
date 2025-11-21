package EjercicioDos;

public class Dispositivo {
    //Atributos privados
    private String marca;
    private String modelo;
    private double precio;

    public Dispositivo(String marca, String modelo, double precio)  throws DatoInvalidoException{
        setMarca(marca);
        setModelo(modelo);
        setPrecio(precio);
    }

    //Implementacion de getters y setters

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setMarca(String marca) throws DatoInvalidoException{
        if (marca == null || marca.trim().isEmpty()){
            throw new DatoInvalidoException("La marca no puede estar vacia");
        }
        else {
            this.marca = marca;
        }

    }

    public void setModelo(String modelo) throws DatoInvalidoException{
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new DatoInvalidoException("El modelo no puede estar vacio");
        }
        this.modelo = modelo;
    }

    public void setPrecio(double precio) throws DatoInvalidoException{
        if (precio <= 0) {
            throw new DatoInvalidoException("El precio no puede ser menor que 0");
        }
        this.precio = precio;
    }

    //Metodo que sera heredado por las clases hijas, polimorfismo

    public void mostrarInfo(){
        System.out.println("-------Informacion del dispositivo -------");
        System.out.println("Marca del dispositivo: " + getMarca());
        System.out.println("Modelo del dispositivo: " + getModelo());
        System.out.println("Precio del dispositivo: $" + getPrecio());
    }
}
