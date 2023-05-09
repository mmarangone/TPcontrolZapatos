package controlador;

import modelo.Repositorio;
import modelo.Usuario;
import views.AdminVista;
import views.GestionColoresVista;
import views.GestionModelosVista;
import views.SuperCalidadVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdmin implements ActionListener {
    private AdminVista AV;
    private GestionModelosVista GMV;
    private GestionColoresVista GCV;
    private Repositorio repositorio;
    private Usuario user;
    private Controlador controlador;
    private ControladorAdmin thisControlador = this;
    public ControladorAdmin (Repositorio repo, Usuario u, Controlador c){
        this.repositorio = repo;
        this.user = u;
        this.controlador = c;
        AV = new AdminVista(this);
        AV.ejecutar();
    }



    /** Configuracion de Botones **/
    public void configurarBotonGestionarModelos(JButton GestionModelosButton) {
        GestionModelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AV.cerrar();
                GMV = new GestionModelosVista(thisControlador);
                GMV.ejecutar();
            }
        });

    }

    public void configurarBotonGestionarColores(JButton GestionColoresButton) {
        GestionColoresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AV.cerrar();
                GCV = new GestionColoresVista(thisControlador);
                GCV.ejecutar();
            }
        });

    }

    public void configurarBotonSalir(JButton salirButton) {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AV.cerrar();
                controlador.ejecutarVista();

            }
        });

    }

    public void ejecutarGestionModelos(){

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
