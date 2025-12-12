import java.sql.*;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://localhost:3306/almacen"; //Para mysql
        // "jdbc:mysql://postgressql:5432/almacen";
        String user = "root"; //postgres
        String password = "root";
        Connection connection = DriverManager.getConnection(url,user,password);

        String sql="Select * from usuarios_cliente";

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql); //Para ver los resultados de la base de daTOS

        //Mandar a imprimir

        System.out.println("DATOS DE LA TABLA");
        while (rs.next()) {

            rs.getInt("id");
            rs.getString("nombre");
            rs.getString("correo");
            rs.getString("password");
        }


        //Si la conexion es exitosa
        if(connection != null){
            System.out.println("Conexion exitosa");
            connection.close(); //Se cierra la conexion
        }
        else {
            System.out.println("No se puede conectar con la base de datos");

        }
    }
}