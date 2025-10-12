
//Creacion de la clase CuentaBancaria
public class CuentaBancaria {
    //Atributos
    private String nombreTitular;
    private double saldo;

    //Metodo constructor con parametros

    public CuentaBancaria(String nombreTitular, double saldo) {
        //Inicializar los atributos de los objetos
        this.nombreTitular = nombreTitular;
        this.saldo = saldo;
    }

    //Metodo propio publico para mostrar la informacion
    public void mostrarInformacion(){
        System.out.println("Nombre del titular: "+nombreTitular);
        System.out.println("Saldo actual: $"+saldo);
    }

    //Metodo propio publico para depositar dinero

    public void depositar(double monto){
        if(monto<=0){
            System.out.println("Deposito invalido");
        }
        else{
            saldo+=monto;
            System.out.println("Ha depositado: $"+monto+" , su saldo actual es: $"+saldo);
        }

    }

    //Metodo propio publico para retirar dinero
    public void retirar(double monto){

        if(saldo<monto){
            System.out.println("Saldo insuficiente");
        }
        else{
            saldo-=monto;
            System.out.println("Ha retirado: $"+monto+" , su saldo actual es: $"+saldo);
        }
    }

    public static void main(String[] args) {
        //Creacion del primer objeto
        CuentaBancaria cuentaUno=new CuentaBancaria("Concepcion Arequipa", 500);
        //Invocar los metodos
        cuentaUno.mostrarInformacion();
        cuentaUno.depositar(100);
        cuentaUno.retirar(500);

    }

}
