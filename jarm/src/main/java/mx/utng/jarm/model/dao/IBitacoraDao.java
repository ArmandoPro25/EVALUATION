package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Bitacora;


public interface IBitacoraDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Bitacora> list();

    //Guardar un estudiante
    void save(Bitacora bitacora);

    //Obterner un estudiante en especifico a partir del id
    Bitacora getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
