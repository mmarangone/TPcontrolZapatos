package views;

import controlador.Controlador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IniciarSesionVista extends JFrame {
    private JPanel iniciarSesion;
    private JTextField userText;
    private JTextField passText;
    private JButton ingresarButton;
    private JLabel mensajeLabel;

    private Controlador control;

    public IniciarSesionVista(Controlador controler) {
        setContentPane(iniciarSesion);
        setTitle("Iniciar Sesion");
        setSize(450,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);
        setLocationRelativeTo(null);
        this.control = controler;

        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean var = controler.chequearUsuario(getUsuario(),getPass());
                if (var){
                    JOptionPane.showMessageDialog(null, "Camino correcto!");
                }
                else {errorIngreso();}
            }
        });
    }

    public void errorIngreso(){
        mensajeLabel.setText("Usuario/Contraseña incorrecto");
    }
    public void ejecutar(){
        this.setVisible(true);
    }
    public String getUsuario(){return userText.getText();}
    public String getPass(){return passText.getText();}
}
