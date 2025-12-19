package forms;
import conexion.ConexionBD;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AdminForm extends JFrame {
    private JButton registrarUsuariosButton;
    private JButton eliminarUsuariosButton;
    private JButton salirButton;
    private JPanel panelAdmin;


    public AdminForm() {
        setTitle("Panel Administrador");
        setSize(400,300);
        setContentPane(panelAdmin);
        setLocationRelativeTo(null);
        setVisible(true);
        registrarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegistroForm();


            }
        });
        eliminarUsuariosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EliminarUsuariosForm();
            }
        });
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginForm();
            }
        });



    }

}
