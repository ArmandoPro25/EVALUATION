package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Permiso;


public interface IPermisoDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Permiso> list();

    //Guardar un estudiante
    void save(Permiso permiso);

    //Obterner un estudiante en especifico a partir del id
    Permiso getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
