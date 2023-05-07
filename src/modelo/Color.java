package modelo;

public class Color {
    private String descripcion;
    private int codigo;

    public Color(String descripcion, int codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
