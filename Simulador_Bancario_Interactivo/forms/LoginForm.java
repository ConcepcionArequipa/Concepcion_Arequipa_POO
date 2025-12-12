package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {
    private JPanel loginPanel;
    private JTextField txtUsuario;
    private JButton ingresarButton;
    private JPasswordField txtPassword;

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
                String claveIngresada = txtPassword.getText();
                //Credenciales predefinidas
                String usuario= "cliente123";
                String clave="clave456";

                //Validacion si los campos estan vacios

                if (!usuarioIngresado.isEmpty() && !claveIngresada.isEmpty()){
                    //Validacion de las credenciales
                    if (usuarioIngresado.equals(usuario) && claveIngresada.equals(clave)) {
                        JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso!");
                        dispose(); //oculta la pantalla del login
                        new BancoForm(usuarioIngresado);
                    }
                    else if(!usuarioIngresado.equals(usuario) && claveIngresada.equals(clave)) {
                        JOptionPane.showMessageDialog(null, "Usuario incorrecto");
                        txtUsuario.setText("");

                    }
                    else if(usuarioIngresado.equals(usuario) && !claveIngresada.equals(clave)) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                        txtPassword.setText("");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Usuario y contraseña incorrecta ");
                        txtUsuario.setText("");
                        txtPassword.setText("");
                    }
                }

                else {
                    JOptionPane.showMessageDialog(null,"Los campos deben estar completos");
                }



            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
    }
}
