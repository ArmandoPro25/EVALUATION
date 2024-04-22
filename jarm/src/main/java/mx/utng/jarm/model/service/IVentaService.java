package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Venta;


public interface IVentaService {
    List<Venta> list();
    void save(Venta venta);
    Venta getById(Long id);
    void delete(Long id);
}
