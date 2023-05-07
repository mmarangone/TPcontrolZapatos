package modelo;

import java.util.ArrayList;

public class Modelo {

    private String descripcion;
    private int sku;

    public Modelo (String descripcion, int sku){
        this.descripcion = descripcion;
        this.sku = sku;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }
}
