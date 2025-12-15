package conexion;
import java.sql.*;
public class ConexionBD {
    private static final String url="jdbc:mysql://localhost:3306/banco_bd";
    private static final String user="root";
    private static final String password="1234";
    public static Connection getConexion(){
        Connection conexion=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
        }
        catch(ClassNotFoundException e){
            System.out.println("Error: Driver no encontrado");
        }

        catch(SQLException e){
            System.out.println("Error de conexión: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args){

    }

}
