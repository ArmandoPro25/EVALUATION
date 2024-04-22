package mx.utng.jarm.model.service;

import java.util.List;

import mx.utng.jarm.model.entity.Permiso;


public interface IPermisoService {
    List<Permiso> list();
    void save(Permiso permiso);
    Permiso getById(Long id);
    void delete(Long id);
}
