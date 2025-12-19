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
                    String sql = "SELECT saldo, rol FROM usuarios WHERE usuario=? AND password=? AND activo=true";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    ps.setString(1, usuarioIngresado);
                    ps.setString(2, claveIngresada);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        String rol = rs.getString("rol");
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                        dispose(); //oculta la pantalla del login

                        //Abre el panel de administrador
                        if ("administrador".equalsIgnoreCase(rol)) {
                            new AdminForm();
                        }
                        else{
                            double saldo = rs.getDouble("saldo");
                            new BancoForm(usuarioIngresado, saldo);
                        }

                    }
                    else {
                        intentos++;
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                        if (intentos >= 3) {
                            JOptionPane.showMessageDialog(null,"Acceso bloqueado por 3 intentos fallidos");
                            ingresarButton.setEnabled(false);

                        }

                    }
                    rs.close();
                    ps.close();
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
