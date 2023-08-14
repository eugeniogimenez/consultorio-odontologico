package logica;

import java.util.ArrayList;
import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void crearUsuario(String nombreUsuario, String contrasenia, String rol) {

        Usuario usu = new Usuario();
        usu.setNombre_usuario(nombreUsuario);
        usu.setPassword(contrasenia);
        usu.setRol(rol);

        controlPersis.crearUsuario(usu);

    }

    public List<Usuario> getUsuarios() {

        return controlPersis.getUsuarios();

    }

    public void borrarUsuario(int id) {

        controlPersis.borrarUsuario(id);
    }

    public Usuario traerUsuario(int id) {

        return controlPersis.traerUsuario(id);
    }

    public void editarUsuario(Usuario usu) {

        controlPersis.editarUsuario(usu);
    }

    public boolean comprobarIngreso(String usuario, String password) {

        boolean ingreso = false;

        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = controlPersis.getUsuarios();

        for (Usuario usu : listaUsuarios) {

            if (usu.getNombre_usuario().equals(usuario)) {

                if (usu.getPassword().equals(password)) {

                    ingreso = true;
                } else {

                    ingreso = false;

                }
            }
        }
        return ingreso;
    }

}
