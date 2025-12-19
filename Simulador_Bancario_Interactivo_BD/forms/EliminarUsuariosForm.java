package forms;
import conexion.ConexionBD;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class EliminarUsuariosForm extends JFrame {
    private JPanel eliminarPanel;
    private JTextField txtUsuario;
    private JButton eliminarButton;
    private JButton cancelarButton;

    public EliminarUsuariosForm() {
        setTitle("Eliminar usuarios");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setContentPane(eliminarPanel);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();

                if (usuario.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo no puede estar vacio");
                    return;
                }

                int confirmacion= JOptionPane.showConfirmDialog(
                        EliminarUsuariosForm.this,
                        "¿Seguro que deseas eliminar al usuario?",
                        "Confirmar",
                        JOptionPane.YES_NO_OPTION
                );
                if (confirmacion != JOptionPane.YES_OPTION) return;
                try {
                    Connection conexion = ConexionBD.getConexion();

                    String sql = "UPDATE usuarios SET activo=false WHERE usuario=? AND activo=true";
                    PreparedStatement ps = conexion.prepareStatement(sql);
                    ps.setString(1, usuario);

                    int filas = ps.executeUpdate();

                    if (filas>0) {
                        JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
                        dispose();
                    }

                    else{
                        JOptionPane.showMessageDialog(null, "Usuario no encontrado");
                    }
                    conexion.close();
                }
                catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el usuario");
                }

            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
    }
}
