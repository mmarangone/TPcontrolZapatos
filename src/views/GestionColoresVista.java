package views;

import controlador.ControladorAdmin;

import javax.swing.*;

public class GestionColoresVista extends JFrame{
    private ControladorAdmin controlAdmin;
    private JPanel gestionColores;

    public GestionColoresVista(ControladorAdmin controlerAdmin) {
        setContentPane(gestionColores);
        setTitle("Gestion de Colores");
        setSize(450,300);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        //controlAdmin.configurarBotonSalir(salirButton);

    }






    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }
}
