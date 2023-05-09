package controlador;

import modelo.*;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Controlador implements ActionListener {
    //private ArrayList<Usuario> usuarios;
    private IniciarSesionVista ISV;
    private Repositorio repositorio;
    private Controlador thisControlador = this;

    public Controlador (){
        ISV = new IniciarSesionVista (thisControlador);
        ISV.ejecutar();
        repositorio = Repositorio.getRepositorio();
    }
    public void configurarBotonIngresar(JButton ingresarButton) {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean var = chequearUsuario(ISV.getUsuario(),ISV.getPass());
                if (var){
                    String rol = rolUsuario(ISV.getUsuario(),ISV.getPass());
                    JOptionPane.showMessageDialog(null, "Camino correcto!");
                    switch (rol) {
                        case "SUPERCALIDAD":
                            JOptionPane.showMessageDialog(null, "Supervisor de Calidad en proceso");
                            break;
                        case "SUPERLINEA":
                            ISV.cerrar();
                            ControladorSL csl = new ControladorSL(repositorio,repositorio.obtenerUsuario(ISV.getUsuario()),thisControlador );
                            break;
                        case "ADMINISTRADOR":
                            ISV.cerrar();
                            ControladorAdmin cad = new ControladorAdmin(repositorio,repositorio.obtenerUsuario(ISV.getUsuario()),thisControlador );
                            break;
                        default:
                            System.out.println("Rol desconocido.");
                            break;
                    }
                }
                else {ISV.errorIngreso();}
            }
        });

            }



    public Boolean chequearUsuario(String user, String pass){
        Boolean var = false;
        var = repositorio.chequearUsuario(user,pass);
        return var;
    }

    public String rolUsuario (String user, String pass){
        String rol = "";
        rol = repositorio.rolUsuario(user,pass);
        return rol;
    }

    public void ejecutarVista(){
        ISV = new IniciarSesionVista (thisControlador);
        ISV.ejecutar();

    }

    /*public Usuario obtenerUsuario(String user){

        return

    }*/

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
