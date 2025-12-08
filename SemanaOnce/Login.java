import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//La clase debe herdar el JFRAME para poder trabajar con setTitle, y otras herramientas en el metodo constructor
public class Login extends JFrame {
    private JPanel Login_pa;
    private JTextField txtUsuario;
    private JTextField txtPass;
    private JButton ACCESOButton;

    //Metodo contructor, aqui se editara las herramientas del frame
    public Login() {
        setTitle("PANTALLA PRINCIPAL");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); // Para que sea visible la pantalla
        setContentPane(Login_pa); //Para mostrar el contenido del panel
        setLocationRelativeTo(null); // Centra la ventana

        //ACCIONES DEL BOTON
        ACCESOButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Para tomar el valor de la caja de texto
                //double val1= Double.parseDouble(txtUsuario.getText()); //Asignamos a una variable la caja de texto, pero lo convertimos a double
                //double val2= Double.parseDouble(txtPass.getText());
                //double suma;
                //suma = val1 + val2;
                //Sirve para mostrar una pantalla emergente
                //JOptionPane.showMessageDialog(null,suma);

                //Valores quemados
                String usuario = txtUsuario.getText();
                String pass = txtPass.getText();
                String usuario1 = "Concepcion";
                String pass1 = "123456";

                if (usuario.equals(usuario1) && pass.equals(pass1)) {
                    JOptionPane.showMessageDialog(null, "Login exitoso");
                    dispose(); //Permite que se visualize una pantalla a la vez
                    new Dashboard();


                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuario o contraseña invalidos");
                    txtUsuario.setText("");
                    txtPass.setText("");
                }


            }

        });
        //Agregar un diseño mas lindo en cuanto a margenes
        Login_pa.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
    }
}
