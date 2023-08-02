package logica;

import java.util.Date;
import javax.persistence.Entity;

@Entity
public class Responsable extends Persona {

    //private int id_responsable;
    private String tipo_responsabilidad;

    //RELACIONES
    //La tiene con Paciente, pero en Paciente ya está. Es unidireccional
    public Responsable() {
    }

    public Responsable(int id, String dni, String nombre, String apellido, String telefono, String direccion, Date fecha_nac) {
        super(id, dni, nombre, apellido, telefono, direccion, fecha_nac);
    }

}
