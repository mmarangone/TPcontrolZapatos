package controlador;

import modelo.*;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener {
    private ArrayList<Usuario> usuarios;
    private IniciarSesionVista ISV;
    private Repositorio repositorio;
    public Controlador (){
    ISV = new IniciarSesionVista (this);
    ISV.ejecutar();
    repositorio = Repositorio.getRepositorio();
    }

    public Boolean chequearUsuario(String user, String pass){
        Boolean var = false;
        var = repositorio.chequearUsuario(user,pass);
        return var;
    }
    //public void

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
