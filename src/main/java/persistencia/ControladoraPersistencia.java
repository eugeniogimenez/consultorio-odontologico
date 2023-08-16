package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Odontologo;
import logica.Paciente;
import logica.Turno;
import logica.Usuario;
import logica.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {

    HorarioJpaController horaJPA = new HorarioJpaController();
    ResponsableJpaController respJPA = new ResponsableJpaController();
    SecretarioJpaController secJPA = new SecretarioJpaController();

    OdontologoJpaController odontoJPA = new OdontologoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    UsuarioJpaController usuJPA = new UsuarioJpaController();
    PacienteJpaController pacientJPA = new PacienteJpaController();

    //USUARIO
    public void crearUsuario(Usuario usu) {

        usuJPA.create(usu);
    }

    public List<Usuario> getUsuarios() {

        return usuJPA.findUsuarioEntities();
    }

    public void borrarUsuario(int id) {
        try {
            usuJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario traerUsuario(int id) {

        return usuJPA.findUsuario(id);
    }

    public void editarUsuario(Usuario usu) {

        try {
            usuJPA.edit(usu);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //FIN USUARIO

    //PACIENTE
    public void crearPaciente(Paciente pacien) {

        pacientJPA.create(pacien);
    }

    public List<Paciente> getPacientes() {
        return pacientJPA.findPacienteEntities();
    }

    public void borrarPaciente(int id) {

        try {
            pacientJPA.destroy(id);
        } catch (persistencia.exceptions.NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Paciente traerPaciente(int id) {
        return pacientJPA.findPaciente(id);
    }

    public void editarPaciente(Paciente pacien) {

        try {
            pacientJPA.edit(pacien);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //FIN PACIENTE

    //TURNO
    public void crearTurno(Turno turno) {

        turnoJPA.create(turno);
    }

    public List<Turno> getTurnos() {
        return turnoJPA.findTurnoEntities();
    }

    public void borrarTurno(int id) {

        try {
            turnoJPA.destroy(id);
        } catch (persistencia.exceptions.NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Turno traerTurno(int id) {
        return turnoJPA.findTurno(id);
    }

    public void editarTurno(Turno turno) {

        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //FIN TURNO

    //ODONTOLOGO
    public void crearOdontologo(Odontologo odonto) {

        odontoJPA.create(odonto);
    }

    public List<Odontologo> getOdontologos() {
        return odontoJPA.findOdontologoEntities();
    }

    public void borrarOdontologo(int id) {

        try {
            odontoJPA.destroy(id);
        } catch (persistencia.exceptions.NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Odontologo traerOdontologo(int id) {
        return odontoJPA.findOdontologo(id);
    }

    public void editarOdontologo(Odontologo odonto) {

        try {
            odontoJPA.edit(odonto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //FIN ODONTOLOGO
}
