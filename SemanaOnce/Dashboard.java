import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    private JPanel formularioPanel;
    private JTextField txtValor1;
    private JTextField txtValor2;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JLabel resultadoLb;

    public Dashboard() {
        setTitle("PANTALLA PRINCIPAL");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true); // Para que sea visible la pantalla
        setContentPane(formularioPanel); //Para mostrar el contenido del panel
        setLocationRelativeTo(null); // Centra la ventana
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos ");
                        return;
                    }
                    //Crear dos variables para los valores
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    //Crear la variable para el resultado

                    double resultado = valor1 + valor2;
                    //Se captura el resultado en el label
                    resultadoLb.setText(String.valueOf(resultado));

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros ");
                }
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos ");
                        return;
                    }
                    //Crear dos variables para los valores
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    //Crear la variable para el resultado

                    double resultado = valor1 - valor2;
                    //Se captura el resultado en el label
                    resultadoLb.setText(String.valueOf(resultado));

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros ");
                }
            }
        });


        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos ");
                        return;
                    }
                    //Crear dos variables para los valores
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    //Crear la variable para el resultado

                    double resultado = valor1 * valor2;
                    //Se captura el resultado en el label
                    resultadoLb.setText(String.valueOf(resultado));

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros ");
                }
            }
        });


        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos ");
                        return;
                    }
                    //Crear dos variables para los valores
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());

                    //Validar que el divisor no puede ser cero

                    if (valor2==0) {
                        JOptionPane.showMessageDialog(null, "Error: No se puede divvidir entre 0");
                        return;
                    }

                    //Crear la variable para el resultado

                    double resultado = valor1 / valor2;
                    //Se captura el resultado en el label
                    resultadoLb.setText(String.valueOf(resultado));

                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Solo puede ingresar numeros ");
                }
            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        formularioPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
    }

}
