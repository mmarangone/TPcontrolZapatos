package modelo;


import java.util.ArrayList;
import java.util.HashMap;


public class Repositorio {


    //Usuarios

    ArrayList<Usuario> users = new ArrayList<>();
    ArrayList<Modelo> modelos = new ArrayList<>();
    ArrayList<Color> colores = new ArrayList<>();
    ArrayList<OrdenProduccion> ordenesFinalizadas = new ArrayList<>();
    ArrayList<LineaTrabajo> lineasDeTrabajo = new ArrayList<>();

    private static Repositorio miRepositorio;

    public static Repositorio getRepositorio() { // Singleton

        if (miRepositorio == null) {

            miRepositorio = new Repositorio();
        }
        return miRepositorio;
    }

    public Repositorio() {
        /** Lineas de trabajo **/

        LineaTrabajo L1 = new LineaTrabajo(1);
        LineaTrabajo L2 = new LineaTrabajo(2);
        LineaTrabajo L3 = new LineaTrabajo(3);


        lineasDeTrabajo.add(L1);
        lineasDeTrabajo.add(L2);
        lineasDeTrabajo.add(L3);

        /** Usuarios **/

        users = new ArrayList<>();

        Usuario c1 = new Usuario(43426998, "Sergio", "Martinez",
                "calidad1@mail.com", "1234", Rol.SUPERCALIDAD);
        Usuario c2 = new Usuario(43426998, "Juan", "Perez",
                "calidad2@mail.com", "1234", Rol.SUPERCALIDAD);
        Usuario c3 = new Usuario(43426998, "Martin", "Gomez",
                "calidad1@mail.com", "1234", Rol.SUPERCALIDAD);
        Usuario sl1 = new Usuario(40215887, "Linea", "1",
                "linea1@mail.com", "1234", Rol.SUPERLINEA);
        Usuario sl2 = new Usuario(40215887, "Linea", "2",
                "linea2@mail.com", "1234", Rol.SUPERLINEA);
        Usuario sl3 = new Usuario(40215887, "Linea", "3",
                "linea3@mail.com", "1234", Rol.SUPERLINEA);
        Usuario a1 = new Usuario(40215887, "Admin", "Admin",
                "admin", "admin", Rol.ADMINISTRADOR);
        users.add(c1);
        users.add(c2);
        users.add(c3);
        users.add(sl1);
        users.add(sl2);
        users.add(sl3);
        users.add(a1);

        /** Colores **/
        Color co1 = new Color("Rojo", "RJ");
        Color co2 = new Color("Azul", "AZ");
        Color co3 = new Color("Negro", "NG");
        Color co4 = new Color("Blanco", "BL");
        Color co5 = new Color("Rosa", "RS");

        colores.add(co1);
        colores.add(co2);
        colores.add(co3);
        colores.add(co4);
        colores.add(co5);

        /** Modelos **/
        Modelo m1 = new Modelo("Nike Air Force", "NKAF");
        m1.agregarColor(co1);
        m1.agregarColor(co2);
        m1.agregarColor(co3);
        m1.agregarColor(co4);
        Modelo m2 = new Modelo("Adidas Smith", "ADSM");
        m2.agregarColor(co1);
        m2.agregarColor(co4);
        m2.agregarColor(co3);
        m2.agregarColor(co5);
        Modelo m3 = new Modelo("Pumas Clasicc", "PMCL");
        m3.agregarColor(co1);
        m3.agregarColor(co4);
        m3.agregarColor(co3);
        m3.agregarColor(co5);
        m3.agregarColor(co2);

        modelos.add(m1);
        modelos.add(m2);
        modelos.add(m3);


        /** Orden de produccion **/
        OrdenProduccion o1 = new OrdenProduccion(100,sl1 ,m1,m1.getColor(co2),c1);
        OrdenProduccion o2 = new OrdenProduccion(110,sl2,m2,m2.getColor(co5),c2);
        OrdenProduccion o3 = new OrdenProduccion(120,sl3,m3,m3.getColor(co4),c3);

        lineasDeTrabajo.get(0).ocuparLinea(o1);
        //ordenesDeProduccion.put(L2,o2);
        //ordenesDeProduccion.put(L3,o3);

        ordenesFinalizadas = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }

    /** Controlador **/
    public Usuario obtenerUsuario (String user){
        Usuario usuario = null;
        for (Usuario u :getUsers()){
            if (u.getUser().equals(user)){
                usuario = u;
                break;
            }else{
                usuario = null;
            }
        }
        return usuario;
    }
    public Boolean chequearUsuario(String user, String pass) {
        Boolean var = false;
        for (Usuario us : users) {
            if (us.getMail().equals(user)) {
                if (us.getPass().equals(pass)) {
                    var = true;
                }
            }
        }
        return var;
    }

    public String rolUsuario(String user, String pass) {
        String rol = "";
        for (Usuario us : users) {
            if (us.getMail().equals(user)) {
                if (us.getPass().equals(pass)) {
                    rol = us.getRol().toString();
                }
            }
        }

        return rol;
    }


    /** ControladorSL **/
    public Boolean tieneOP(Usuario u){
        Boolean var = false;
        for (LineaTrabajo l : lineasDeTrabajo){
            if (l.getEstado().toString().equals("NODISPONIBLE")) {
                OrdenProduccion op = l.getOp();
                if (op.getUser().equals(u)) {
                    var = true;
                }
            }
        }
        /*for (Map.Entry<LineaTrabajo,OrdenProduccion> hm : ordenesDeProduccion.entrySet()) {
            OrdenProduccion op = hm.getValue();
            if(op.getUser().equals(u)){
                var = true;
            }
        }*/
        return var;
    }

    public ArrayList<String> datosOP(Usuario u){
        ArrayList<String> datosOp = new ArrayList<>();
        for (LineaTrabajo l : lineasDeTrabajo) {
            if (l.getEstado().toString().equals("NODISPONIBLE")) {
                OrdenProduccion op = l.getOp();
                if (op.getUser().equals(u)) {
                    datosOp.add(op.getEstado().toString());
                    datosOp.add(String.valueOf(op.getNumero()));
                    datosOp.add(String.valueOf(l.getNumero()));
                    datosOp.add(op.getSupCalidad().getNombre() + " " + op.getSupCalidad().getApellido());
                    datosOp.add(op.getModel().getDescripcion());
                    datosOp.add(op.getColor().getDescripcion());

                }
            }
        }
        return datosOp;
    }
    public void pausarOP(int numeroOP){
        OrdenProduccion op = getOP(numeroOP);
        op.setEstado(OrdenProduccion.Estado.PAUSA);
    }
    public void reanudarOP(int numeroOP){
        OrdenProduccion op = getOP(numeroOP);
        op.setEstado(OrdenProduccion.Estado.INICIADA);
    }
    public void finalizarOP(int numeroOP){
        OrdenProduccion op = getOP(numeroOP);
        for (LineaTrabajo l : lineasDeTrabajo) {
            if (l.getEstado().toString().equals("NODISPONIBLE")) {
                if (l.getOp().getNumero() == numeroOP) {
                    op.setEstado(OrdenProduccion.Estado.FINALIZADA);
                    ordenesFinalizadas.add(op);
                    l.desocuparLinea();
                }
            }
        }

    }

    public OrdenProduccion getOP(int numero){
        OrdenProduccion op = null;
        for (LineaTrabajo l : lineasDeTrabajo) {
            if (l.getEstado().toString().equals("NODISPONIBLE")) {
                if (l.getOp().getNumero() == numero) {
                    op = l.getOp();
                }

            }
        }
        return op;
    }

    public ArrayList<Color> traerColoresModelo(Modelo m){
        ArrayList<Color> colors = null;
        colors = m.getColores();
        return colors;
    }


    /** ControladorAdmin **/
    public ArrayList<Modelo> traerModelos(){
        return modelos;
    }

    public Modelo getModelo(String sku){
        Modelo modelo = null;
        for (Modelo m : modelos){
            if (m.getSku().equals(sku)){
                modelo = m;
            }
        }
        return modelo;
    }

    public Color getColorPorCodigo(String codigo){
        Color c = null;
        for (Color cl : colores){
            if(cl.getCodigo().equals(codigo)){
                c = cl;
            }
        }
        return c;
    }
    public Color getColorPorDescripcion(String descripcion){
        Color c = null;
        for (Color cl : colores){
            if(cl.getDescripcion().equals(descripcion)){
                c = cl;
            }
        }
        return c;
    }

    public Modelo getModeloPorDescripcion(String descripcion){
        Modelo m = null;
        for (Modelo mo : modelos){
            if(mo.getDescripcion().equals(descripcion)){
                m = mo;
            }
        }
        return m;
    }
    public ArrayList<Color> getColoresDisponibles(){
        return colores;
    }
    public void agregarColorPaleta(Color c){
        colores.add(c);
    }
    public Boolean checkColorExist(Color c){
        Boolean var = false;
        for (Color co : colores){
            if (co.getCodigo().equals(c.getCodigo())){
                var = true;
            }
        }
        return var;
    }
    public Boolean checkModeloExist(Modelo m){
        Boolean var = false;
        for (Modelo mo : modelos){
            if (mo.getSku().equals(m.getSku())){
                var = true;
            }
        }
        return var;
    }

    public void quitarColorPaleta(Color c) {
        for (Modelo m : modelos) {
            if (m.getColores().contains(c)) {
                m.quitarColor(c);
            }
        }
        colores.remove(c);
    }
    public void quitarModelo(Modelo m){
        modelos.remove(m);
    }
    public void agregarModelo(Modelo m){
        modelos.add(m);
    }
    public Boolean chequearDisponibilidadLineas(){
        Boolean var = false;
        String estado;
        for (LineaTrabajo l : lineasDeTrabajo){
            estado = l.getEstado().toString();
            if (l.getEstado().toString().equals("DISPONIBLE")){
                var = true;
            }
        }
        return var;
    }

    public ArrayList<String> traerSupervisoresLibres(){
        ArrayList<String> supOcupados = new ArrayList<>();
        ArrayList<String> supLibres = new ArrayList<>();
        ArrayList<Usuario> supervisores = new ArrayList<>();
        int bandera = 0;
        for (Usuario u : users){
            if(u.getRol().toString().equals("SUPERCALIDAD")){
                supervisores.add(u);
            }
        }
        for (Usuario us : supervisores) {
            for (LineaTrabajo l : lineasDeTrabajo) {
                if (l.getEstado().toString().equals("NODISPONIBLE")) {
                    if(l.getOp().getSupCalidad().equals(us)) {
                        supOcupados.add(us.toString());
                    }
                    }
            }
        }
            if (supOcupados.isEmpty()){
                for (Usuario user : supervisores){
                    supLibres.add(user.toString());
                }
            }else {
                for (Usuario user : supervisores) {
                    for (String ocu : supOcupados) {
                        if (!user.toString().equals(ocu)) {
                            supLibres.add(user.toString());
                        }
                    }
                }
            }

                /*if (supOcupados!= null){
                    for (Usuario u : supervisores){
                    for (String so : supOcupados){
                        if(!(u.getNombre()+" "+u.getApellido()).equals(so)){
                            supLibres.add(u.getNombre()+" "+u.getApellido());
                        }
                    }
                }}*/
                return supLibres;

    }
    public ArrayList<String> traerLineasLibres(){
        ArrayList<String> lineasLibres = new ArrayList<>();
        for (LineaTrabajo l : lineasDeTrabajo){
            if(l.getEstado().toString().equals("DISPONIBLE")){
                lineasLibres.add(String.valueOf(l.getNumero()));
            }
        }
        return lineasLibres;
    }

    public void crearOP(ArrayList<String> datos){
        int linea = Integer.parseInt(datos.get(0));
        int numero = Integer.parseInt(datos.get(1));
        Usuario u = obtenerUsuario(datos.get(2));
        Modelo m = getModeloPorDescripcion(datos.get(3));
        Color c = getColorPorDescripcion(datos.get(4));
        Usuario sc = buscarSupCalidad(datos.get(5));
        OrdenProduccion op = new OrdenProduccion(numero, u, m, c, sc);
        for (LineaTrabajo l : lineasDeTrabajo){
            if(l.getNumero() == linea){
                l.ocuparLinea(op);
            }
        }

    }
    public Usuario buscarSupCalidad(String nombreCompleto){
        String[] partes = nombreCompleto.split(" ");
        String nombre = partes[0];
        String apellido = partes[1];
        Usuario u = buscarUsuarioPorNombreApellido(nombre,apellido);
        return u;

    }
    public Usuario buscarUsuarioPorNombreApellido(String nombre, String apellido){
        Usuario u = null;
        for (Usuario us : users){
            if (us.getApellido().equals(apellido)){
                if(us.getNombre().equals(nombre)){
                    u=us;
                }
            }
        }
        return u;
    }
}

