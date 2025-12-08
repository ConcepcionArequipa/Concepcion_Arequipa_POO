package TercerFormulario;

import SegundoFormulario.Encuesta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeleccionMultiple {
    private JCheckBox basesDeDatosCheckBox;
    private JCheckBox redesCheckBox;
    private JCheckBox programacionCheckBox;
    private JCheckBox diseñoDeInterfacesCheckBox;
    private JCheckBox seguridadInformáticaCheckBox;
    private JButton procesarSelecciónButton;
    private JPanel mainPanel;

    //Metodo constructor

    public SeleccionMultiple() {

        procesarSelecciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!basesDeDatosCheckBox.isSelected() && !redesCheckBox.isSelected() && !programacionCheckBox.isSelected() && !diseñoDeInterfacesCheckBox.isSelected() && !seguridadInformáticaCheckBox.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar almenos una opcion");
                    return;
                }

                //Declarar una variable para el resultado

                String resultado="Has selecccionado:\n";
                if (basesDeDatosCheckBox.isSelected()) {
                    resultado+="- Bases de datos\n";
                }

                if (redesCheckBox.isSelected()) {
                    resultado+="- Redes\n";
                }

                if (programacionCheckBox.isSelected()) {
                    resultado+="- Programacion\n";
                }

                if (diseñoDeInterfacesCheckBox.isSelected()) {
                    resultado+="- Diseño de interfaces\n";
                }

                if (seguridadInformáticaCheckBox.isSelected()) {
                    resultado+="- Seguridad Informatica\n";
                }


                JOptionPane.showMessageDialog(null, resultado);

            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 20));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Seleccion multiple de intereses");
        frame.setContentPane(new SeleccionMultiple().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

