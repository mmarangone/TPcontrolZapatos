package controlador;

import modelo.Modelo;
import modelo.Repositorio;
import modelo.Color;
import modelo.Usuario;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorAdmin implements ActionListener {
    private AdminVista AV;
    private GestionModelosVista GMV;
    private GestionColoresVista GCV;
    private VerModelos VMV;
    private ModificarModelos MMV;
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

    /** Vista menu **/
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

    public void configurarBotonSalirMenu(JButton salirButton) {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AV.cerrar();
                controlador.ejecutarVista();

            }
        });

    }

    /** Vista Gestion de Modelos**/
    public void configurarBotonSalirGestionModelos(JButton salirButton) {
        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GMV.cerrar();
                AV.ejecutar();

            }
        });

    }
    public void quitarModelo(Object[] modelo){
        String sku = modelo[0].toString();
         Modelo modeloSeleccionado = repositorio.getModelo(sku);
         repositorio.quitarModelo(modeloSeleccionado);
         GMV.completarTabla();

    }
    public void modificarModelo(Object[] modelo){
        String sku = modelo[0].toString();
        Modelo modeloSeleccionado = repositorio.getModelo(sku);
        GMV.cerrar();
        MMV = new ModificarModelos(thisControlador, modeloSeleccionado);
        MMV.ejecutar();

    }
    public ArrayList<Modelo> traerModelos(){
    ArrayList<Modelo> modelos = new ArrayList<>();
    modelos = repositorio.traerModelos();
    return modelos;
    }
    public Boolean checkModeloExist(String sku, String descripcion){
        Modelo m = new Modelo(descripcion,sku);
        return repositorio.checkModeloExist(m);
    }
    public void agregarModelo(String sku,String descripcion,String color){
        Color c = repositorio.getColorPorDescripcion(color);
        Modelo m = new Modelo(descripcion,sku);
        m.agregarColor(c);
        repositorio.agregarModelo(m);
        GMV.completarTabla();
    }

    /** Vista Ver modelo **/
    public void configBotonCerrar(JButton cerrarButton){
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VMV.cerrar();
                GMV.ejecutar();

            }
        });
    }

    /** Vista Modificar Modelo **/
    public void configurarBotonFinalizarModificarModelo(JButton finalizarButton){
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MMV.cerrar();
                GMV.ejecutar();

            }
        });
    }

    public void configurarBotonFinalizarGestionColores(JButton finalizarButton){
        finalizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GCV.cerrar();
                AV.ejecutar();

            }
        });
    }
    public void quitarColor(Object[] modelo){
        String sku = modelo[0].toString();
        String codigo = modelo[1].toString();
        Modelo modeloSeleccionado = repositorio.getModelo(sku);
        Color c = repositorio.getColorPorCodigo(codigo);
        modeloSeleccionado.quitarColor(c);
        MMV.completarTablaModelos(modeloSeleccionado);
        MMV.completarTablaColores(modeloSeleccionado);
    }
    public ArrayList<Color> traerColoresDisponibles(){
        ArrayList<Color> colores;
        colores = repositorio.getColoresDisponibles();
        return colores;
    }
    public void agregarColorModelo(Object[] color, Modelo m){
        String codigo = color[0].toString();
        Color c = repositorio.getColorPorCodigo(codigo);
        m.agregarColor(c);
        MMV.completarTablaModelos(m);
        MMV.completarTablaColores(m);
    }

    /** Vista Gestion Colores **/
    public void agregarColorPaleta(String codigo,String descripcion){
        Color color = new Color(descripcion,codigo);
        repositorio.agregarColorPaleta(color);
        GCV.completarTabla();
    }

    public Boolean checkColorExist(String codigo, String descripcion){
        Color c = new Color(descripcion,codigo);
        return repositorio.checkColorExist(c);
    }
    public void quitarColorPaleta(Object[] modelo){
        String codigo = modelo[0].toString();
        Color c = repositorio.getColorPorCodigo(codigo);
        repositorio.quitarColorPaleta(c);
        GCV.completarTabla();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
