package modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class LineaTrabajo {
    public enum Estado{
        DISPONIBLE,
        NODISPONIBLE
    }//Posibles estados, por defecto estará disponible al momento de la creacion
    private int numero;
    private Estado estado;
    private OrdenProduccion op;

    public LineaTrabajo(int numero) {
        this.numero = numero;
        this.estado = Estado.DISPONIBLE;
    }

    public void ocuparLinea (OrdenProduccion op){
        this.estado = Estado.NODISPONIBLE;
        this.op = op;
    }

    public void desocuparLinea(){
        if (this.estado == Estado.NODISPONIBLE){
            this.estado = Estado.DISPONIBLE;
            this.op = null;
        }
    }
    public OrdenProduccion getOp(){
        return op;
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

    }

