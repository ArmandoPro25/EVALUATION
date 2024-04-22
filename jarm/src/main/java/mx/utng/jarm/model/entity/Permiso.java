package mx.utng.jarm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Permiso {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String empleado;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String motivo;

    //GETTERS AND SETTERS

public String getEmpleado() {
    return empleado;
}
public Long getId() {
    return id;
}

public String getMotivo() {
    return motivo;
}
public void setEmpleado(String empleado) {
    this.empleado = empleado;
}
public void setId(Long id) {
    this.id = id;
}
public void setMotivo(String motivo) {
    this.motivo = motivo;
}


}
