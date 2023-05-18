package views;

import controlador.ControladorSL;
import modelo.Usuario;

import javax.swing.*;
import java.util.ArrayList;

public class SuperLineaVista extends JFrame {
    private JPanel superLinea;
    private JLabel labelOP;
    private JLabel labelLinea;
    private JLabel labelSupCalidad;
    private JButton crearOPButton;
    private JButton verOPButton;
    private JButton salirButton;
    private ControladorSL controlSL;
    private Usuario user;
    public SuperLineaVista(ControladorSL controlerSL) {
        setContentPane(superLinea);
        setTitle("Menu Principal");
        setSize(450,300);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlSL = controlerSL;

        configuracionBotones();
        completarLabels();

    }

    public void completarLabels(){
        if (controlSL.tieneOP()){
            ArrayList<String> labels;
            labels = controlSL.datosOP();
            labelOP.setText("N°: "+labels.get(1)+"-"+labels.get(0));
            labelLinea.setText(""+labels.get(2));
            labelSupCalidad.setText(""+labels.get(3));
        }else {
            labelOP.setText("Sin OP asociada");
            labelLinea.setText("-");
            labelSupCalidad.setText("-");
        }

    }
    public void configuracionBotones(){
        controlSL.configurarBotonCrearOP(crearOPButton);
        controlSL.configurarBotonVerOP(verOPButton);
        controlSL.configurarBotonSalir(salirButton);
    }
    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }
    public void mensajeNoDisponible(){
        JOptionPane.showMessageDialog(null,"No hay lineas disponibles");
    }


}
