package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Bitacora;


public interface IBitacoraService {
    List<Bitacora> list();
    void save(Bitacora bitacora);
    Bitacora getById(Long id);
    void delete(Long id);
}
