package logica;

import java.time.LocalTime;
import java.util.Date;
import java.util.ArrayList;

import java.util.List;
import persistencia.ControladoraPersistencia;

public class ControladoraLogica {

    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    //USUARIO
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
    //FIN USUARIO

    //PACIENTE
    public void crearPaciente(String nombre, String apellido, boolean obraSocial) {
        Paciente paciente = new Paciente();

        paciente.setNombre(nombre);
        paciente.setApellido(apellido);
        paciente.setTiene_OS(obraSocial);

        controlPersis.crearPaciente(paciente);
    }

    public List<Paciente> getPacientes() {

        return controlPersis.getPacientes();

    }

    public void borrarPaciente(int id) {

        controlPersis.borrarPaciente(id);
    }

    public Paciente traerPaciente(int id) {

        return controlPersis.traerPaciente(id);
    }

    public void editarPaciente(Paciente pacien) {

        controlPersis.editarPaciente(pacien);
    }
    //FIN PACIENTE

    //TURNO
    public void crearTurno(Date fecha_turno, LocalTime hora_turno, String afeccion, Odontologo odonto, Paciente pacient) {
        Turno turno = new Turno();

        turno.setFecha_turno(fecha_turno);
        turno.setHora_turno(hora_turno);
        turno.setAfeccion(afeccion);
        turno.setOdonto(odonto);
        turno.setPacient(pacient);

        controlPersis.crearTurno(turno);
    }

    public List<Turno> getTurnos() {

        return controlPersis.getTurnos();

    }

    public void borrarTurno(int id) {

        controlPersis.borrarTurno(id);
    }

    public Turno traerTurno(int id) {

        return controlPersis.traerTurno(id);
    }

    public void editarTurno(Turno turno) {

        controlPersis.editarTurno(turno);
    }
    //FIN TURNO

    //ODONTOLOGO
    public void crearOdontologo(String nombre, String apellido) {
        Odontologo odonto = new Odontologo();

        odonto.setNombre(nombre);
        odonto.setApellido(apellido);

        controlPersis.crearOdontologo(odonto);
    }

    public List<Odontologo> getOdontologos() {

        return controlPersis.getOdontologos();

    }

    public void borrarOdontologo(int id) {

        controlPersis.borrarOdontologo(id);
    }

    public Odontologo traerOdontologo(int id) {

        return controlPersis.traerOdontologo(id);
    }

    public void editarOdontologo(Odontologo pacien) {

        controlPersis.editarOdontologo(pacien);
    }
    //FIN ODONTOLOGO

}
