package mx.utng.jarm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.jarm.model.dao.IRecompensaDao;
import mx.utng.jarm.model.entity.Recompensa;
/*
 * Una clase service, esta basada en el patron de diseño facade.
 * Un unico punto de acceso hacia distintos DAOS (Datas and objects).
 * Dentro de la clase service podemos operar distintas clases DAO.
 */
@Service
public class RecompensaServiceImpl implements IRecompensaService{

    //Inyecta una interfaz para utilizar sus metodos
    @Autowired
    private IRecompensaDao recompensaDao;

    @Transactional(readOnly = true)
    @Override
    public List<Recompensa> list() {
        return recompensaDao.list();
    }

    @Transactional
    @Override
    public void save(Recompensa recompensa) {
        recompensaDao.save(recompensa);
    }

    @Transactional(readOnly = true)
    @Override
    public Recompensa getById(Long id) {
        return recompensaDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        recompensaDao.delete(id);
    }
    
}
