package modelo;

import java.util.ArrayList;

public class Modelo {

    private String descripcion;
    private String sku;
    private ArrayList<Color> colores;

    public Modelo (String descripcion, String sku){
        this.descripcion = descripcion;
        this.sku = sku;
        this.colores = new ArrayList<>();
    }

    public void agregarColor(Color c){
        colores.add(c);
    }
    public void quitarColor(Color c){
        colores.remove(c);
    }

    public Color getColor(Color c){
        int index = colores.indexOf(c);
        return colores.get(index);
    }
    public ArrayList<Color> getColores(){
        return colores;
    }
    public ArrayList<String> listarColores(){
        ArrayList<String> lista = new ArrayList<>();
        for (Color c : colores){
            lista.add(c.getDescripcion());
        }
        return lista;
    }
    public String getDescripcion() {

        /*  ArrayList<String> descripciones = new ArrayList<>();
        if (colores.isEmpty()){
            descripciones.add(getSku()+"-Sin colores asociados");
        } else {
            for (Color c : colores) {
                descripciones.add(getSku()+ "-" + c.getCodigo());
            }
        }*/
        return descripcion;
    }

    /*public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }*/

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
