package mx.utng.jarm.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Recompensa {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String nombrePrograma;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String beneficios;

    //GETTERS AND SETTERS

public String getBeneficios() {
    return beneficios;
}

public Long getId() {
    return id;
}

public String getNombrePrograma() {
    return nombrePrograma;
}

public void setBeneficios(String beneficios) {
    this.beneficios = beneficios;
}

public void setId(Long id) {
    this.id = id;
}

public void setNombrePrograma(String nombrePrograma) {
    this.nombrePrograma = nombrePrograma;
}

}