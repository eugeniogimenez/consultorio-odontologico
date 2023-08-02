package logica;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Odontologo extends Persona implements Serializable {

    //private int id_odontologo;
    private String especialidad;

    //RELACIONES
    @OneToMany(mappedBy = "odonto")//odonto se mapea en la tabla turnos
    private List<Turno> listaTurnos; //con clase Turnos

    @OneToOne //relacion 1 a 1 entre Odontologo y Usuario
    private Usuario unUsuario; //con clase Usuario

    @OneToOne //relacion 1 a 1 entre Odontologo y Horario
    private Horario unHorario; //con clase Usuario

    public Odontologo() {
    }

    public Odontologo(String especialidad, List<Turno> listaTurnos, Usuario unUsuario, Horario unHorario, int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);//hereda el id de Persona
        this.especialidad = especialidad;
        this.listaTurnos = listaTurnos;
        this.unUsuario = unUsuario;
        this.unHorario = unHorario;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public List<Turno> getListaTurnos() {
        return listaTurnos;
    }

    public void setListaTurnos(List<Turno> listaTurnos) {
        this.listaTurnos = listaTurnos;
    }

    public Horario getUnHorario() {
        return unHorario;
    }

    public void setUnHorario(Horario unHorario) {
        this.unHorario = unHorario;
    }

}
