package views;

import controlador.ControladorAdmin;
import controlador.ControladorSC;

import javax.swing.*;

public class SuperCalidadVista extends JFrame {
    private JPanel superCalidad;
    private ControladorSC controlSC;

    public SuperCalidadVista(ControladorSC controlerSC) {
        setContentPane(superCalidad);
        setTitle("Menu Principal");
        setSize(750,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);
        setLocationRelativeTo(null);
        this.controlSC = controlerSC;
        //control.configurarBotonIngresar(ingresarButton);

    }

    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }
}

