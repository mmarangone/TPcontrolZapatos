package modelo;

import java.util.ArrayList;

public class OrdenProduccion {

    public enum Estado{
        INICIADA,
        ENPAUSA,
        FINALIZADA
    }
    private int numero;
    private int paresPrimera;
    private int paresSegunda;
    private Estado estado;
    private Usuario user;
    private Modelo model;
    private Color color;
    private Usuario supCalidad;

    //Constructor
    public OrdenProduccion(int numero, Usuario u, Modelo m, Color c, Usuario sc) {
        this.numero = numero;
        this.estado = Estado.INICIADA;
        this.user = u;
        this.model = m;
        this.color = c;
        this.supCalidad = sc;
    }

    //Getter and Setters
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getParesPrimera() {
        return paresPrimera;
    }
    public void setParesPrimera(int paresPrimera) {
        this.paresPrimera = paresPrimera;
    }
    public int getParesSegunda() {
        return paresSegunda;
    }
    public void setParesSegunda(int paresSegunda) {
        this.paresSegunda = paresSegunda;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public Modelo getModel() {
        return model;
    }

    public void setModel(Modelo model) {
        this.model = model;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Usuario getSupCalidad() {
        return supCalidad;
    }

    public void setSupCalidad(Usuario supCalidad) {
        this.supCalidad = supCalidad;
    }
}
