package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Recompensa;


public interface IRecompensaDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Recompensa> list();

    //Guardar un estudiante
    void save(Recompensa recompensa);

    //Obterner un estudiante en especifico a partir del id
    Recompensa getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
