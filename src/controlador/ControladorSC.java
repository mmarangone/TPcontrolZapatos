package controlador;

import modelo.Repositorio;
import modelo.Usuario;
import views.SuperCalidadVista;
import views.SuperLineaVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorSC {
    private SuperCalidadVista SCV;
    private Repositorio repositorio;
    private Usuario user;
    private Controlador controlador;
    public ControladorSC (Repositorio repo, Usuario u, Controlador c){
        this.repositorio = repo;
        this.user = u;
        this.controlador = c;
        SCV = new SuperCalidadVista(this);
        SCV.ejecutar();
    }

    /** Configuracion de botones **/
    public void configurarBotonSalir(JButton salirButton) {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SCV.cerrar();
                controlador.ejecutarVista();

            }
        });

    }
}
