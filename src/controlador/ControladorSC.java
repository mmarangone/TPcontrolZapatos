package controlador;

import modelo.Repositorio;
import views.SuperCalidadVista;
import views.SuperLineaVista;

public class ControladorSC {
    private SuperCalidadVista SCV;
    private Repositorio repositorio;
    public ControladorSC (Repositorio repo){
        SCV = new SuperCalidadVista(this);
        SCV.ejecutar();
        this.repositorio = repo;
    }
}
