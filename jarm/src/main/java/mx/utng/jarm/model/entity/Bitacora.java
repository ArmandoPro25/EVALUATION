package mx.utng.jarm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Bitacora {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String nombreProyecto;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String descripcion;

    //GETTERS AND SETTERS

public String getDescripcion() {
    return descripcion;
}

public Long getId() {
    return id;
}

public String getNombreProyecto() {
    return nombreProyecto;
}

public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public void setId(Long id) {
    this.id = id;
}

public void setNombreProyecto(String nombreProyecto) {
    this.nombreProyecto = nombreProyecto;
}

}
