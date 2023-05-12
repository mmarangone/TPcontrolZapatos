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
        controlSL.configurarBotonCrearOP(crearOPButton);
        controlSL.configurarBotonVerOP(verOPButton);
        controlSL.configurarBotonSalir(salirButton);
        completarLabels();

    }

    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }

    public void completarLabels(){
        if (controlSL.tieneOP()){
            ArrayList<String> labels;
            labels = controlSL.datosOP();
            labelOP.setText("Orden de produccion: "+labels.get(0)+"-"+labels.get(1));
            labelLinea.setText("Linea: "+labels.get(2));
            labelSupCalidad.setText("Supervisor de Calidad: "+labels.get(3));
        }else {
            labelOP.setText("Orden de produccion: Sin OP asociada");
            labelLinea.setText("Linea: -");
            labelSupCalidad.setText("Supervisor de Calidad: "+"-");
        }

    }
}
