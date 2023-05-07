package modelo;

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

    //Constructor
    public OrdenProduccion(int numero) {
        this.numero = numero;
        this.estado = Estado.INICIADA;
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
}
