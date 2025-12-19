package conexion;
import conexion.ConexionBD;
import java.sql.*;
public class ConexionBD {
    private static final String url="jdbc:mysql://ureaxaqehn5mna3l:nw5M3xD87dmVWmKIY0Bx@brpqmkk9qgvixttn6eum-mysql.services.clever-cloud.com:3306/brpqmkk9qgvixttn6eum";
    private static final String user="ureaxaqehn5mna3l";
    private static final String password="nw5M3xD87dmVWmKIY0Bx";
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


}
