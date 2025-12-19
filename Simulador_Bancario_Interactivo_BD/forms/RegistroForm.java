package forms;
import conexion.ConexionBD;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class RegistroForm extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton registrarseButton;
    private JPanel registroPanel;

    public RegistroForm() {

        setTitle("Registro de usuarios nuevos"); //Titulo para la pantalla
        setSize(500,500); //Tamaño
        setContentPane(registroPanel); //Muestra el contenido del loginPanel
        setLocationRelativeTo(null);//Centra la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //Libera solo esta ventana
        setVisible(true); //Visibilidad de la pantalla

        registrarseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String clave = new String(txtPassword.getPassword());

                //Validar campos vacios

                if (usuario.isEmpty() || clave.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Los campos deben estar completos");
                    return;
                }

                try {
                    Connection conexion = ConexionBD.getConexion();
                    String verificar = "SELECT 1 FROM usuarios WHERE usuario = ?";
                    PreparedStatement psVerificar = conexion.prepareStatement(verificar);
                    psVerificar.setString(1, usuario);
                    ResultSet rs = psVerificar.executeQuery();

                    if (rs.next()) {
                        JOptionPane.showMessageDialog(null, "El usuario ya existe");
                        conexion.close();
                        return;
                    }
                    String sql = "INSERT INTO usuarios (usuario, password, activo, saldo) VALUES (?, ?, true, 1000)";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    ps.setString(1, usuario);
                    ps.setString(2, clave);
                    ps.executeUpdate();
                    conexion.close();
                    JOptionPane.showMessageDialog(null, "Usuario registrado exitosamente");
                    dispose(); //Cerrar la ventana de registro
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }

            }

        });
        //Agregar un diseño mas lindo en cuanto a margenes
        registroPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
    }
}
