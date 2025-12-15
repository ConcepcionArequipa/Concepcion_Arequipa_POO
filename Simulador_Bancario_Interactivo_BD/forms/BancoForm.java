package forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import conexion.ConexionBD;
import java.sql.*;

public class BancoForm extends JFrame {
    private JButton depositarButton;
    private JButton retirarButton;
    private JButton transferenciaButton;
    private JButton salirButton;
    private JLabel lblNombre;
    private JLabel lblSaldo;
    private JPanel panelBancario;
    private JScrollPane jspHistorial; //Panel para scrollear el historial
    private JTextArea txtHistorial;

    private double saldo;
    private String nombreUsuario;
    private String historial="";




    public BancoForm(String nombreUsuario, double saldo) {
        this.nombreUsuario = nombreUsuario;
        this.saldo = saldo;
        setTitle("Operaciones Bancarias");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panelBancario);
        setVisible(true);
        //Nombre de usuario

        lblNombre.setText(nombreUsuario);

        lblSaldo.setText("$"+ saldo);

        //Acciones del boton de depositar

        depositarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Usar un Jpanel para solicitar el valor a depositar

                String input = JOptionPane.showInputDialog(
                        BancoForm.this,
                        "Ingresa el valor a depositar: ",
                        "Depósito",
                        JOptionPane.PLAIN_MESSAGE
                );
                //Validacion
                if(input!=null && !input.isEmpty()){
                    //Atrapamos las excepciones con try-catch
                    try {
                        double valorDepositado = Double.parseDouble(input);
                        if(valorDepositado > 0){
                            BancoForm.this.saldo += valorDepositado;
                            lblSaldo.setText("$"+ BancoForm.this.saldo);
                            JOptionPane.showMessageDialog(null, "Deposito realizado exitosamente!");
                            actualizarSaldoBD();
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Monto inválido");
                        }
                    }
                    catch (NumberFormatException ex){
                        JOptionPane.showMessageDialog(null, "Ingrese un número válido!");
                    }

                }
                else {
                    JOptionPane.showMessageDialog(BancoForm.this, "Debe llenar todos los campos");
                }

            }
        });

        //Acciones del boton de retirar dinero

        retirarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane
                String input = JOptionPane.showInputDialog(
                        BancoForm.this,
                        "Ingresa el valor a retirar: ",
                        "Retirar", //Titulo
                        JOptionPane.PLAIN_MESSAGE
                );
                if(input!=null && !input.isEmpty()){
                    try {
                        double valorRetiro = Double.parseDouble(input);
                        if(valorRetiro <= 0){
                            JOptionPane.showMessageDialog(null,"El monto debe ser mayor a 0");
                            return;
                        }
                        //Validar que el saldo a retirar sea suficiente
                        if(valorRetiro > saldo){
                            JOptionPane.showMessageDialog(null, "Saldo insuficiente\nTu saldo actual es: $" + saldo);


                        }
                        else {
                            BancoForm.this.saldo -= valorRetiro;
                            lblSaldo.setText("$"+ BancoForm.this.saldo);
                            JOptionPane.showMessageDialog(null, "Retiro realizado exitosamente!");
                            actualizarSaldoBD();


                        }

                    }
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(BancoForm.this, "Debe llenar todos los campos");
                }

            }
        });

        // Accion para el boton de transferencia
        transferenciaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear un pequeño formulario
                JTextField txtDestinatario = new JTextField();
                JTextField txtMonto = new JTextField();

                Object[] mensaje = {
                        "Ingrese el nombre del destinatario: ",txtDestinatario,
                        "Ingrese el valor del monto: ",txtMonto
                };
                //JOptionPane
                int transferencia= JOptionPane.showConfirmDialog(
                        BancoForm.this,
                        mensaje,
                        "Transferencia", //Titulo
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE
                );

                //Si se apresiona el boton de ok
                if(transferencia==JOptionPane.OK_OPTION){
                    String destinatario = txtDestinatario.getText();
                    String monto = txtMonto.getText();

                    //Validacion si los campos estan vacios

                    if(destinatario.isEmpty() || monto.isEmpty()){
                        JOptionPane.showMessageDialog(BancoForm.this, "Debe llenar todos los campos");
                        return;
                    }

                    try {

                        //Transformar el monto a double
                        double montoTranferir= Double.parseDouble(monto);

                        //Validar si es negativo el monto o si es cero

                        if (montoTranferir <= 0 ){
                            JOptionPane.showMessageDialog(BancoForm.this, "El monto debe ser mayor a 0");
                            return;
                        }

                        //Verificar que el monto no supere el saldo

                        if (montoTranferir > saldo){
                            JOptionPane.showMessageDialog(BancoForm.this, "Saldo insuficiente\nTu saldo actual es: $" + saldo);
                            return;
                        }
                        else {


                            try (Connection conexion = ConexionBD.getConexion()) {
                                String sqlCheck = "SELECT saldo FROM usuarios WHERE usuario = ?";
                                try (PreparedStatement psCheck = conexion.prepareStatement(sqlCheck)) {
                                    psCheck.setString(1, destinatario);
                                    try (ResultSet rs = psCheck.executeQuery()) {
                                        if (!rs.next()) {
                                            JOptionPane.showMessageDialog(BancoForm.this, "El destinatario no existe");
                                            return;
                                        }

                                        conexion.setAutoCommit(false);
                                        // actualizar remitente y destinatario

                                        // Restar saldo al remitente ya hecho
                                        String sqlRemitente = "UPDATE usuarios SET saldo=? WHERE usuario=?";
                                        PreparedStatement psRemitente = conexion.prepareStatement(sqlRemitente);
                                        psRemitente.setDouble(1, BancoForm.this.saldo);
                                        psRemitente.setString(2, nombreUsuario);
                                        psRemitente.executeUpdate();

                                        // Sumar saldo al destinatario
                                        String sqlDestinatario = "UPDATE usuarios SET saldo = saldo + ? WHERE usuario=?";
                                        PreparedStatement psDestinatario = conexion.prepareStatement(sqlDestinatario);
                                        psDestinatario.setDouble(1, montoTranferir);
                                        psDestinatario.setString(2, destinatario);
                                        psDestinatario.executeUpdate();

                                        conexion.commit();
                                        BancoForm.this.saldo -= montoTranferir;
                                        lblSaldo.setText("$"+ BancoForm.this.saldo);
                                        JOptionPane.showMessageDialog(BancoForm.this,
                                                "Transferencia exitosa a " + destinatario + " por $" + montoTranferir);

                                        agregarTransferencias("Nombre del destinatario: "+ destinatario +
                                                "\nMonto transferido: $" + montoTranferir +
                                                "\nSaldo actual: $" + BancoForm.this.saldo + "\n");
                                    }
                                } catch (SQLException ex) {
                                    conexion.rollback();
                                    JOptionPane.showMessageDialog(BancoForm.this, "Error en la transferencia");
                                } finally {
                                    conexion.setAutoCommit(true);
                                }
                            } catch (SQLException ex) {
                                JOptionPane.showMessageDialog(BancoForm.this, "Error al conectarse a la base de datos");
                            }
                        }

                    }
                    catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Ingrese un número valido");
                    }
                }



            }
        });

        //Accion para el boton de salir

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //JoptionPane para salir con un mensaje de confirmacion
                int salir = JOptionPane.showConfirmDialog(
                        null,
                        "¿ Seguro que deseas salir?",
                        "Confirmacion de Salida",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE //Da un icono de alerta
                );
                //Si apresiona el usuario si, sale del sistema
                if (salir == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }


            }
        });
        //Agregar un diseño mas lindo en cuanto a margenes
        panelBancario.setBorder(BorderFactory.createEmptyBorder(25, 25, 20, 25));
    }

    //Metodo para el historial de transacciones
    private void agregarTransferencias(String mensaje){

        historial += mensaje + "\n"; //Agregamos las transferencias
        txtHistorial.setText(historial); //Modificamos el txtHistorial
    }

    //Metodo para actualizar el saldo
    private void actualizarSaldoBD() {
        try {
            Connection conexion = ConexionBD.getConexion();
            String sql = "UPDATE usuarios SET saldo=? WHERE usuario=?";
            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setDouble(1, saldo);
            ps.setString(2, nombreUsuario);
            ps.executeUpdate();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar saldo en la BD");
        }
    }

}
