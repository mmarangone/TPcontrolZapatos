package views;

import controlador.Controlador;
import controlador.ControladorAdmin;

import javax.swing.*;

public class AdminVista extends JFrame{

    private ControladorAdmin controlAdmin;
    private JPanel adminVista;

    public AdminVista(ControladorAdmin controlerAdmin) {
        setContentPane(adminVista);
        setTitle("Menu Principal");
        setSize(750,600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setVisible(true);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        //control.configurarBotonIngresar(ingresarButton);

    }

    public void ejecutar(){
        this.setVisible(true);
    }
}
