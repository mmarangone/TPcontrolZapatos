package modelo;

import java.util.ArrayList;

public class Repositorio {



    //Usuarios

    ArrayList<Usuario> users = new ArrayList<>();

    private static Repositorio miRepositorio;

    public static Repositorio getRepositorio() { // Singleton

        if (miRepositorio == null) {

            miRepositorio = new Repositorio();
        }
        return miRepositorio;
    }

    public Repositorio() {
        users = new ArrayList<>();

        Usuario u1 = new Usuario(40215887,"Matias", "Marangone",
                "mimail@gmail.com","1234", Rol.ADMINISTRADOR);
        users.add(u1);

    }

    public ArrayList<Usuario> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }

    public Boolean chequearUsuario(String user, String pass){
        Boolean var = false;
        for (Usuario us : users) {
            if (us.getMail().equals(user)){
                if (us.getPass().equals(pass)){
                    var = true;
                }
            }
        }
        return var;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
