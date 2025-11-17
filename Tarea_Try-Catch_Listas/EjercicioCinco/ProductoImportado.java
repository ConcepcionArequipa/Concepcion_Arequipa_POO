package EjercicioCinco;

public class ProductoImportado extends Producto {
    public ProductoImportado(String codigo, String nombre, double precioBase) {
        super(codigo, nombre, precioBase);
    }
    @Override
    public double calcularPrecioFinal(){
        return precioBase*1.05;
    }

}
