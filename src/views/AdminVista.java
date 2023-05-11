package views;

import controlador.ControladorAdmin;

import javax.swing.*;

public class AdminVista extends JFrame{

    private ControladorAdmin controlAdmin;
    private JPanel adminVista;
    private JButton gestionarModelosButton;
    private JButton gestionarColoresButton;
    private JButton salirButton;

    public AdminVista(ControladorAdmin controlerAdmin) {
        setContentPane(adminVista);
        setTitle("Menu Principal");
        setSize(450,300);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //setUndecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.controlAdmin = controlerAdmin;
        controlAdmin.configurarBotonSalirMenu(salirButton);
        controlAdmin.configurarBotonGestionarModelos(gestionarModelosButton);
        controlAdmin.configurarBotonGestionarColores(gestionarColoresButton);

    }

    public void ejecutar(){
        this.setVisible(true);
    }
    public void cerrar(){
        this.setVisible(false);
    }
}
