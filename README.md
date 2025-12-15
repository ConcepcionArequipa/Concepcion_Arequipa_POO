Tarea Java Swing - Simulador del Sistema Bancario con Base de Datos
-
Codigo correspondiente:
-

1. ConexionBD


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

2. LoginForm

   package forms;

   import conexion.ConexionBD;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;

public class LoginForm extends JFrame {

private JPanel loginPanel;

private JTextField txtUsuario;

private JButton ingresarButton;

private JPasswordField txtPassword;

private int intentos= 0;

    //Metodo constructor, edicion de las herramientas del frame
    public LoginForm() {
        setTitle("Inicio de Sesion"); //Titulo para la pantalla
        setSize(500,500); //Tamaño
        setContentPane(loginPanel); //Muestra el contenido del loginPanel
        setLocationRelativeTo(null);//Centra la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); //Visibilidad de la pantalla

        //Accion del boton de ingresar
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioIngresado = txtUsuario.getText();
                String claveIngresada = new String(txtPassword.getPassword());

                //Validacion si los campos estan vacios

                if(usuarioIngresado.isEmpty() || claveIngresada.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Los campos deben estar completos");
                    return;
                }
                try {
                    Connection conexion = ConexionBD.getConexion();
                    String sql = "SELECT * FROM usuarios WHERE usuario=? AND password=? AND activo=true";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    ps.setString(1, usuarioIngresado);
                    ps.setString(2, claveIngresada);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        double saldo = rs.getDouble("saldo");
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                        dispose(); //oculta la pantalla del login
                        new BancoForm(usuarioIngresado, saldo);

                    }
                    else {
                        intentos++;
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                        if (intentos >= 3) {
                            JOptionPane.showMessageDialog(null,"Acceso bloqueado por 3 intentos fallidos");
                            ingresarButton.setEnabled(false);

                        }

                    }
                    conexion.close();
                }
                catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }


            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
    }
}

3. BancoForm

package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conexion.ConexionBD;
import java.sql.*;

public class BancoForm extends JFrame {

private JButton depositarButton;

private JButton retirarButton;

private JButton transferenciaButton;

private JButton salirButton;

private JLabel lblNombre;

private JLabel lblSaldo;

private JPanel panelBancario;

private JScrollPane jspHistorial; //Panel para scrollear el historial

private JTextArea txtHistorial;

    private double saldo;
    private String nombreUsuario;
    private String historial="";




    public BancoForm(String nombreUsuario, double saldo) {
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        setTitle("Operaciones Bancarias");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelBancario);
        setVisible(true);
        //Nombre de usuario

        lblNombre.setText(nombreUsuario);

        lblSaldo.setText("$"+ saldo);

        //Acciones del boton de depositar

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Usar un Jpanel para solicitar el valor a depositar

                String input = JOptionPane.showInputDialog(
                        BancoForm.this,
                        "Ingresa el valor a depositar: ",
                        "Depósito",
                        JOptionPane.PLAIN_MESSAGE
                );
                //Validacion
                if(input!=null && !input.isEmpty()){
                    //Atrapamos las excepciones con try-catch
                    try {
                        double valorDepositado = Double.parseDouble(input);
                        if(valorDepositado > 0){
                            BancoForm.this.saldo += valorDepositado;
                            lblSaldo.setText("$"+ BancoForm.this.saldo);
                            JOptionPane.showMessageDialog(null, "Deposito realizado exitosamente!");
                            actualizarSaldoBD();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Monto inválido");
                        }
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Ingrese un número válido!");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(BancoForm.this, "Debe llenar todos los campos");
                }

            }
        });

        //Acciones del boton de retirar dinero

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane
                String input = JOptionPane.showInputDialog(
                        BancoForm.this,
                        "Ingresa el valor a retirar: ",
                        "Retirar", //Titulo
                        JOptionPane.PLAIN_MESSAGE
                );
                if(input!=null && !input.isEmpty()){
                    try {
                        double valorRetiro = Double.parseDouble(input);
                        if(valorRetiro <= 0){
                            JOptionPane.showMessageDialog(null,"El monto debe ser mayor a 0");
                            return;
                        }
                        //Validar que el saldo a retirar sea suficiente
                        if(valorRetiro > saldo){
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente\nTu saldo actual es: $" + saldo);


                        }
                        else {
                            BancoForm.this.saldo -= valorRetiro;
                            lblSaldo.setText("$"+ BancoForm.this.saldo);
                            JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente!");
                            actualizarSaldoBD();


                        }

                    }
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(BancoForm.this, "Debe llenar todos los campos");
                }

            }
        });

        // Accion para el boton de transferencia
        transferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear un pequeño formulario
                JTextField txtDestinatario = new JTextField();
                JTextField txtMonto = new JTextField();

                Object[] mensaje = {
                        "Ingrese el nombre del destinatario: ",txtDestinatario,
                        "Ingrese el valor del monto: ",txtMonto
                };
                //JOptionPane
                int transferencia= JOptionPane.showConfirmDialog(
                        BancoForm.this,
                        mensaje,
                        "Transferencia", //Titulo
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

                //Si se apresiona el boton de ok
                if(transferencia==JOptionPane.OK_OPTION){
                    String destinatario = txtDestinatario.getText();
                    String monto = txtMonto.getText();

                    //Validacion si los campos estan vacios

                    if(destinatario.isEmpty() || monto.isEmpty()){
                        JOptionPane.showMessageDialog(BancoForm.this, "Debe llenar todos los campos");
                        return;
                    }

                    try {

                        //Transformar el monto a double
                        double montoTranferir= Double.parseDouble(monto);

                        //Validar si es negativo el monto o si es cero

                        if (montoTranferir <= 0 ){
                            JOptionPane.showMessageDialog(BancoForm.this, "El monto debe ser mayor a 0");
                            return;
                        }

                        //Verificar que el monto no supere el saldo

                        if (montoTranferir > saldo){
                            JOptionPane.showMessageDialog(BancoForm.this, "Saldo insuficiente\nTu saldo actual es: $" + saldo);
                            return;
                        }
                        else {


                            try (Connection conexion = ConexionBD.getConexion()) {
                                String sqlCheck = "SELECT saldo FROM usuarios WHERE usuario = ?";
                                try (PreparedStatement psCheck = conexion.prepareStatement(sqlCheck)) {
                                    psCheck.setString(1, destinatario);
                                    try (ResultSet rs = psCheck.executeQuery()) {
                                        if (!rs.next()) {
                                            JOptionPane.showMessageDialog(BancoForm.this, "El destinatario no existe");
                                            return;
                                        }

                                        conexion.setAutoCommit(false);
                                        // actualizar remitente y destinatario

                                        // Restar saldo al remitente ya hecho
                                        String sqlRemitente = "UPDATE usuarios SET saldo=? WHERE usuario=?";
                                        PreparedStatement psRemitente = conexion.prepareStatement(sqlRemitente);
                                        psRemitente.setDouble(1, BancoForm.this.saldo);
                                        psRemitente.setString(2, nombreUsuario);
                                        psRemitente.executeUpdate();

                                        // Sumar saldo al destinatario
                                        String sqlDestinatario = "UPDATE usuarios SET saldo = saldo + ? WHERE usuario=?";
                                        PreparedStatement psDestinatario = conexion.prepareStatement(sqlDestinatario);
                                        psDestinatario.setDouble(1, montoTranferir);
                                        psDestinatario.setString(2, destinatario);
                                        psDestinatario.executeUpdate();

                                        conexion.commit();
                                        BancoForm.this.saldo -= montoTranferir;
                                        lblSaldo.setText("$"+ BancoForm.this.saldo);
                                        JOptionPane.showMessageDialog(BancoForm.this,
                                                "Transferencia exitosa a " + destinatario + " por $" + montoTranferir);

                                        agregarTransferencias("Nombre del destinatario: "+ destinatario +
                                                "\nMonto transferido: $" + montoTranferir +
                                                "\nSaldo actual: $" + BancoForm.this.saldo + "\n");
                                    }
                                } catch (SQLException ex) {
                                    conexion.rollback();
                                    JOptionPane.showMessageDialog(BancoForm.this, "Error en la transferencia");
                                } finally {
                                    conexion.setAutoCommit(true);
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(BancoForm.this, "Error al conectarse a la base de datos");
                            }
                        }

                    }
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    }
                }



            }
        });

        //Accion para el boton de salir

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //JoptionPane para salir con un mensaje de confirmacion
                int salir = JOptionPane.showConfirmDialog(
                        null,
                        "¿ Seguro que deseas salir?",
                        "Confirmacion de Salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE //Da un icono de alerta
                );
                //Si apresiona el usuario si, sale del sistema
                if (salir == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }


            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        panelBancario.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
    }

    //Metodo para el historial de transacciones
    private void agregarTransferencias(String mensaje){

        historial += mensaje + "\n"; //Agregamos las transferencias
        txtHistorial.setText(historial); //Modificamos el txtHistorial
    }

    //Metodo para actualizar el saldo
    private void actualizarSaldoBD() {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "UPDATE usuarios SET saldo=? WHERE usuario=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, saldo);
            ps.setString(2, nombreUsuario);
            ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar saldo en la BD");
        }
    }
}

4. Main

import forms.LoginForm;

public class Main {

public static void main(String[] args) {

new LoginForm();

}

}

5. Base de datos

create database banco_bd;

use banco_bd;

CREATE TABLE usuarios (

id INT AUTO_INCREMENT PRIMARY KEY,

usuario VARCHAR(50) NOT NULL unique,

password VARCHAR(50) NOT NULL,

activo BOOLEAN NOT NULL DEFAULT TRUE,

saldo DOUBLE NOT NULL DEFAULT 1000
);

INSERT INTO usuarios (usuario, password, activo, saldo)

VALUES ('cliente123', 'clave456', true, 1000);

INSERT INTO usuarios (usuario, password, activo, saldo)

VALUES ('conce123', '1234', true, 1000);

Funcionamiento del proyecto
-
1.	Conexión a la Base de Datos (Clase ConexionBD)

El sistema utiliza una clase centralizada llamada ConexionBD para manejar todas las conexiones a la base de datos MySQL. Esta clase es fundamental porque:

-	Centraliza los parámetros de conexión: Contiene la URL de la base de datos, el usuario y la contraseña. Esto evita repetir la información en múltiples clases y facilita cambios futuros (por ejemplo, si cambian la contraseña o el host).

-	Proporciona un método estático para obtener la conexión: Todas las clases del sistema (Login, BancoForm, operaciones) pueden llamar a ConexionBD.getConexion() para conectarse a la base de datos de manera sencilla.
     El método devuelve un objeto Connection que se utiliza para ejecutar consultas (SELECT) y actualizaciones (INSERT, UPDATE) de manera segura.

-	Manejo de errores: Captura excepciones si el driver de MySQL no se encuentra o si hay problemas de conexión. Esto evita que el sistema falle de manera abrupta y permite mostrar mensajes de error amigables.

-	Compatibilidad con transacciones: La clase permite iniciar transacciones (setAutoCommit(false)), muy útil en operaciones críticas como transferencias entre usuarios. Esto asegura que tanto la disminución de saldo del remitente como el aumento de saldo del destinatario se realicen de manera automatica, evitando inconsistencias en la base de datos.


2.	Sistema Bancario Virtual con Java Swing y MySQL

El Sistema Bancario Virtual inicia con una pantalla de Inicio de Sesión, donde el usuario debe ingresar sus credenciales predefinidas almacenadas en la base de datos MySQL:
Usuario: cliente123
Contraseña: clave456
En este formulario se implementan validaciones utilizando el método .equals() para comparar correctamente los textos de usuario y contraseña, además de controlar que los campos no estén vacíos usando estructuras if–else. Si el usuario ingresa datos incorrectos, el sistema muestra mensajes de error mediante JOptionPane.showMessageDialog(). El sistema también lleva un conteo de intentos fallidos y bloquea el acceso después de 3 intentos incorrectos.
Si se ingresan las credenciales válidas, aparece un mensaje de inicio de sesión exitoso, la ventana de login se cierra automáticamente y se abre la ventana principal del sistema.

3.	Ventana Principal del Sistema

Una vez dentro del sistema, se muestra el nombre del usuario que inició sesión y su saldo actual, recuperado directamente desde la base de datos. Inicialmente, todos los usuarios se crean con un saldo de $1000, almacenado en la columna saldo de la tabla usuarios.
En esta pantalla se implementaron botones para las operaciones bancarias:
•	Depositar
•	Retirar
•	Transferencia
•	Salir
Cada botón utiliza un ActionListener que permite detectar el clic del usuario y ejecutar la operación correspondiente.

4.	Operaciones Bancarias Implementadas

-	Depositar: El sistema solicita al usuario ingresar el monto a depositar mediante un JOptionPane. Se validan los siguientes casos:
     o	Campo vacío
     o	Monto no numérico
     o	Monto negativo
     Si el valor es válido, este se suma al saldo del usuario y se actualiza tanto la interfaz como la base de datos mediante una sentencia UPDATE en MySQL.

-	Retirar: La operación de retiro funciona de forma similar al depósito, pero con condiciones adicionales:
     o	El monto no puede ser mayor al saldo disponible
     o	No se permiten valores negativos ni vacíos
     Si el retiro es válido, el saldo se actualiza correctamente en la interfaz y en la base de datos.

-	Transferencia:
     Para realizar una transferencia, el sistema solicita:
     o	Nombre del destinatario
     o	Monto a transferir
     Se implementan validaciones para asegurar:
     o	Campos no vacíos
     o	Monto numérico
     o	Monto mayor a cero
     o	Monto no mayor al saldo disponible
     Si todo es correcto, el sistema realiza la transferencia entre usuarios reales en la base de datos mediante una transacción MySQL:
     o	Se descuenta el monto del remitente
     o	Se suma el monto al destinatario

Esto garantiza que ambas operaciones se ejecuten de manera automatica, evitando inconsistencias en los saldos. Cada transferencia exitosa se muestra en un historial de transacciones dentro de la interfaz.

-	Salida del Sistema:
     El botón Salir cierra la ventana principal y finaliza el programa. Se implementa una confirmación mediante JOptionPane para evitar cierres accidentales.

5.	Base de Datos MySQL

La base de datos utilizada se llama banco_bd y contiene la tabla usuarios.

Ejemplo de usuarios registrados:

INSERT INTO usuarios (usuario, password, activo)

VALUES ('cliente123', 'clave456', true),

('conce123', '1234', true);

•	La columna saldo almacena el saldo actual de cada usuario.


•	La columna activo indica si un usuario está habilitado para iniciar sesión.

•	Todas las operaciones (depósito, retiro, transferencia) actualizan esta tabla en tiempo real para reflejar el saldo correcto de cada usuario.











