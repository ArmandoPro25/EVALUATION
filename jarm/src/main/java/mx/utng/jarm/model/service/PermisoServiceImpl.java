package mx.utng.jarm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jarm.model.dao.IPermisoDao;
import mx.utng.jarm.model.entity.Permiso;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class PermisoServiceImpl implements IPermisoService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IPermisoDao permisoDao;

    @Transactional(readOnly = true)
    @Override
    public List<Permiso> list() {
        return permisoDao.list();
    }

    @Transactional
    @Override
    public void save(Permiso permiso) {
       permisoDao.save(permiso);
    }

    @Transactional(readOnly = true)
    @Override
    public Permiso getById(Long id) {
        return permisoDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        permisoDao.delete(id);
    }
    
}
