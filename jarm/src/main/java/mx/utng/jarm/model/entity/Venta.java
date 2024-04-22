package mx.utng.jarm.model.entity;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Venta {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date fechaVenta;

    @PrePersist
    public void PrePersist(){
        fechaVenta = new Date();
    }

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String cliente;

    @Column (length = 100, nullable = false)
    @NotEmpty
    private String producto;

    @Column (length = 40, nullable = false)
    @NotEmpty
    private String cantidad;
 
    //GETTERS AND SETTERS
    public String getCantidad() {
        return cantidad;
    }

    public String getCliente() {
        return cliente;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public Long getId() {
        return id;
    }

    public String getProducto() {
        return producto;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }
    
}
