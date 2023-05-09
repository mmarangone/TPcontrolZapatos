package controlador;

import modelo.Repositorio;
import modelo.Usuario;
import views.IniciarSesionVista;
import views.SuperLineaVista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorSL implements ActionListener{
    //private ArrayList<Usuario> usuarios;
    private SuperLineaVista SLV;
    private Repositorio repositorio;
    private Usuario user;
    private Controlador controlador;
    public ControladorSL (Repositorio repo, Usuario u, Controlador c){
        this.repositorio = repo;
        this.user = u;
        this.controlador = c;
        SLV = new SuperLineaVista (this);
        SLV.ejecutar();
    }

    /** Configuracion de botones **/
    public void configurarBotonCrearOP(JButton crearOPButton) {
        if (tieneOP()){
            crearOPButton.setEnabled(false);
        }else{
            crearOPButton.setEnabled(true);
            crearOPButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }

    }

    public void configurarBotonVerOP(JButton verOPButton) {
        if (tieneOP()){
            verOPButton.setEnabled(true);
            verOPButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
        }else{
            verOPButton.setEnabled(false);

        }

    }

    public void configurarBotonSalir(JButton salirButton) {
            salirButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SLV.cerrar();
                    controlador.ejecutarVista();

                }
            });


    }


    /** Funciones **/
    public Boolean tieneOP(){
    Boolean var = false;
        if (repositorio.tieneOP(user)) {
            var = true;
        }
    return var;
    }
    public ArrayList<String> datosOP(){
        ArrayList<String> datosOp = repositorio.datosOP(user);
        return datosOp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
