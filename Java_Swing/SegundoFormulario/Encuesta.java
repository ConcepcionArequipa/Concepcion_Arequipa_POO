package SegundoFormulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Encuesta {
    private JRadioButton unaVezRadioButton;
    private JRadioButton dosVecesRadioButton;
    private JRadioButton masDeDosVecesRadioButton;
    private JRadioButton muyComprometidoRadioButton;
    private JRadioButton pocoComprometidoRadioButton;
    private JRadioButton nadaComprometidoRadioButton;
    private JRadioButton a1HoraRadioButton;
    private JRadioButton a2HorasRadioButton;
    private JRadioButton a3HorasOMasRadioButton;
    private JButton enviarRespuestasButton;
    private JPanel mainPanel;

    //Metodo constructor
    public Encuesta() {
        //Creacion de los button group

        ButtonGroup grupo1 = new ButtonGroup();
        grupo1.add(unaVezRadioButton);
        grupo1.add(dosVecesRadioButton);
        grupo1.add(masDeDosVecesRadioButton);

        ButtonGroup grupo2 = new ButtonGroup();
        grupo2.add(muyComprometidoRadioButton);
        grupo2.add(pocoComprometidoRadioButton);
        grupo2.add(nadaComprometidoRadioButton);

        ButtonGroup grupo3 = new ButtonGroup();
        grupo3.add(a1HoraRadioButton);
        grupo3.add(a2HorasRadioButton);
        grupo3.add(a3HorasOMasRadioButton);

        // Action listener para el boton de Enviar respuestas
        enviarRespuestasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Declaracion de las opciones
                String respuesta1 = "";
                String respuesta2 = "";
                String respuesta3 = "";

                //Pregunta 1

                if (unaVezRadioButton.isSelected()) {
                    respuesta1 = "Una vez";
                } else if (dosVecesRadioButton.isSelected()) {
                    respuesta1 = "Dos veces";

                } else if (masDeDosVecesRadioButton.isSelected()) {
                    respuesta1 = "Mas de dos veces";
                }

                //Pregunta 2
                if (muyComprometidoRadioButton.isSelected()) {
                    respuesta2 = "Muy comprometido";
                } else if (pocoComprometidoRadioButton.isSelected()) {
                    respuesta2 = "Poco comprometido";

                } else if (nadaComprometidoRadioButton.isSelected()) {
                    respuesta2 = "Nada comprometido";
                }

                //Pregunta 3

                if (a1HoraRadioButton.isSelected()) {
                    respuesta3 = "1 hora";
                } else if (a2HorasRadioButton.isSelected()) {
                    respuesta3 = "2 horas";

                } else if (a3HorasOMasRadioButton.isSelected()) {
                    respuesta3 = "3 horas o mas";
                }

                //Validacion si el usuario no responde todas las preguntas

                if (respuesta1.isEmpty() || respuesta2.isEmpty() || respuesta3.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Responde todas las preguntas");
                    return;
                }

                //Resultado o resumen

                String mensaje="Resumen de la encuesta\n"+
                               "Pregunta 1: "+ respuesta1 +
                               "\nPregunta 2: "+ respuesta2 +
                               "\nPregunta 3: "+ respuesta3;

                //Mostrar el resumen de la encuesta en un JOptionPane
                JOptionPane.showMessageDialog(null, mensaje);

            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 30, 20));
    }

    //Main para ejecutar el formulario

    public static void main(String[] args) {
        JFrame frame = new JFrame("Encuesta sobre las clases virtuales EPN");
        frame.setContentPane(new Encuesta().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
