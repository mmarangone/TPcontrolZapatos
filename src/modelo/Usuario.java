package modelo;

public class Usuario {
    private long dni;
    private String nombre;
    private String apellido;
    private String mail;
    private String pass;
    private Rol rol;

    //Constructor
    public Usuario(long dni, String nombre, String apellido, String mail, String pass, Rol rol) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.pass = pass;
        this.rol = rol;
    }

    //Getter and Setters
    public long getDni() {
        return dni;
    }
    public void setDni(long dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
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
