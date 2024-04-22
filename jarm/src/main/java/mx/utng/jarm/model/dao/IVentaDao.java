package mx.utng.jarm.model.dao;

import java.util.List;

import mx.utng.jarm.model.entity.Venta;


public interface IVentaDao {
    //Estos metodos son abstractos no tienen cuerpo
    
    //Listar estudiantes
    List<Venta> list();

    //Guardar un estudiante
    void save(Venta venta);

    Venta getById(Long id);

    //Eliminar un estudiante por el id
    void delete(Long id);
}
