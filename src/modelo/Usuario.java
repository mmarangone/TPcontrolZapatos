package modelo;

public class Usuario extends Empleado{
    private String user;
    private String pass;
    private Rol rol;

    //Constructor
    public Usuario(long dni, String nombre, String apellido, String mail, String pass, Rol rol) {
        super(dni, nombre, apellido, mail);
        this.user = mail;
        this.pass = pass;
        this.rol = rol;
    }

    //Getter and Setters

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
}
