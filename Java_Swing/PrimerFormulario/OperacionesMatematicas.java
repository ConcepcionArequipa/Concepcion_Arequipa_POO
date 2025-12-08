package PrimerFormulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OperacionesMatematicas {
    private JTextField txtValor1;
    private JTextField txtValor2;
    private JTextField txtResultado;
    private JButton sumarBtn;
    private JButton restarBtn;
    private JButton multiplicarBtn;
    private JButton dividirBtn;
    private JPanel mainPanel;

    //Metodo constructor
    public OperacionesMatematicas() {
        txtResultado.setEditable(false);
        sumarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //Validar que los dos valores esten llenos
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos");
                        return;
                    }
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    double resultado = valor1 + valor2;
                    txtResultado.setText(String.format("%.2f",resultado));  //Se muestra solo dos decimales
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa solo números");
                }
            }
        });
        restarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos");
                        return;
                    }
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    double resultado = valor1 - valor2;
                    txtResultado.setText(String.format("%.2f",resultado));  //Se muestra solo dos decimales
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa solo números");
                }

            }
        });
        multiplicarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos");
                        return;
                    }
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    double resultado = valor1 * valor2;
                    txtResultado.setText(String.format("%.2f",resultado));  //Se muestra solo dos decimales
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa solo números");
                }
            }
        });
        dividirBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtValor1.getText().isEmpty() || txtValor2.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe llenar los dos campos");
                        return;
                    }
                    double valor1 = Double.parseDouble(txtValor1.getText());
                    double valor2 = Double.parseDouble(txtValor2.getText());
                    if (valor2 == 0) {
                        JOptionPane.showMessageDialog(null, "No se puede dividir entre 0");
                        return;
                    }
                    double resultado = valor1 / valor2;
                    txtResultado.setText(String.format("%.2f",resultado));  //Se muestra solo dos decimales
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingresa solo números");
                }
            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 15, 20));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("OperacionesMatematicas");
        frame.setContentPane(new OperacionesMatematicas().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centra la ventana
        frame.setVisible(true);
    }
}
