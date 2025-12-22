package conexion;

import java.sql.*;
public class ConexionBD {
    private static final String url="jdbc:mysql://ureaxaqehn5mna3l:nw5M3xD87dmVWmKIY0Bx@brpqmkk9qgvixttn6eum-mysql.services.clever-cloud.com:3306/brpqmkk9qgvixttn6eum";
    private static final String user="ureaxaqehn5mna3l";
    private static final String password="nw5M3xD87dmVWmKIY0Bx";
    //Metodo que debe de retornar una Connection si la conexion es correcta
    public static Connection getConexion(){

        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
            return conexion;
        }

        catch(SQLException e){
            throw new RuntimeException("Error de conexión: " + e.getMessage());
        }

    }


}
