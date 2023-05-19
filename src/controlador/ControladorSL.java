package controlador;

import modelo.Color;
import modelo.Modelo;
import modelo.Repositorio;
import modelo.Usuario;
import views.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControladorSL implements ActionListener{
    //private ArrayList<Usuario> usuarios;
    private SuperLineaVista SLV;
    private VerOP VOPV;
    private CrearOP COPV;
    private ConfirmarVista confirmarVista;
    private Repositorio repositorio;
    private Usuario user;
    private Controlador controlador;
    private ControladorSL thisControlador = this;
    private ConfirmacionDialog confirmacionDialog;
    public ControladorSL (Repositorio repo, Usuario u, Controlador c){
        this.repositorio = repo;
        this.user = u;
        this.controlador = c;
        SLV = new SuperLineaVista (this);
        SLV.ejecutar();
    }

    /** Configuracion de botones **/

    /** Menu principal **/
    public void configurarBotonCrearOP(JButton crearOPButton) {
        if (tieneOP()){
            crearOPButton.setEnabled(false);
        }else{
            crearOPButton.setEnabled(true);
            crearOPButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (chequearDisponibilidad()){
                        SLV.cerrar();
                        COPV = new CrearOP(thisControlador);
                        COPV.ejecutar();
                    }else{
                        SLV.mensajeNoDisponible();
                    }


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
                    SLV.cerrar();
                    VOPV = new VerOP(thisControlador);
                    VOPV.ejecutar();

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

    /** Ver OP **/
    public void configurarBotonReanudar(JButton reanudarBoton){
        ArrayList<String> datosOP = datosOP();
        if (datosOP.get(0).equals("PAUSA")){
            reanudarBoton.setEnabled(true);
            reanudarBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    reanudarOP(datosOP.get(1));
                    VOPV.completarLabels();
                    VOPV.deshabilitarBotonReanudar();
                    VOPV.habilitarBotonPausar();
                    VOPV.habilitarBotonFinalizar();
                    VOPV.configurarBotones();

                }
            });
        }else {
            reanudarBoton.setEnabled(false);

        }
    }
    public void configurarBotonPausar(JButton pausarBoton){
        ArrayList<String> datosOP = datosOP();
        if (datosOP.get(0).equals("INICIADA")){
            pausarBoton.setEnabled(true);
            pausarBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pausarOP(datosOP.get(1));
                    VOPV.completarLabels();
                    VOPV.deshabilitarBotonPausar();
                    VOPV.deshabilitarBotonFinalizar();
                    VOPV.habilitarBotonReanudar();
                    VOPV.configurarBotones();
                }
            });
        }else{
            pausarBoton.setEnabled(false);

        }

    }
    public void configurarBotonFinalizar(JButton finalizarBoton){
        ArrayList<String> datosOP = datosOP();
        confirmacionDialog = new ConfirmacionDialog(VOPV, "Confirmación", "¿Está seguro de finalizar la OP?");
        if (datosOP.get(0).equals("INICIADA")){
            finalizarBoton.setEnabled(true);
            finalizarBoton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    funcion(datosOP);
                }
            });
        }else{
            finalizarBoton.setEnabled(false);
        }

    }
    public void configurarBotonCerrar(JButton cerrarBoton){
        cerrarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SLV.ejecutar();
                SLV.completarLabels();
                VOPV.cerrar();
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
    public void pausarOP(String numeroOP){
        int numero = Integer.parseInt(numeroOP);
        repositorio.pausarOP(numero);
    }
    public void reanudarOP(String numeroOP){
        int numero = Integer.parseInt(numeroOP);
        repositorio.reanudarOP(numero);
    }
    public void finalizarOP(String numeroOP){
        int numero = Integer.parseInt(numeroOP);
        repositorio.finalizarOP(numero);
    }
    public Boolean chequearDisponibilidad(){
        Boolean var = false;
        if(repositorio.chequearDisponibilidadLineas()){
            var = true;
        }
        return var;
    }

    public ArrayList<Color> traerColoresModelo(String modelo){
        ArrayList<Color> colores = null;
        Modelo m = repositorio.getModeloPorDescripcion(modelo);
        colores = repositorio.traerColoresModelo(m);
        return colores;
    }
    public ArrayList<Modelo> traerModelos(){
        ArrayList<Modelo> m = repositorio.traerModelos();
        return m;
    }
    public ArrayList<String> traerSupervisoresDisponibles(){
        ArrayList<String> sup = repositorio.traerSupervisoresLibres();
        return sup;
    }
    public ArrayList<String> traerLineasDisponibles(){
        ArrayList<String> lineas = repositorio.traerLineasLibres();
        return lineas;
    }


    public void crearOP(ArrayList<String> datos){
        ArrayList<String> infoOP = new ArrayList<>();
        String usuario = user.getUser();
        infoOP.add(datos.get(0));
        infoOP.add(datos.get(1));
        infoOP.add(usuario);
        infoOP.add(datos.get(3));
        infoOP.add(datos.get(4));
        infoOP.add(datos.get(2));
        repositorio.crearOP(infoOP);

    }
    public void vueltaMenuPrincipal(){
        COPV.cerrar();
        SLV.ejecutar();
        SLV.completarLabels();
        SLV.configuracionBotones();
    }

    public void funcion(ArrayList<String> datosOP){
        if (confirmacionDialog.getVar() == 0) { // Verificar si el diálogo ya está visible
            confirmacionDialog.setVisible(true);
            confirmacionDialog.setVarEn1();
            // Esperar la respuesta del usuario antes de continuar
            if (confirmacionDialog.isConfirmed()) {
                finalizarOP(datosOP.get(1));
                VOPV.cerrar();
                SLV.ejecutar();
                SLV.completarLabels();
                SLV.configuracionBotones();

            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
