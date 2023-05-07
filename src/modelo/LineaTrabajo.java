package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class LineaTrabajo {
    public enum Estado{
        Disponible,
        NoDisponible
    }//Posibles estados, por defecto estará disponible al momento de la creacion
    private int numero;
    private Estado estado;
    private HashMap<String,OrdenProduccion> lineaOcupada;

    public LineaTrabajo(int numero) {
        this.numero = numero;
        this.estado = Estado.Disponible;
    }

    public void ocuparLinea (String supervisor, OrdenProduccion op){
        this.estado = Estado.NoDisponible;
        lineaOcupada = new HashMap<>();
        lineaOcupada.put(supervisor, op);
    }

    public void desocuparLinea(){
        if (this.estado == Estado.NoDisponible){
            this.estado = Estado.Disponible;
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public HashMap<String, OrdenProduccion> getLineaOcupada() {
        return lineaOcupada;
    }

    public void setLineaOcupada(HashMap<String, OrdenProduccion> lineaOcupada) {
        this.lineaOcupada = lineaOcupada;
    }
}
